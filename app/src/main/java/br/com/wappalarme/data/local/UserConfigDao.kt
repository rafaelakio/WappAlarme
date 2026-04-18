package br.com.wappalarme.data.local

import androidx.room.*
import br.com.wappalarme.data.model.UserConfig
import kotlinx.coroutines.flow.Flow

@Dao
interface UserConfigDao {

    @Query("SELECT * FROM user_config WHERE id = 1")
    fun getConfig(): Flow<UserConfig?>

    @Query("SELECT * FROM user_config WHERE id = 1")
    suspend fun getConfigOnce(): UserConfig?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveConfig(config: UserConfig)

    @Query("UPDATE user_config SET lastHolidayCheckDate = :date WHERE id = 1")
    suspend fun updateLastCheckDate(date: String)
}
