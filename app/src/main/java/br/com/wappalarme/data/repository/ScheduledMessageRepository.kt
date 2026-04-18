package br.com.wappalarme.data.repository

import br.com.wappalarme.data.local.ScheduledMessageDao
import br.com.wappalarme.data.model.MessageStatus
import br.com.wappalarme.data.model.ScheduledMessageEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduledMessageRepository @Inject constructor(
    private val dao: ScheduledMessageDao
) {
    fun getAllMessages(): Flow<List<ScheduledMessageEntity>> = dao.getAllMessages()

    fun getPendingMessages(): Flow<List<ScheduledMessageEntity>> = dao.getPendingMessages()

    fun getPendingCount(): Flow<Int> = dao.getPendingCount()

    suspend fun getMessageById(id: Long): ScheduledMessageEntity? = dao.getMessageById(id)

    suspend fun saveMessage(message: ScheduledMessageEntity): Long = dao.insertMessage(message)

    suspend fun updateMessage(message: ScheduledMessageEntity) = dao.updateMessage(message)

    suspend fun deleteMessage(message: ScheduledMessageEntity) = dao.deleteMessage(message)

    suspend fun updateStatus(id: Long, status: MessageStatus, workerId: String? = null) =
        dao.updateMessageStatus(id, status, workerId)

    suspend fun markAsSent(id: Long) = dao.markAsSent(id)

    suspend fun markAsFailed(id: Long, error: String) = dao.markAsFailed(id, error)

    suspend fun cancelMessage(id: Long) = dao.cancelMessage(id)

    suspend fun getOverdueMessages(): List<ScheduledMessageEntity> = dao.getOverdueMessages()
}
