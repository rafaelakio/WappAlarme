package br.com.wappalarme.receiver;

/**
 * Receiver disparado quando o dispositivo é reiniciado.
 * Responsável por reagendar alarmes e mensagens WhatsApp pendentes.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lbr/com/wappalarme/receiver/BootReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "alarmManagerService", "Lbr/com/wappalarme/service/AlarmManagerService;", "getAlarmManagerService", "()Lbr/com/wappalarme/service/AlarmManagerService;", "setAlarmManagerService", "(Lbr/com/wappalarme/service/AlarmManagerService;)V", "messageSchedulerService", "Lbr/com/wappalarme/worker/MessageSchedulerService;", "getMessageSchedulerService", "()Lbr/com/wappalarme/worker/MessageSchedulerService;", "setMessageSchedulerService", "(Lbr/com/wappalarme/worker/MessageSchedulerService;)V", "userConfigRepository", "Lbr/com/wappalarme/data/repository/UserConfigRepository;", "getUserConfigRepository", "()Lbr/com/wappalarme/data/repository/UserConfigRepository;", "setUserConfigRepository", "(Lbr/com/wappalarme/data/repository/UserConfigRepository;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
public final class BootReceiver extends android.content.BroadcastReceiver {
    @javax.inject.Inject()
    public br.com.wappalarme.service.AlarmManagerService alarmManagerService;
    @javax.inject.Inject()
    public br.com.wappalarme.worker.MessageSchedulerService messageSchedulerService;
    @javax.inject.Inject()
    public br.com.wappalarme.data.repository.UserConfigRepository userConfigRepository;
    
    public BootReceiver() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.service.AlarmManagerService getAlarmManagerService() {
        return null;
    }
    
    public final void setAlarmManagerService(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.service.AlarmManagerService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.worker.MessageSchedulerService getMessageSchedulerService() {
        return null;
    }
    
    public final void setMessageSchedulerService(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.worker.MessageSchedulerService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.repository.UserConfigRepository getUserConfigRepository() {
        return null;
    }
    
    public final void setUserConfigRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.UserConfigRepository p0) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
}