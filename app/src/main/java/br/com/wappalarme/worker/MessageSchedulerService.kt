package br.com.wappalarme.worker

import androidx.work.*
import br.com.wappalarme.data.model.MessageStatus
import br.com.wappalarme.data.model.ScheduledMessageEntity
import br.com.wappalarme.data.repository.ScheduledMessageRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Serviço responsável por agendar e cancelar jobs do WorkManager
 * para envio de mensagens WhatsApp.
 */
@Singleton
class MessageSchedulerService @Inject constructor(
    private val workManager: WorkManager,
    private val repository: ScheduledMessageRepository
) {
    /**
     * Agenda o envio de uma mensagem no horário especificado.
     * Cria um OneTimeWorkRequest com delay calculado até o horário alvo.
     *
     * @param message Mensagem a ser agendada
     * @return ID do trabalho agendado
     */
    suspend fun scheduleMessage(message: ScheduledMessageEntity): String {
        val delayMs = message.scheduledAt - System.currentTimeMillis()

        if (delayMs <= 0) {
            // Mensagem já passou do horário — agenda para execução imediata
            return scheduleImmediate(message)
        }

        val inputData = workDataOf(
            SendWhatsAppWorker.KEY_MESSAGE_ID to message.id
        )

        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_REQUIRED) // WhatsApp pode funcionar offline
            .build()

        val workRequest = OneTimeWorkRequestBuilder<SendWhatsAppWorker>()
            .setInputData(inputData)
            .setInitialDelay(delayMs, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(SendWhatsAppWorker.WORK_TAG)
            .addTag("message_${message.id}")
            .setBackoffCriteria(BackoffPolicy.LINEAR, 30, TimeUnit.SECONDS)
            .build()

        workManager.enqueueUniqueWork(
            "message_${message.id}",
            ExistingWorkPolicy.REPLACE,
            workRequest
        )

        val workerId = workRequest.id.toString()
        repository.updateStatus(message.id, MessageStatus.PENDING, workerId)

        return workerId
    }

    /**
     * Agenda envio imediato (para mensagens com horário já passado).
     */
    private suspend fun scheduleImmediate(message: ScheduledMessageEntity): String {
        val inputData = workDataOf(
            SendWhatsAppWorker.KEY_MESSAGE_ID to message.id
        )

        val workRequest = OneTimeWorkRequestBuilder<SendWhatsAppWorker>()
            .setInputData(inputData)
            .addTag(SendWhatsAppWorker.WORK_TAG)
            .addTag("message_${message.id}")
            .build()

        workManager.enqueueUniqueWork(
            "message_${message.id}",
            ExistingWorkPolicy.REPLACE,
            workRequest
        )

        val workerId = workRequest.id.toString()
        repository.updateStatus(message.id, MessageStatus.PENDING, workerId)

        return workerId
    }

    /**
     * Cancela o agendamento de uma mensagem.
     * @param messageId ID da mensagem no banco de dados
     */
    suspend fun cancelMessage(messageId: Long) {
        workManager.cancelUniqueWork("message_$messageId")
        repository.cancelMessage(messageId)
    }

    /**
     * Reagenda todas as mensagens pendentes (usado após reinicialização do dispositivo).
     */
    suspend fun rescheduleAllPending() {
        val overdueMessages = repository.getOverdueMessages()
        overdueMessages.forEach { message ->
            scheduleMessage(message)
        }
    }
}
