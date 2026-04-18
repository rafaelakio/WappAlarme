package br.com.wappalarme.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.wappalarme.data.model.AlarmEntity
import br.com.wappalarme.databinding.FragmentAddEditAlarmBinding
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddEditAlarmFragment : Fragment() {

    private var _binding: FragmentAddEditAlarmBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlarmViewModel by viewModels()
    private val args: AddEditAlarmFragmentArgs by navArgs()

    private var selectedHour = 7
    private var selectedMinute = 0
    private var selectedDays = 0 // bitmask

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTimeButton()
        setupDayChips()
        setupSaveButton()
        updateTimeDisplay()
    }

    private fun setupTimeButton() {
        binding.btnSelectTime.setOnClickListener {
            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(selectedHour)
                .setMinute(selectedMinute)
                .setTitleText("Selecione o horário")
                .build()

            picker.addOnPositiveButtonClickListener {
                selectedHour = picker.hour
                selectedMinute = picker.minute
                updateTimeDisplay()
            }

            picker.show(parentFragmentManager, "time_picker")
        }
    }

    private fun setupDayChips() {
        val chipMap = mapOf(
            binding.chipSun to 1,   // Domingo
            binding.chipMon to 2,   // Segunda
            binding.chipTue to 4,   // Terça
            binding.chipWed to 8,   // Quarta
            binding.chipThu to 16,  // Quinta
            binding.chipFri to 32,  // Sexta
            binding.chipSat to 64   // Sábado
        )

        chipMap.forEach { (chip, bit) ->
            chip.setOnCheckedChangeListener { _, isChecked ->
                selectedDays = if (isChecked) {
                    selectedDays or bit
                } else {
                    selectedDays and bit.inv()
                }
            }
        }
    }

    private fun setupSaveButton() {
        binding.btnSaveAlarm.setOnClickListener {
            val label = binding.etAlarmLabel.text?.toString()?.trim() ?: ""

            val alarm = AlarmEntity(
                systemAlarmId = System.currentTimeMillis().toInt(),
                hour = selectedHour,
                minute = selectedMinute,
                label = label,
                daysOfWeek = selectedDays,
                isEnabled = true
            )

            viewModel.saveAlarm(alarm)
            findNavController().navigateUp()
        }
    }

    private fun updateTimeDisplay() {
        binding.tvSelectedTime.text = String.format("%02d:%02d", selectedHour, selectedMinute)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
