package br.com.wappalarme.data.model;

/**
 * Representa um alarme gerenciado pelo app.
 * O app espelha os alarmes do sistema e controla sua ativação/desativação em feriados.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b!\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\tH\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\fH\u00c6\u0003J\t\u0010&\u001a\u00020\fH\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\tH\u00c6\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0005H\u00d6\u0001J\t\u0010,\u001a\u00020\tH\u00d6\u0001R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0016R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014\u00a8\u0006-"}, d2 = {"Lbr/com/wappalarme/data/model/AlarmEntity;", "", "id", "", "systemAlarmId", "", "hour", "minute", "label", "", "daysOfWeek", "isEnabled", "", "disabledForHoliday", "holidayDisabledDate", "createdAt", "(JIIILjava/lang/String;IZZLjava/lang/String;J)V", "getCreatedAt", "()J", "getDaysOfWeek", "()I", "getDisabledForHoliday", "()Z", "getHolidayDisabledDate", "()Ljava/lang/String;", "getHour", "getId", "getLabel", "getMinute", "getSystemAlarmId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "alarms")
public final class AlarmEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    
    /**
     * ID do alarme no sistema Android (AlarmManager)
     */
    private final int systemAlarmId = 0;
    
    /**
     * Hora do alarme (0-23)
     */
    private final int hour = 0;
    
    /**
     * Minuto do alarme (0-59)
     */
    private final int minute = 0;
    
    /**
     * Rótulo/descrição do alarme
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String label = null;
    
    /**
     * Dias da semana ativos: bitmask (1=Dom, 2=Seg, 4=Ter, 8=Qua, 16=Qui, 32=Sex, 64=Sab)
     */
    private final int daysOfWeek = 0;
    
    /**
     * Se o alarme está ativo
     */
    private final boolean isEnabled = false;
    
    /**
     * Se o alarme foi desativado temporariamente por feriado
     */
    private final boolean disabledForHoliday = false;
    
    /**
     * Data em que o alarme foi desativado por feriado (yyyy-MM-dd)
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String holidayDisabledDate = null;
    
    /**
     * Data de criação
     */
    private final long createdAt = 0L;
    
    public AlarmEntity(long id, int systemAlarmId, int hour, int minute, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int daysOfWeek, boolean isEnabled, boolean disabledForHoliday, @org.jetbrains.annotations.Nullable()
    java.lang.String holidayDisabledDate, long createdAt) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    /**
     * ID do alarme no sistema Android (AlarmManager)
     */
    public final int getSystemAlarmId() {
        return 0;
    }
    
    /**
     * Hora do alarme (0-23)
     */
    public final int getHour() {
        return 0;
    }
    
    /**
     * Minuto do alarme (0-59)
     */
    public final int getMinute() {
        return 0;
    }
    
    /**
     * Rótulo/descrição do alarme
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLabel() {
        return null;
    }
    
    /**
     * Dias da semana ativos: bitmask (1=Dom, 2=Seg, 4=Ter, 8=Qua, 16=Qui, 32=Sex, 64=Sab)
     */
    public final int getDaysOfWeek() {
        return 0;
    }
    
    /**
     * Se o alarme está ativo
     */
    public final boolean isEnabled() {
        return false;
    }
    
    /**
     * Se o alarme foi desativado temporariamente por feriado
     */
    public final boolean getDisabledForHoliday() {
        return false;
    }
    
    /**
     * Data em que o alarme foi desativado por feriado (yyyy-MM-dd)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHolidayDisabledDate() {
        return null;
    }
    
    /**
     * Data de criação
     */
    public final long getCreatedAt() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.model.AlarmEntity copy(long id, int systemAlarmId, int hour, int minute, @org.jetbrains.annotations.NotNull()
    java.lang.String label, int daysOfWeek, boolean isEnabled, boolean disabledForHoliday, @org.jetbrains.annotations.Nullable()
    java.lang.String holidayDisabledDate, long createdAt) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}