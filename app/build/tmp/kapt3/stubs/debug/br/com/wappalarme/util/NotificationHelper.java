package br.com.wappalarme.util;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lbr/com/wappalarme/util/NotificationHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "notificationManager", "Landroid/app/NotificationManager;", "showHolidayAlarmNotification", "", "holidayName", "", "holidayDate", "showMessageFailedNotification", "contactName", "error", "showMessageSentNotification", "message", "Companion", "app_debug"})
public final class NotificationHelper {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final android.app.NotificationManager notificationManager = null;
    public static final int NOTIFICATION_HOLIDAY = 2001;
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.util.NotificationHelper.Companion Companion = null;
    
    @javax.inject.Inject()
    public NotificationHelper(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Exibe notificação de feriado com ações para manter ou desativar alarmes.
     */
    public final void showHolidayAlarmNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String holidayName, @org.jetbrains.annotations.NotNull()
    java.lang.String holidayDate) {
    }
    
    /**
     * Notificação de mensagem enviada com sucesso.
     */
    public final void showMessageSentNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Notificação de falha no envio de mensagem.
     */
    public final void showMessageFailedNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.NotNull()
    java.lang.String error) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lbr/com/wappalarme/util/NotificationHelper$Companion;", "", "()V", "NOTIFICATION_HOLIDAY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}