package br.com.wappalarme.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.wappalarme.databinding.FragmentSettingsBinding
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SettingsViewModel by viewModels()

    // Lista de estados brasileiros
    private val brazilianStates = listOf(
        "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
        "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI",
        "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStateDropdown()
        setupTimeButton()
        setupSaveButton()
        setupAccessibilityButton()
        observeViewModel()
    }

    private fun setupStateDropdown() {
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_dropdown_item_1line,
            brazilianStates
        )
        binding.actvState.setAdapter(adapter)
    }

    private fun setupTimeButton() {
        binding.btnSelectCheckTime.setOnClickListener {
            val currentTime = binding.tvCheckTime.text.toString()
            val parts = currentTime.split(":").mapNotNull { it.toIntOrNull() }
            val hour = parts.getOrElse(0) { 20 }
            val minute = parts.getOrElse(1) { 0 }

            val picker = MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(hour)
                .setMinute(minute)
                .setTitleText("Horário de verificação de feriados")
                .build()

            picker.addOnPositiveButtonClickListener {
                val timeStr = String.format("%02d:%02d", picker.hour, picker.minute)
                binding.tvCheckTime.text = timeStr
            }

            picker.show(parentFragmentManager, "time_picker_settings")
        }
    }

    private fun setupSaveButton() {
        binding.btnSaveSettings.setOnClickListener {
            val city = binding.etCity.text?.toString()?.trim() ?: ""
            val state = binding.actvState.text?.toString()?.trim() ?: ""
            val checkTime = binding.tvCheckTime.text?.toString() ?: "20:00"
            val notificationsEnabled = binding.switchHolidayNotifications.isChecked

            if (city.isEmpty()) {
                binding.tilCity.error = "Informe sua cidade"
                return@setOnClickListener
            }
            if (state.isEmpty() || !brazilianStates.contains(state)) {
                binding.tilState.error = "Selecione um estado válido"
                return@setOnClickListener
            }

            binding.tilCity.error = null
            binding.tilState.error = null

            viewModel.saveSettings(
                city = city,
                state = state,
                checkTime = checkTime,
                notificationsEnabled = notificationsEnabled
            )
        }
    }

    private fun setupAccessibilityButton() {
        binding.btnOpenAccessibility.setOnClickListener {
            viewModel.openAccessibilitySettings()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.config.collect { config ->
                        config?.let {
                            binding.etCity.setText(it.city)
                            binding.actvState.setText(it.state, false)
                            binding.tvCheckTime.text = it.holidayCheckTime
                            binding.switchHolidayNotifications.isChecked = it.holidayNotificationsEnabled
                        }
                    }
                }

                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is SettingsUiState.Idle -> Unit
                            is SettingsUiState.Success -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                                viewModel.resetState()
                            }
                            is SettingsUiState.Error -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG).show()
                                viewModel.resetState()
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
