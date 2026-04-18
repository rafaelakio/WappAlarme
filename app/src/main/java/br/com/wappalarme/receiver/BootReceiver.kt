package br.com.wappalarme.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.wappalarme.data.repository.UserConfigRepository
import br.com.wappalarme.service.AlarmManagerService
import br.com.wappalarme.worker.MessageSchedulerService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Receiver disparado quando o dispositivo é reiniciado.
 * Responsável por reagendar alarmes e mensagens WhatsApp pendentes.
 */
@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {

    @Inject
    lateinit var alarmManagerService: AlarmManagerService

    @Inject
    lateinit var messageSchedulerService: MessageSchedulerService

    @Inject
    lateinit var userConfigRepository: UserConfigRepository

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED &&
            intent.action != "android.intent.action.LOCKED_BOOT_COMPLETED") return

        val pendingResult = goAsync()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                // Reagenda verificação de feriados
                val config = userConfigRepository.getOrDefault()
                if (config.holidayNotificationsEnabled && config.holidayCheckTime.isNotEmpty()) {
                    val parts = config.holidayCheckTime.split(":")
                    if (parts.size == 2) {
                        alarmManagerService.scheduleHolidayCheck(
                            hour = parts[0].toIntOrNull() ?: 20,
                            minute = parts[1].toIntOrNull() ?: 0
                        )
                    }
                }

                // Reagenda mensagens WhatsApp pendentes
                messageSchedulerService.rescheduleAllPending()

            } finally {
                pendingResult.finish()
            }
        }
    }
}
