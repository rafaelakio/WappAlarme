package br.com.wappalarme.ui.alarm;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fJ\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lbr/com/wappalarme/ui/alarm/AlarmViewModel;", "Landroidx/lifecycle/ViewModel;", "alarmRepository", "Lbr/com/wappalarme/data/repository/AlarmRepository;", "holidayRepository", "Lbr/com/wappalarme/data/repository/HolidayRepository;", "alarmManagerService", "Lbr/com/wappalarme/service/AlarmManagerService;", "(Lbr/com/wappalarme/data/repository/AlarmRepository;Lbr/com/wappalarme/data/repository/HolidayRepository;Lbr/com/wappalarme/service/AlarmManagerService;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbr/com/wappalarme/ui/alarm/AlarmUiState;", "alarms", "Lkotlinx/coroutines/flow/Flow;", "", "Lbr/com/wappalarme/data/model/AlarmEntity;", "getAlarms", "()Lkotlinx/coroutines/flow/Flow;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkTomorrowHoliday", "", "deleteAlarm", "alarm", "disableAlarmsForHoliday", "openClockApp", "reEnableHolidayAlarms", "resetState", "saveAlarm", "toggleAlarm", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AlarmViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.repository.AlarmRepository alarmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.repository.HolidayRepository holidayRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.service.AlarmManagerService alarmManagerService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.AlarmEntity>> alarms = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<br.com.wappalarme.ui.alarm.AlarmUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<br.com.wappalarme.ui.alarm.AlarmUiState> uiState = null;
    
    @javax.inject.Inject()
    public AlarmViewModel(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.AlarmRepository alarmRepository, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.HolidayRepository holidayRepository, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.service.AlarmManagerService alarmManagerService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.AlarmEntity>> getAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<br.com.wappalarme.ui.alarm.AlarmUiState> getUiState() {
        return null;
    }
    
    /**
     * Salva um novo alarme ou atualiza um existente.
     */
    public final void saveAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm) {
    }
    
    /**
     * Alterna o estado ativo/inativo de um alarme.
     */
    public final void toggleAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm) {
    }
    
    /**
     * Remove um alarme.
     */
    public final void deleteAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm) {
    }
    
    /**
     * Desativa todos os alarmes por motivo de feriado.
     */
    public final void disableAlarmsForHoliday() {
    }
    
    /**
     * Reativa alarmes que foram desativados por feriado.
     */
    public final void reEnableHolidayAlarms() {
    }
    
    /**
     * Verifica se amanhã é feriado e notifica a UI.
     */
    public final void checkTomorrowHoliday() {
    }
    
    public final void openClockApp() {
    }
    
    public final void resetState() {
    }
}