package br.com.wappalarme.ui.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.wappalarme.data.model.AlarmEntity
import br.com.wappalarme.databinding.ItemAlarmBinding

class AlarmAdapter(
    private val onToggle: (AlarmEntity) -> Unit,
    private val onDelete: (AlarmEntity) -> Unit,
    private val onEdit: (AlarmEntity) -> Unit
) : ListAdapter<AlarmEntity, AlarmAdapter.AlarmViewHolder>(AlarmDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val binding = ItemAlarmBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class AlarmViewHolder(
        private val binding: ItemAlarmBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(alarm: AlarmEntity) {
            binding.apply {
                // Formata hora com zero à esquerda
                tvAlarmTime.text = String.format("%02d:%02d", alarm.hour, alarm.minute)
                tvAlarmLabel.text = alarm.label.ifEmpty { "Alarme" }

                // Indicador de feriado
                if (alarm.disabledForHoliday) {
                    tvAlarmStatus.text = "⏸ Pausado (feriado)"
                    tvAlarmStatus.visibility = android.view.View.VISIBLE
                } else {
                    tvAlarmStatus.visibility = android.view.View.GONE
                }

                // Dias da semana
                tvAlarmDays.text = getDaysText(alarm.daysOfWeek)

                // Switch de ativo/inativo
                switchAlarm.isChecked = alarm.isEnabled
                switchAlarm.setOnCheckedChangeListener(null)
                switchAlarm.setOnCheckedChangeListener { _, _ ->
                    onToggle(alarm)
                }

                // Clique para editar
                root.setOnClickListener { onEdit(alarm) }

                // Botão de deletar
                btnDeleteAlarm.setOnClickListener { onDelete(alarm) }
            }
        }

        private fun getDaysText(bitmask: Int): String {
            if (bitmask == 0) return "Uma vez"
            val days = mutableListOf<String>()
            if (bitmask and 1 != 0) days.add("Dom")
            if (bitmask and 2 != 0) days.add("Seg")
            if (bitmask and 4 != 0) days.add("Ter")
            if (bitmask and 8 != 0) days.add("Qua")
            if (bitmask and 16 != 0) days.add("Qui")
            if (bitmask and 32 != 0) days.add("Sex")
            if (bitmask and 64 != 0) days.add("Sáb")
            return if (days.size == 7) "Todos os dias" else days.joinToString(", ")
        }
    }

    class AlarmDiffCallback : DiffUtil.ItemCallback<AlarmEntity>() {
        override fun areItemsTheSame(oldItem: AlarmEntity, newItem: AlarmEntity) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AlarmEntity, newItem: AlarmEntity) =
            oldItem == newItem
    }
}
