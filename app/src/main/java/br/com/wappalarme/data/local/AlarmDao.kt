package br.com.wappalarme.data.local

import androidx.room.*
import br.com.wappalarme.data.model.AlarmEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AlarmDao {

    @Query("SELECT * FROM alarms ORDER BY hour ASC, minute ASC")
    fun getAllAlarms(): Flow<List<AlarmEntity>>

    @Query("SELECT * FROM alarms WHERE id = :id")
    suspend fun getAlarmById(id: Long): AlarmEntity?

    @Query("SELECT * FROM alarms WHERE isEnabled = 1")
    suspend fun getEnabledAlarms(): List<AlarmEntity>

    @Query("SELECT * FROM alarms WHERE disabledForHoliday = 1")
    suspend fun getHolidayDisabledAlarms(): List<AlarmEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarm: AlarmEntity): Long

    @Update
    suspend fun updateAlarm(alarm: AlarmEntity)

    @Delete
    suspend fun deleteAlarm(alarm: AlarmEntity)

    @Query("UPDATE alarms SET isEnabled = :enabled, disabledForHoliday = :disabledForHoliday, holidayDisabledDate = :date WHERE id = :id")
    suspend fun updateAlarmStatus(id: Long, enabled: Boolean, disabledForHoliday: Boolean, date: String?)

    @Query("UPDATE alarms SET isEnabled = 1, disabledForHoliday = 0, holidayDisabledDate = NULL WHERE disabledForHoliday = 1")
    suspend fun reEnableHolidayAlarms()

    @Query("DELETE FROM alarms")
    suspend fun deleteAll()
}
