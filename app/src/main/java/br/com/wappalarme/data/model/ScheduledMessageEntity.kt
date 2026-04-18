package br.com.wappalarme.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa uma mensagem WhatsApp agendada.
 */
@Entity(tableName = "scheduled_messages")
data class ScheduledMessageEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    /** Nome do contato destinatário */
    val contactName: String,

    /** Número de telefone do destinatário (formato internacional: +5511999999999) */
    val phoneNumber: String,

    /** Conteúdo da mensagem */
    val message: String,

    /** Timestamp Unix (ms) do momento agendado para envio */
    val scheduledAt: Long,

    /** Status atual da mensagem */
    val status: MessageStatus = MessageStatus.PENDING,

    /** ID do WorkManager job para cancelamento */
    val workerId: String? = null,

    /** Data/hora de criação */
    val createdAt: Long = System.currentTimeMillis(),

    /** Data/hora do envio efetivo (preenchido após envio) */
    val sentAt: Long? = null,

    /** Mensagem de erro caso o envio falhe */
    val errorMessage: String? = null
)

enum class MessageStatus {
    PENDING,    // Aguardando envio
    SENDING,    // Em processo de envio
    SENT,       // Enviada com sucesso
    FAILED,     // Falhou no envio
    CANCELLED   // Cancelada pelo usuário
}
