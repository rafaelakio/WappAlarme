package br.com.wappalarme.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000eH\'J\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J0\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00a7@\u00a2\u0006\u0002\u0010\u001b\u00a8\u0006\u001c"}, d2 = {"Lbr/com/wappalarme/data/local/AlarmDao;", "", "deleteAlarm", "", "alarm", "Lbr/com/wappalarme/data/model/AlarmEntity;", "(Lbr/com/wappalarme/data/model/AlarmEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlarmById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAlarms", "Lkotlinx/coroutines/flow/Flow;", "", "getEnabledAlarms", "getHolidayDisabledAlarms", "insertAlarm", "reEnableHolidayAlarms", "updateAlarm", "updateAlarmStatus", "enabled", "", "disabledForHoliday", "date", "", "(JZZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AlarmDao {
    
    @androidx.room.Query(value = "SELECT * FROM alarms ORDER BY hour ASC, minute ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.AlarmEntity>> getAllAlarms();
    
    @androidx.room.Query(value = "SELECT * FROM alarms WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAlarmById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.AlarmEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM alarms WHERE isEnabled = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEnabledAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.AlarmEntity>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM alarms WHERE disabledForHoliday = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getHolidayDisabledAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.AlarmEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE alarms SET isEnabled = :enabled, disabledForHoliday = :disabledForHoliday, holidayDisabledDate = :date WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateAlarmStatus(long id, boolean enabled, boolean disabledForHoliday, @org.jetbrains.annotations.Nullable()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE alarms SET isEnabled = 1, disabledForHoliday = 0, holidayDisabledDate = NULL WHERE disabledForHoliday = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object reEnableHolidayAlarms(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM alarms")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}