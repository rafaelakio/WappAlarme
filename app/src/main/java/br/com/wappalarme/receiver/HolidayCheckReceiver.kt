package br.com.wappalarme.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.wappalarme.data.repository.HolidayRepository
import br.com.wappalarme.data.repository.UserConfigRepository
import br.com.wappalarme.service.AlarmManagerService
import br.com.wappalarme.util.NotificationHelper
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

/**
 * Receiver disparado diariamente para verificar se o dia seguinte é feriado.
 * Quando detecta um feriado, envia uma notificação perguntando ao usuário
 * se deseja manter ou desativar os alarmes do próximo dia.
 */
@AndroidEntryPoint
class HolidayCheckReceiver : BroadcastReceiver() {

    @Inject
    lateinit var holidayRepository: HolidayRepository

    @Inject
    lateinit var userConfigRepository: UserConfigRepository

    @Inject
    lateinit var alarmManagerService: AlarmManagerService

    @Inject
    lateinit var notificationHelper: NotificationHelper

    override fun onReceive(context: Context, intent: Intent) {
        val pendingResult = goAsync()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val config = userConfigRepository.getOrDefault()
                val today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)

                // Evita verificação duplicada no mesmo dia
                if (config.lastHolidayCheckDate == today) {
                    return@launch
                }

                // Verifica se amanhã é feriado
                val tomorrowHoliday = holidayRepository.isTomorrowHoliday()

                if (tomorrowHoliday != null) {
                    // Envia notificação com ações de manter/desativar alarmes
                    notificationHelper.showHolidayAlarmNotification(
                        holidayName = tomorrowHoliday.name,
                        holidayDate = tomorrowHoliday.date
                    )
                }

                // Atualiza data da última verificação
                userConfigRepository.updateLastCheckDate(today)

                // Reagenda para o próximo dia
                val parts = config.holidayCheckTime.split(":")
                alarmManagerService.scheduleHolidayCheck(
                    hour = parts[0].toIntOrNull() ?: 20,
                    minute = parts[1].toIntOrNull() ?: 0
                )

            } finally {
                pendingResult.finish()
            }
        }
    }
}
