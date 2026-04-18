package br.com.wappalarme.ui.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.wappalarme.R
import br.com.wappalarme.data.model.MessageStatus
import br.com.wappalarme.data.model.ScheduledMessageEntity
import br.com.wappalarme.databinding.ItemScheduledMessageBinding
import java.text.SimpleDateFormat
import java.util.*

class ScheduledMessageAdapter(
    private val onCancel: (ScheduledMessageEntity) -> Unit,
    private val onDelete: (ScheduledMessageEntity) -> Unit
) : ListAdapter<ScheduledMessageEntity, ScheduledMessageAdapter.MessageViewHolder>(MessageDiffCallback()) {

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = ItemScheduledMessageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MessageViewHolder(
        private val binding: ItemScheduledMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: ScheduledMessageEntity) {
            binding.apply {
                tvContactName.text = message.contactName
                tvPhoneNumber.text = message.phoneNumber
                tvMessagePreview.text = message.message.take(80) +
                        if (message.message.length > 80) "..." else ""
                tvScheduledTime.text = "📅 ${dateFormat.format(Date(message.scheduledAt))}"

                // Status com cor e ícone
                val (statusText, statusColor) = when (message.status) {
                    MessageStatus.PENDING -> "⏳ Aguardando" to R.color.status_pending
                    MessageStatus.SENDING -> "📤 Enviando..." to R.color.status_sending
                    MessageStatus.SENT -> "✅ Enviada" to R.color.status_sent
                    MessageStatus.FAILED -> "❌ Falhou" to R.color.status_failed
                    MessageStatus.CANCELLED -> "🚫 Cancelada" to R.color.status_cancelled
                }
                tvStatus.text = statusText
                tvStatus.setTextColor(root.context.getColor(statusColor))

                // Botão cancelar só aparece para mensagens pendentes
                btnCancelMessage.visibility = if (message.status == MessageStatus.PENDING) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                btnCancelMessage.setOnClickListener { onCancel(message) }

                // Botão deletar sempre visível (exceto para pendentes)
                btnDeleteMessage.visibility = if (message.status != MessageStatus.PENDING) {
                    View.VISIBLE
                } else {
                    View.GONE
                }
                btnDeleteMessage.setOnClickListener { onDelete(message) }

                // Mensagem de erro se houver
                if (message.errorMessage != null && message.status == MessageStatus.FAILED) {
                    tvErrorMessage.text = message.errorMessage
                    tvErrorMessage.visibility = View.VISIBLE
                } else {
                    tvErrorMessage.visibility = View.GONE
                }
            }
        }
    }

    class MessageDiffCallback : DiffUtil.ItemCallback<ScheduledMessageEntity>() {
        override fun areItemsTheSame(
            oldItem: ScheduledMessageEntity,
            newItem: ScheduledMessageEntity
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: ScheduledMessageEntity,
            newItem: ScheduledMessageEntity
        ) = oldItem == newItem
    }
}
