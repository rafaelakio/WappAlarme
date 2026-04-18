package br.com.wappalarme.ui.alarm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.wappalarme.R
import br.com.wappalarme.databinding.FragmentAlarmBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AlarmFragment : Fragment() {

    private var _binding: FragmentAlarmBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AlarmViewModel by viewModels()
    private lateinit var adapter: AlarmAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupFab()
        observeViewModel()
        viewModel.checkTomorrowHoliday()
    }

    private fun setupRecyclerView() {
        adapter = AlarmAdapter(
            onToggle = { alarm -> viewModel.toggleAlarm(alarm) },
            onDelete = { alarm ->
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Remover alarme")
                    .setMessage("Deseja remover o alarme das ${alarm.hour}:${alarm.minute.toString().padStart(2, '0')}?")
                    .setPositiveButton("Remover") { _, _ -> viewModel.deleteAlarm(alarm) }
                    .setNegativeButton("Cancelar", null)
                    .show()
            },
            onEdit = { alarm ->
                val action = AlarmFragmentDirections.actionAlarmFragmentToAddEditAlarmFragment(alarm.id)
                findNavController().navigate(action)
            }
        )

        binding.recyclerAlarms.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@AlarmFragment.adapter
        }
    }

    private fun setupFab() {
        binding.fabAddAlarm.setOnClickListener {
            val action = AlarmFragmentDirections.actionAlarmFragmentToAddEditAlarmFragment(-1L)
            findNavController().navigate(action)
        }

        binding.btnOpenClock.setOnClickListener {
            viewModel.openClockApp()
        }
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.alarms.collect { alarms ->
                        adapter.submitList(alarms)
                        binding.tvEmptyState.visibility =
                            if (alarms.isEmpty()) View.VISIBLE else View.GONE
                    }
                }

                launch {
                    viewModel.uiState.collect { state ->
                        when (state) {
                            is AlarmUiState.Idle -> Unit
                            is AlarmUiState.Success -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_SHORT).show()
                                viewModel.resetState()
                            }
                            is AlarmUiState.Error -> {
                                Snackbar.make(binding.root, state.message, Snackbar.LENGTH_LONG)
                                    .setBackgroundTint(requireContext().getColor(R.color.error_color))
                                    .show()
                                viewModel.resetState()
                            }
                            is AlarmUiState.HolidayDetected -> {
                                showHolidayDialog(state)
                                viewModel.resetState()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showHolidayDialog(state: AlarmUiState.HolidayDetected) {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("🎉 Feriado amanhã!")
            .setMessage(
                "Amanhã (${state.holidayDate}) é ${state.holidayName}.\n\n" +
                "Deseja desativar seus alarmes para amanhã?\n" +
                "Eles serão reativados automaticamente em ${state.nextWorkingDay}."
            )
            .setPositiveButton("Desativar alarmes") { _, _ ->
                viewModel.disableAlarmsForHoliday()
            }
            .setNegativeButton("Manter ativos", null)
            .setCancelable(false)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
