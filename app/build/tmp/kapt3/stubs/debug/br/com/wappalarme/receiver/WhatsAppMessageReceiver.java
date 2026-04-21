package br.com.wappalarme.receiver;

/**
 * Receiver para ações de notificação relacionadas a alarmes e feriados.
 * Processa as respostas do usuário nas notificações de feriado.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lbr/com/wappalarme/receiver/WhatsAppMessageReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "alarmManagerService", "Lbr/com/wappalarme/service/AlarmManagerService;", "getAlarmManagerService", "()Lbr/com/wappalarme/service/AlarmManagerService;", "setAlarmManagerService", "(Lbr/com/wappalarme/service/AlarmManagerService;)V", "alarmRepository", "Lbr/com/wappalarme/data/repository/AlarmRepository;", "getAlarmRepository", "()Lbr/com/wappalarme/data/repository/AlarmRepository;", "setAlarmRepository", "(Lbr/com/wappalarme/data/repository/AlarmRepository;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "app_debug"})
public final class WhatsAppMessageReceiver extends android.content.BroadcastReceiver {
    @javax.inject.Inject()
    public br.com.wappalarme.data.repository.AlarmRepository alarmRepository;
    @javax.inject.Inject()
    public br.com.wappalarme.service.AlarmManagerService alarmManagerService;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_DISABLE_ALARMS_FOR_HOLIDAY = "br.com.wappalarme.ACTION_DISABLE_ALARMS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_KEEP_ALARMS_ACTIVE = "br.com.wappalarme.ACTION_KEEP_ALARMS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_REENABLE_ALARMS = "br.com.wappalarme.ACTION_REENABLE_ALARMS";
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.receiver.WhatsAppMessageReceiver.Companion Companion = null;
    
    public WhatsAppMessageReceiver() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.repository.AlarmRepository getAlarmRepository() {
        return null;
    }
    
    public final void setAlarmRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.AlarmRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.service.AlarmManagerService getAlarmManagerService() {
        return null;
    }
    
    public final void setAlarmManagerService(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.service.AlarmManagerService p0) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lbr/com/wappalarme/receiver/WhatsAppMessageReceiver$Companion;", "", "()V", "ACTION_DISABLE_ALARMS_FOR_HOLIDAY", "", "ACTION_KEEP_ALARMS_ACTIVE", "ACTION_REENABLE_ALARMS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}