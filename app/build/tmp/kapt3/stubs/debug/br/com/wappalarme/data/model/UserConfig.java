package br.com.wappalarme.data.model;

/**
 * Configurações do usuário armazenadas localmente.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\tH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010$\u001a\u00020\u0003H\u00d6\u0001J\t\u0010%\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011\u00a8\u0006&"}, d2 = {"Lbr/com/wappalarme/data/model/UserConfig;", "", "id", "", "city", "", "state", "cityIbgeCode", "checkMunicipalHolidays", "", "holidayCheckTime", "holidayNotificationsEnabled", "lastHolidayCheckDate", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;)V", "getCheckMunicipalHolidays", "()Z", "getCity", "()Ljava/lang/String;", "getCityIbgeCode", "getHolidayCheckTime", "getHolidayNotificationsEnabled", "getId", "()I", "getLastHolidayCheckDate", "getState", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "user_config")
public final class UserConfig {
    @androidx.room.PrimaryKey()
    private final int id = 0;
    
    /**
     * Cidade do usuário para verificação de feriados
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String city = null;
    
    /**
     * Estado (UF) do usuário
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String state = null;
    
    /**
     * Código IBGE da cidade (usado na API de feriados)
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cityIbgeCode = null;
    
    /**
     * Se deve verificar feriados municipais além dos nacionais/estaduais
     */
    private final boolean checkMunicipalHolidays = false;
    
    /**
     * Horário para verificar feriados do dia seguinte (formato HH:mm, padrão 20:00)
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String holidayCheckTime = null;
    
    /**
     * Se as notificações de feriado estão habilitadas
     */
    private final boolean holidayNotificationsEnabled = false;
    
    /**
     * Última data verificada para feriados (yyyy-MM-dd)
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String lastHolidayCheckDate = null;
    
    public UserConfig(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.lang.String cityIbgeCode, boolean checkMunicipalHolidays, @org.jetbrains.annotations.NotNull()
    java.lang.String holidayCheckTime, boolean holidayNotificationsEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String lastHolidayCheckDate) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    /**
     * Cidade do usuário para verificação de feriados
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    /**
     * Estado (UF) do usuário
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getState() {
        return null;
    }
    
    /**
     * Código IBGE da cidade (usado na API de feriados)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityIbgeCode() {
        return null;
    }
    
    /**
     * Se deve verificar feriados municipais além dos nacionais/estaduais
     */
    public final boolean getCheckMunicipalHolidays() {
        return false;
    }
    
    /**
     * Horário para verificar feriados do dia seguinte (formato HH:mm, padrão 20:00)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHolidayCheckTime() {
        return null;
    }
    
    /**
     * Se as notificações de feriado estão habilitadas
     */
    public final boolean getHolidayNotificationsEnabled() {
        return false;
    }
    
    /**
     * Última data verificada para feriados (yyyy-MM-dd)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLastHolidayCheckDate() {
        return null;
    }
    
    public UserConfig() {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.model.UserConfig copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String state, @org.jetbrains.annotations.NotNull()
    java.lang.String cityIbgeCode, boolean checkMunicipalHolidays, @org.jetbrains.annotations.NotNull()
    java.lang.String holidayCheckTime, boolean holidayNotificationsEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String lastHolidayCheckDate) {
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