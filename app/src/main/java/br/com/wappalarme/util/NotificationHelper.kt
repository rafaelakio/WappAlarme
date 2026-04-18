package br.com.wappalarme.util

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import br.com.wappalarme.R
import br.com.wappalarme.WappAlarmeApplication
import br.com.wappalarme.receiver.WhatsAppMessageReceiver
import br.com.wappalarme.ui.MainActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotificationHelper @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val notificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    /**
     * Exibe notificação de feriado com ações para manter ou desativar alarmes.
     */
    fun showHolidayAlarmNotification(holidayName: String, holidayDate: String) {
        // Intent para desativar alarmes
        val disableIntent = Intent(context, WhatsAppMessageReceiver::class.java).apply {
            action = WhatsAppMessageReceiver.ACTION_DISABLE_ALARMS_FOR_HOLIDAY
        }
        val disablePendingIntent = PendingIntent.getBroadcast(
            context, 1001, disableIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Intent para manter alarmes
        val keepIntent = Intent(context, WhatsAppMessageReceiver::class.java).apply {
            action = WhatsAppMessageReceiver.ACTION_KEEP_ALARMS_ACTIVE
        }
        val keepPendingIntent = PendingIntent.getBroadcast(
            context, 1002, keepIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Intent para abrir o app
        val openAppIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val openAppPendingIntent = PendingIntent.getActivity(
            context, 1003, openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, WappAlarmeApplication.CHANNEL_HOLIDAY)
            .setSmallIcon(R.drawable.ic_alarm_notification)
            .setContentTitle("🎉 Feriado amanhã: $holidayName")
            .setContentText("Deseja desativar seus alarmes para amanhã?")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Amanhã ($holidayDate) é $holidayName. Deseja desativar seus alarmes? Eles serão reativados no próximo dia útil.")
            )
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(openAppPendingIntent)
            .addAction(
                R.drawable.ic_alarm_off,
                "Desativar alarmes",
                disablePendingIntent
            )
            .addAction(
                R.drawable.ic_alarm_on,
                "Manter ativos",
                keepPendingIntent
            )
            .build()

        notificationManager.notify(NOTIFICATION_HOLIDAY, notification)
    }

    /**
     * Notificação de mensagem enviada com sucesso.
     */
    fun showMessageSentNotification(contactName: String, message: String) {
        val notification = NotificationCompat.Builder(context, WappAlarmeApplication.CHANNEL_WHATSAPP)
            .setSmallIcon(R.drawable.ic_whatsapp)
            .setContentTitle("✅ Mensagem enviada para $contactName")
            .setContentText(message.take(100))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }

    /**
     * Notificação de falha no envio de mensagem.
     */
    fun showMessageFailedNotification(contactName: String, error: String) {
        val openAppIntent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
        }
        val pendingIntent = PendingIntent.getActivity(
            context, 0, openAppIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, WappAlarmeApplication.CHANNEL_WHATSAPP)
            .setSmallIcon(R.drawable.ic_whatsapp)
            .setContentTitle("❌ Falha ao enviar para $contactName")
            .setContentText(error)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }

    companion object {
        const val NOTIFICATION_HOLIDAY = 2001
    }
}
