package br.com.wappalarme.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.AlarmClock
import br.com.wappalarme.data.model.AlarmEntity
import br.com.wappalarme.receiver.HolidayCheckReceiver
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Serviço responsável por interagir com o AlarmManager do Android
 * e com o app de relógio nativo do dispositivo.
 */
@Singleton
class AlarmManagerService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    /**
     * Cria um alarme no app de relógio nativo do Android.
     * Usa ACTION_SET_ALARM para integração com o relógio do Samsung.
     */
    fun createSystemAlarm(alarm: AlarmEntity) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_HOUR, alarm.hour)
            putExtra(AlarmClock.EXTRA_MINUTES, alarm.minute)
            putExtra(AlarmClock.EXTRA_MESSAGE, alarm.label)
            putExtra(AlarmClock.EXTRA_SKIP_UI, false) // Mostra UI do relógio
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            // Configura dias da semana se for alarme recorrente
            if (alarm.daysOfWeek > 0) {
                val days = getDaysFromBitmask(alarm.daysOfWeek)
                putIntegerArrayListExtra(AlarmClock.EXTRA_DAYS, ArrayList(days))
            }
        }
        context.startActivity(intent)
    }

    /**
     * Desativa um alarme no app de relógio nativo.
     * Usa ACTION_DISMISS_ALARM para desativar pelo label.
     */
    fun dismissSystemAlarm(alarm: AlarmEntity) {
        val intent = Intent(AlarmClock.ACTION_DISMISS_ALARM).apply {
            putExtra(AlarmClock.EXTRA_ALARM_SEARCH_MODE, AlarmClock.ALARM_SEARCH_MODE_LABEL)
            putExtra(AlarmClock.EXTRA_MESSAGE, alarm.label)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    /**
     * Abre o app de relógio do dispositivo.
     */
    fun openClockApp() {
        val intent = Intent(AlarmClock.ACTION_SHOW_ALARMS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            // Fallback: abre o app de relógio genérico
            val fallback = context.packageManager.getLaunchIntentForPackage("com.samsung.android.app.clockpackage")
                ?: context.packageManager.getLaunchIntentForPackage("com.android.deskclock")
            fallback?.let {
                it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(it)
            }
        }
    }

    /**
     * Agenda a verificação diária de feriados.
     * Dispara todos os dias no horário configurado pelo usuário.
     * @param hour Hora do disparo (0-23)
     * @param minute Minuto do disparo (0-59)
     */
    fun scheduleHolidayCheck(hour: Int, minute: Int) {
        val intent = Intent(context, HolidayCheckReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            HOLIDAY_CHECK_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            // Se o horário já passou hoje, agenda para amanhã
            if (timeInMillis <= System.currentTimeMillis()) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S && alarmManager.canScheduleExactAlarms()) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        } else {
            alarmManager.setAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }

    /**
     * Cancela a verificação de feriados agendada.
     */
    fun cancelHolidayCheck() {
        val intent = Intent(context, HolidayCheckReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            HOLIDAY_CHECK_REQUEST_CODE,
            intent,
            PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_IMMUTABLE
        )
        pendingIntent?.let { alarmManager.cancel(it) }
    }

    /**
     * Converte bitmask de dias da semana para lista de constantes Calendar.
     * Bitmask: 1=Dom, 2=Seg, 4=Ter, 8=Qua, 16=Qui, 32=Sex, 64=Sab
     */
    private fun getDaysFromBitmask(bitmask: Int): List<Int> {
        val days = mutableListOf<Int>()
        if (bitmask and 1 != 0) days.add(Calendar.SUNDAY)
        if (bitmask and 2 != 0) days.add(Calendar.MONDAY)
        if (bitmask and 4 != 0) days.add(Calendar.TUESDAY)
        if (bitmask and 8 != 0) days.add(Calendar.WEDNESDAY)
        if (bitmask and 16 != 0) days.add(Calendar.THURSDAY)
        if (bitmask and 32 != 0) days.add(Calendar.FRIDAY)
        if (bitmask and 64 != 0) days.add(Calendar.SATURDAY)
        return days
    }

    companion object {
        private const val HOLIDAY_CHECK_REQUEST_CODE = 9001
    }
}
