package br.com.wappalarme.ui.settings

import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.wappalarme.data.model.UserConfig
import br.com.wappalarme.data.repository.UserConfigRepository
import br.com.wappalarme.service.AlarmManagerService
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val userConfigRepository: UserConfigRepository,
    private val alarmManagerService: AlarmManagerService
) : ViewModel() {

    val config = userConfigRepository.getConfig()

    private val _uiState = MutableStateFlow<SettingsUiState>(SettingsUiState.Idle)
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    fun saveSettings(
        city: String,
        state: String,
        checkTime: String,
        notificationsEnabled: Boolean
    ) {
        viewModelScope.launch {
            try {
                val config = UserConfig(
                    city = city,
                    state = state,
                    holidayCheckTime = checkTime,
                    holidayNotificationsEnabled = notificationsEnabled
                )
                userConfigRepository.saveConfig(config)

                // Reagenda a verificação de feriados com o novo horário
                if (notificationsEnabled) {
                    val parts = checkTime.split(":")
                    alarmManagerService.scheduleHolidayCheck(
                        hour = parts[0].toIntOrNull() ?: 20,
                        minute = parts[1].toIntOrNull() ?: 0
                    )
                } else {
                    alarmManagerService.cancelHolidayCheck()
                }

                _uiState.value = SettingsUiState.Success("Configurações salvas!")
            } catch (e: Exception) {
                _uiState.value = SettingsUiState.Error("Erro ao salvar: ${e.message}")
            }
        }
    }

    /**
     * Abre as configurações de Acessibilidade do Android para o usuário
     * habilitar o WappAccessibilityService.
     */
    fun openAccessibilitySettings() {
        val intent = Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }

    fun resetState() {
        _uiState.value = SettingsUiState.Idle
    }
}

sealed class SettingsUiState {
    object Idle : SettingsUiState()
    data class Success(val message: String) : SettingsUiState()
    data class Error(val message: String) : SettingsUiState()
}
