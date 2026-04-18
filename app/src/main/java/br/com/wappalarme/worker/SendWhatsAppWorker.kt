package br.com.wappalarme.worker

import android.content.Context
import android.content.Intent
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import br.com.wappalarme.data.repository.ScheduledMessageRepository
import br.com.wappalarme.service.WappAccessibilityService
import br.com.wappalarme.service.WhatsAppService
import br.com.wappalarme.util.NotificationHelper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

/**
 * Worker do WorkManager responsável por disparar o envio de mensagens WhatsApp
 * no horário agendado (funciona como um cron job).
 *
 * O WorkManager garante execução mesmo após reinicialização do dispositivo.
 */
@HiltWorker
class SendWhatsAppWorker @AssistedInject constructor(
    @Assisted private val context: Context,
    @Assisted workerParams: WorkerParameters,
    private val repository: ScheduledMessageRepository,
    private val whatsAppService: WhatsAppService,
    private val notificationHelper: NotificationHelper
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        val messageId = inputData.getLong(KEY_MESSAGE_ID, -1L)
        if (messageId == -1L) return Result.failure()

        val message = repository.getMessageById(messageId) ?: return Result.failure()

        return try {
            // Marca como "enviando"
            repository.updateStatus(messageId, br.com.wappalarme.data.model.MessageStatus.SENDING)

            // Verifica se o WhatsApp está instalado
            if (!whatsAppService.isWhatsAppInstalled()) {
                repository.markAsFailed(messageId, "WhatsApp não está instalado")
                notificationHelper.showMessageFailedNotification(
                    message.contactName,
                    "WhatsApp não está instalado"
                )
                return Result.failure()
            }

            // Dispara o AccessibilityService para auto-envio
            val accessibilityIntent = Intent(context, WappAccessibilityService::class.java).apply {
                action = WappAccessibilityService.ACTION_TRIGGER_SEND
            }
            context.startService(accessibilityIntent)

            // Abre o WhatsApp com a mensagem pré-preenchida
            whatsAppService.sendMessageViaAccessibility(message.phoneNumber, message.message)

            // Marca como enviada (o AccessibilityService fará o clique real)
            repository.markAsSent(messageId)

            // Notifica o usuário
            notificationHelper.showMessageSentNotification(message.contactName, message.message)

            Result.success()
        } catch (e: Exception) {
            val errorMsg = e.message ?: "Erro desconhecido"
            repository.markAsFailed(messageId, errorMsg)
            notificationHelper.showMessageFailedNotification(message.contactName, errorMsg)

            // Tenta novamente até 3 vezes
            if (runAttemptCount < 3) Result.retry() else Result.failure()
        }
    }

    companion object {
        const val KEY_MESSAGE_ID = "message_id"
        const val WORK_TAG = "send_whatsapp"
    }
}
