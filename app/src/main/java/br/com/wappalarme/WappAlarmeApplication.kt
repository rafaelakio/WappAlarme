package br.com.wappalarme

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class WappAlarmeApplication : Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        createNotificationChannels()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(NotificationManager::class.java)

            // Canal para alertas de feriado
            val holidayChannel = NotificationChannel(
                CHANNEL_HOLIDAY,
                "Alertas de Feriado",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Notificações sobre feriados e alarmes"
                enableVibration(true)
            }

            // Canal para mensagens WhatsApp agendadas
            val whatsappChannel = NotificationChannel(
                CHANNEL_WHATSAPP,
                "Mensagens WhatsApp Agendadas",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Status de envio de mensagens agendadas"
            }

            // Canal para serviço em foreground
            val serviceChannel = NotificationChannel(
                CHANNEL_SERVICE,
                "Serviço em Execução",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Serviço de agendamento ativo"
            }

            notificationManager.createNotificationChannels(
                listOf(holidayChannel, whatsappChannel, serviceChannel)
            )
        }
    }

    companion object {
        const val CHANNEL_HOLIDAY = "channel_holiday"
        const val CHANNEL_WHATSAPP = "channel_whatsapp"
        const val CHANNEL_SERVICE = "channel_service"
    }
}
