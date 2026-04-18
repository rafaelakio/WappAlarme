package br.com.wappalarme.data.local

import androidx.room.*
import br.com.wappalarme.data.model.MessageStatus
import br.com.wappalarme.data.model.ScheduledMessageEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduledMessageDao {

    @Query("SELECT * FROM scheduled_messages ORDER BY scheduledAt ASC")
    fun getAllMessages(): Flow<List<ScheduledMessageEntity>>

    @Query("SELECT * FROM scheduled_messages WHERE status = 'PENDING' ORDER BY scheduledAt ASC")
    fun getPendingMessages(): Flow<List<ScheduledMessageEntity>>

    @Query("SELECT * FROM scheduled_messages WHERE id = :id")
    suspend fun getMessageById(id: Long): ScheduledMessageEntity?

    @Query("SELECT * FROM scheduled_messages WHERE status = 'PENDING' AND scheduledAt <= :now")
    suspend fun getOverdueMessages(now: Long = System.currentTimeMillis()): List<ScheduledMessageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMessage(message: ScheduledMessageEntity): Long

    @Update
    suspend fun updateMessage(message: ScheduledMessageEntity)

    @Delete
    suspend fun deleteMessage(message: ScheduledMessageEntity)

    @Query("UPDATE scheduled_messages SET status = :status, workerId = :workerId WHERE id = :id")
    suspend fun updateMessageStatus(id: Long, status: MessageStatus, workerId: String?)

    @Query("UPDATE scheduled_messages SET status = 'SENT', sentAt = :sentAt WHERE id = :id")
    suspend fun markAsSent(id: Long, sentAt: Long = System.currentTimeMillis())

    @Query("UPDATE scheduled_messages SET status = 'FAILED', errorMessage = :error WHERE id = :id")
    suspend fun markAsFailed(id: Long, error: String)

    @Query("UPDATE scheduled_messages SET status = 'CANCELLED' WHERE id = :id")
    suspend fun cancelMessage(id: Long)

    @Query("SELECT COUNT(*) FROM scheduled_messages WHERE status = 'PENDING'")
    fun getPendingCount(): Flow<Int>
}
