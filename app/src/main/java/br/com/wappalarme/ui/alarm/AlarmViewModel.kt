package br.com.wappalarme.ui.alarm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wappalarme.data.model.AlarmEntity
import br.com.wappalarme.data.repository.AlarmRepository
import br.com.wappalarme.data.repository.HolidayRepository
import br.com.wappalarme.service.AlarmManagerService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class AlarmViewModel @Inject constructor(
    private val alarmRepository: AlarmRepository,
    private val holidayRepository: HolidayRepository,
    private val alarmManagerService: AlarmManagerService
) : ViewModel() {

    val alarms = alarmRepository.getAllAlarms()

    private val _uiState = MutableStateFlow<AlarmUiState>(AlarmUiState.Idle)
    val uiState: StateFlow<AlarmUiState> = _uiState.asStateFlow()

    /**
     * Salva um novo alarme ou atualiza um existente.
     */
    fun saveAlarm(alarm: AlarmEntity) {
        viewModelScope.launch {
            try {
                val id = alarmRepository.saveAlarm(alarm)
                // Cria o alarme no sistema (app de relógio nativo)
                val savedAlarm = alarm.copy(id = id)
                alarmManagerService.createSystemAlarm(savedAlarm)
                _uiState.value = AlarmUiState.Success("Alarme salvo com sucesso")
            } catch (e: Exception) {
                _uiState.value = AlarmUiState.Error("Erro ao salvar alarme: ${e.message}")
            }
        }
    }

    /**
     * Alterna o estado ativo/inativo de um alarme.
     */
    fun toggleAlarm(alarm: AlarmEntity) {
        viewModelScope.launch {
            try {
                val updated = alarm.copy(
                    isEnabled = !alarm.isEnabled,
                    disabledForHoliday = false
                )
                alarmRepository.updateAlarm(updated)
                if (updated.isEnabled) {
                    alarmManagerService.createSystemAlarm(updated)
                } else {
                    alarmManagerService.dismissSystemAlarm(updated)
                }
            } catch (e: Exception) {
                _uiState.value = AlarmUiState.Error("Erro ao atualizar alarme: ${e.message}")
            }
        }
    }

    /**
     * Remove um alarme.
     */
    fun deleteAlarm(alarm: AlarmEntity) {
        viewModelScope.launch {
            try {
                alarmManagerService.dismissSystemAlarm(alarm)
                alarmRepository.deleteAlarm(alarm)
                _uiState.value = AlarmUiState.Success("Alarme removido")
            } catch (e: Exception) {
                _uiState.value = AlarmUiState.Error("Erro ao remover alarme: ${e.message}")
            }
        }
    }

    /**
     * Desativa todos os alarmes por motivo de feriado.
     */
    fun disableAlarmsForHoliday() {
        viewModelScope.launch {
            try {
                val enabledAlarms = alarmRepository.getEnabledAlarms()
                alarmRepository.disableAlarmsForHoliday()
                enabledAlarms.forEach { alarm ->
                    alarmManagerService.dismissSystemAlarm(alarm)
                }
                _uiState.value = AlarmUiState.Success("Alarmes desativados para o feriado")
            } catch (e: Exception) {
                _uiState.value = AlarmUiState.Error("Erro ao desativar alarmes: ${e.message}")
            }
        }
    }

    /**
     * Reativa alarmes que foram desativados por feriado.
     */
    fun reEnableHolidayAlarms() {
        viewModelScope.launch {
            try {
                val disabledAlarms = alarmRepository.getHolidayDisabledAlarms()
                alarmRepository.reEnableHolidayAlarms()
                disabledAlarms.forEach { alarm ->
                    alarmManagerService.createSystemAlarm(alarm.copy(isEnabled = true))
                }
                _uiState.value = AlarmUiState.Success("Alarmes reativados")
            } catch (e: Exception) {
                _uiState.value = AlarmUiState.Error("Erro ao reativar alarmes: ${e.message}")
            }
        }
    }

    /**
     * Verifica se amanhã é feriado e notifica a UI.
     */
    fun checkTomorrowHoliday() {
        viewModelScope.launch {
            try {
                val holiday = holidayRepository.isTomorrowHoliday()
                if (holiday != null) {
                    val nextWorkDay = holidayRepository.getNextWorkingDay(
                        LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE)
                    )
                    _uiState.value = AlarmUiState.HolidayDetected(
                        holidayName = holiday.name,
                        holidayDate = holiday.date,
                        nextWorkingDay = nextWorkDay
                    )
                }
            } catch (e: Exception) {
                // Silencia erros de rede na verificação de feriados
            }
        }
    }

    fun openClockApp() {
        alarmManagerService.openClockApp()
    }

    fun resetState() {
        _uiState.value = AlarmUiState.Idle
    }
}

sealed class AlarmUiState {
    object Idle : AlarmUiState()
    data class Success(val message: String) : AlarmUiState()
    data class Error(val message: String) : AlarmUiState()
    data class HolidayDetected(
        val holidayName: String,
        val holidayDate: String,
        val nextWorkingDay: String
    ) : AlarmUiState()
}
