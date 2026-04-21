package br.com.wappalarme.receiver;

/**
 * Receiver disparado diariamente para verificar se o dia seguinte é feriado.
 * Quando detecta um feriado, envia uma notificação perguntando ao usuário
 * se deseja manter ou desativar os alarmes do próximo dia.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lbr/com/wappalarme/receiver/HolidayCheckReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "alarmManagerService", "Lbr/com/wappalarme/service/AlarmManagerService;", "getAlarmManagerService", "()Lbr/com/wappalarme/service/AlarmManagerService;", "setAlarmManagerService", "(Lbr/com/wappalarme/service/AlarmManagerService;)V", "holidayRepository", "Lbr/com/wappalarme/data/repository/HolidayRepository;", "getHolidayRepository", "()Lbr/com/wappalarme/data/repository/HolidayRepository;", "setHolidayRepository", "(Lbr/com/wappalarme/data/repository/HolidayRepository;)V", "notificationHelper", "Lbr/com/wappalarme/util/NotificationHelper;", "getNotificationHelper", "()Lbr/com/wappalarme/util/NotificationHelper;", "setNotificationHelper", "(Lbr/com/wappalarme/util/NotificationHelper;)V", "userConfigRepository", "Lbr/com/wappalarme/data/repository/UserConfigRepository;", "getUserConfigRepository", "()Lbr/com/wappalarme/data/repository/UserConfigRepository;", "setUserConfigRepository", "(Lbr/com/wappalarme/data/repository/UserConfigRepository;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"})
public final class HolidayCheckReceiver extends android.content.BroadcastReceiver {
    @javax.inject.Inject()
    public br.com.wappalarme.data.repository.HolidayRepository holidayRepository;
    @javax.inject.Inject()
    public br.com.wappalarme.data.repository.UserConfigRepository userConfigRepository;
    @javax.inject.Inject()
    public br.com.wappalarme.service.AlarmManagerService alarmManagerService;
    @javax.inject.Inject()
    public br.com.wappalarme.util.NotificationHelper notificationHelper;
    
    public HolidayCheckReceiver() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.repository.HolidayRepository getHolidayRepository() {
        return null;
    }
    
    public final void setHolidayRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.HolidayRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.repository.UserConfigRepository getUserConfigRepository() {
        return null;
    }
    
    public final void setUserConfigRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.UserConfigRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.service.AlarmManagerService getAlarmManagerService() {
        return null;
    }
    
    public final void setAlarmManagerService(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.service.AlarmManagerService p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.util.NotificationHelper getNotificationHelper() {
        return null;
    }
    
    public final void setNotificationHelper(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.util.NotificationHelper p0) {
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
}