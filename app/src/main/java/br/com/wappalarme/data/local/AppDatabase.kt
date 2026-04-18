package br.com.wappalarme.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.wappalarme.data.model.AlarmEntity
import br.com.wappalarme.data.model.ScheduledMessageEntity
import br.com.wappalarme.data.model.UserConfig

@Database(
    entities = [
        AlarmEntity::class,
        ScheduledMessageEntity::class,
        UserConfig::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun alarmDao(): AlarmDao
    abstract fun scheduledMessageDao(): ScheduledMessageDao
    abstract fun userConfigDao(): UserConfigDao
}
