package br.com.wappalarme.di

import android.content.Context
import androidx.room.Room
import br.com.wappalarme.data.local.AlarmDao
import br.com.wappalarme.data.local.AppDatabase
import br.com.wappalarme.data.local.ScheduledMessageDao
import br.com.wappalarme.data.local.UserConfigDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "wapp_alarme_db"
        ).build()
    }

    @Provides
    fun provideAlarmDao(db: AppDatabase): AlarmDao = db.alarmDao()

    @Provides
    fun provideScheduledMessageDao(db: AppDatabase): ScheduledMessageDao = db.scheduledMessageDao()

    @Provides
    fun provideUserConfigDao(db: AppDatabase): UserConfigDao = db.userConfigDao()
}
