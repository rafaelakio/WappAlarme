package br.com.wappalarme.ui.message

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wappalarme.data.model.MessageStatus
import br.com.wappalarme.data.model.ScheduledMessageEntity
import br.com.wappalarme.data.repository.ScheduledMessageRepository
import br.com.wappalarme.worker.MessageSchedulerService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScheduledMessageViewModel @Inject constructor(
    private val repository: ScheduledMessageRepository,
    private val schedulerService: MessageSchedulerService
) : ViewModel() {

    val allMessages = repository.getAllMessages()
    val pendingMessages = repository.getPendingMessages()
    val pendingCount = repository.getPendingCount()

    private val _uiState = MutableStateFlow<MessageUiState>(MessageUiState.Idle)
    val uiState: StateFlow<MessageUiState> = _uiState.asStateFlow()

    /**
     * Agenda uma nova mensagem WhatsApp.
     */
    fun scheduleMessage(
        contactName: String,
        phoneNumber: String,
        message: String,
        scheduledAt: Long
    ) {
        if (contactName.isBlank()) {
            _uiState.value = MessageUiState.Error("Selecione um contato")
            return
        }
        if (phoneNumber.isBlank()) {
            _uiState.value = MessageUiState.Error("Número de telefone inválido")
            return
        }
        if (message.isBlank()) {
            _uiState.value = MessageUiState.Error("Digite uma mensagem")
            return
        }
        if (scheduledAt <= System.currentTimeMillis()) {
            _uiState.value = MessageUiState.Error("Selecione uma data/hora futura")
            return
        }

        viewModelScope.launch {
            try {
                _uiState.value = MessageUiState.Loading

                val entity = ScheduledMessageEntity(
                    contactName = contactName,
                    phoneNumber = phoneNumber,
                    message = message,
                    scheduledAt = scheduledAt,
                    status = MessageStatus.PENDING
                )

                val id = repository.saveMessage(entity)
                val savedMessage = entity.copy(id = id)
                val workerId = schedulerService.scheduleMessage(savedMessage)

                _uiState.value = MessageUiState.Success(
                    "Mensagem agendada para ${formatTimestamp(scheduledAt)}"
                )
            } catch (e: Exception) {
                _uiState.value = MessageUiState.Error("Erro ao agendar: ${e.message}")
            }
        }
    }

    /**
     * Cancela uma mensagem agendada.
     */
    fun cancelMessage(messageId: Long) {
        viewModelScope.launch {
            try {
                schedulerService.cancelMessage(messageId)
                _uiState.value = MessageUiState.Success("Mensagem cancelada")
            } catch (e: Exception) {
                _uiState.value = MessageUiState.Error("Erro ao cancelar: ${e.message}")
            }
        }
    }

    /**
     * Remove uma mensagem do histórico.
     */
    fun deleteMessage(message: ScheduledMessageEntity) {
        viewModelScope.launch {
            try {
                if (message.status == MessageStatus.PENDING) {
                    schedulerService.cancelMessage(message.id)
                }
                repository.deleteMessage(message)
            } catch (e: Exception) {
                _uiState.value = MessageUiState.Error("Erro ao remover: ${e.message}")
            }
        }
    }

    private fun formatTimestamp(timestamp: Long): String {
        val sdf = java.text.SimpleDateFormat("dd/MM/yyyy HH:mm", java.util.Locale("pt", "BR"))
        return sdf.format(java.util.Date(timestamp))
    }

    fun resetState() {
        _uiState.value = MessageUiState.Idle
    }
}

sealed class MessageUiState {
    object Idle : MessageUiState()
    object Loading : MessageUiState()
    data class Success(val message: String) : MessageUiState()
    data class Error(val message: String) : MessageUiState()
}
