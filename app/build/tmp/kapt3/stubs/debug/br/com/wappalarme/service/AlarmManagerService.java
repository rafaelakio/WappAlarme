package br.com.wappalarme.service;

/**
 * Serviço responsável por interagir com o AlarmManager do Android
 * e com o app de relógio nativo do dispositivo.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lbr/com/wappalarme/service/AlarmManagerService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmManager", "Landroid/app/AlarmManager;", "cancelHolidayCheck", "", "createSystemAlarm", "alarm", "Lbr/com/wappalarme/data/model/AlarmEntity;", "dismissSystemAlarm", "getDaysFromBitmask", "", "", "bitmask", "openClockApp", "scheduleHolidayCheck", "hour", "minute", "Companion", "app_debug"})
public final class AlarmManagerService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.AlarmManager alarmManager = null;
    private static final int HOLIDAY_CHECK_REQUEST_CODE = 9001;
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.service.AlarmManagerService.Companion Companion = null;
    
    @javax.inject.Inject()
    public AlarmManagerService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Cria um alarme no app de relógio nativo do Android.
     * Usa ACTION_SET_ALARM para integração com o relógio do Samsung.
     */
    public final void createSystemAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm) {
    }
    
    /**
     * Desativa um alarme no app de relógio nativo.
     * Usa ACTION_DISMISS_ALARM para desativar pelo label.
     */
    public final void dismissSystemAlarm(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.AlarmEntity alarm) {
    }
    
    /**
     * Abre o app de relógio do dispositivo.
     */
    public final void openClockApp() {
    }
    
    /**
     * Agenda a verificação diária de feriados.
     * Dispara todos os dias no horário configurado pelo usuário.
     * @param hour Hora do disparo (0-23)
     * @param minute Minuto do disparo (0-59)
     */
    public final void scheduleHolidayCheck(int hour, int minute) {
    }
    
    /**
     * Cancela a verificação de feriados agendada.
     */
    public final void cancelHolidayCheck() {
    }
    
    /**
     * Converte bitmask de dias da semana para lista de constantes Calendar.
     * Bitmask: 1=Dom, 2=Seg, 4=Ter, 8=Qua, 16=Qui, 32=Sex, 64=Sab
     */
    private final java.util.List<java.lang.Integer> getDaysFromBitmask(int bitmask) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lbr/com/wappalarme/service/AlarmManagerService$Companion;", "", "()V", "HOLIDAY_CHECK_REQUEST_CODE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}