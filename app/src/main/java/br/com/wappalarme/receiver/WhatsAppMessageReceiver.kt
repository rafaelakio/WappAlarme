package br.com.wappalarme.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import br.com.wappalarme.data.repository.AlarmRepository
import br.com.wappalarme.service.AlarmManagerService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Receiver para ações de notificação relacionadas a alarmes e feriados.
 * Processa as respostas do usuário nas notificações de feriado.
 */
@AndroidEntryPoint
class WhatsAppMessageReceiver : BroadcastReceiver() {

    @Inject
    lateinit var alarmRepository: AlarmRepository

    @Inject
    lateinit var alarmManagerService: AlarmManagerService

    override fun onReceive(context: Context, intent: Intent) {
        val pendingResult = goAsync()

        CoroutineScope(Dispatchers.IO).launch {
            try {
                when (intent.action) {
                    ACTION_DISABLE_ALARMS_FOR_HOLIDAY -> {
                        // Usuário escolheu desativar alarmes para o feriado
                        alarmRepository.disableAlarmsForHoliday()
                    }
                    ACTION_KEEP_ALARMS_ACTIVE -> {
                        // Usuário escolheu manter alarmes ativos — não faz nada
                    }
                    ACTION_REENABLE_ALARMS -> {
                        // Reativa alarmes desativados por feriado
                        alarmRepository.reEnableHolidayAlarms()
                    }
                }
            } finally {
                pendingResult.finish()
            }
        }
    }

    companion object {
        const val ACTION_DISABLE_ALARMS_FOR_HOLIDAY = "br.com.wappalarme.ACTION_DISABLE_ALARMS"
        const val ACTION_KEEP_ALARMS_ACTIVE = "br.com.wappalarme.ACTION_KEEP_ALARMS"
        const val ACTION_REENABLE_ALARMS = "br.com.wappalarme.ACTION_REENABLE_ALARMS"
    }
}
