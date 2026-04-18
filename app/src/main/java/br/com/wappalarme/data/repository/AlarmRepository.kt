package br.com.wappalarme.data.repository

import br.com.wappalarme.data.local.AlarmDao
import br.com.wappalarme.data.model.AlarmEntity
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlarmRepository @Inject constructor(
    private val alarmDao: AlarmDao
) {
    fun getAllAlarms(): Flow<List<AlarmEntity>> = alarmDao.getAllAlarms()

    suspend fun getAlarmById(id: Long): AlarmEntity? = alarmDao.getAlarmById(id)

    suspend fun getEnabledAlarms(): List<AlarmEntity> = alarmDao.getEnabledAlarms()

    suspend fun saveAlarm(alarm: AlarmEntity): Long = alarmDao.insertAlarm(alarm)

    suspend fun updateAlarm(alarm: AlarmEntity) = alarmDao.updateAlarm(alarm)

    suspend fun deleteAlarm(alarm: AlarmEntity) = alarmDao.deleteAlarm(alarm)

    /**
     * Desativa todos os alarmes ativos por motivo de feriado.
     * Registra a data do feriado para reativação posterior.
     */
    suspend fun disableAlarmsForHoliday() {
        val today = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)
        val enabledAlarms = alarmDao.getEnabledAlarms()
        enabledAlarms.forEach { alarm ->
            alarmDao.updateAlarmStatus(
                id = alarm.id,
                enabled = false,
                disabledForHoliday = true,
                date = today
            )
        }
    }

    /**
     * Reativa todos os alarmes que foram desativados por feriado.
     */
    suspend fun reEnableHolidayAlarms() = alarmDao.reEnableHolidayAlarms()

    /**
     * Retorna alarmes desativados por feriado.
     */
    suspend fun getHolidayDisabledAlarms(): List<AlarmEntity> =
        alarmDao.getHolidayDisabledAlarms()
}
