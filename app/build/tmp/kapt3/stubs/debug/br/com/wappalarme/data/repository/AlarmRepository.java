package br.com.wappalarme.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00120\u0011J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0016\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lbr/com/wappalarme/data/repository/AlarmRepository;", "", "alarmDao", "Lbr/com/wappalarme/data/local/AlarmDao;", "(Lbr/com/wappalarme/data/local/AlarmDao;)V", "deleteAlarm", "", "alarm", "Lbr/com/wappalarme/data/model/AlarmEntity;", "(Lbr/com/wappalarme/data/model/AlarmEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disableAlarmsForHoliday", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlarms", "Lkotlinx/coroutines/flow/Flow;", "", "getEnabledAlarms", "getHolidayDisabledAlarms", "reEnableHolidayAlarms", "saveAlarm", "updateAlarm", "app_debug"})
public final class AlarmRepository {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.local.AlarmDao alarmDao = null;
    
    @javax.inject.Inject()
    public AlarmRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.local.AlarmDao alarmDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.AlarmEntity>> getAllAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAlarmById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.AlarmEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getEnabledAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.AlarmEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Desativa todos os alarmes ativos por motivo de feriado.
     * Registra a data do feriado para reativação posterior.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object disableAlarmsForHoliday(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Reativa todos os alarmes que foram desativados por feriado.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object reEnableHolidayAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Retorna alarmes desativados por feriado.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHolidayDisabledAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.AlarmEntity>> $completion) {
        return null;
    }
}