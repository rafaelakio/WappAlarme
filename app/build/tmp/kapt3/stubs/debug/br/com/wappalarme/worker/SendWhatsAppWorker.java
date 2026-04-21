package br.com.wappalarme.worker;

/**
 * Worker do WorkManager responsável por disparar o envio de mensagens WhatsApp
 * no horário agendado (funciona como um cron job).
 *
 * O WorkManager garante execução mesmo após reinicialização do dispositivo.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B3\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lbr/com/wappalarme/worker/SendWhatsAppWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "repository", "Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;", "whatsAppService", "Lbr/com/wappalarme/service/WhatsAppService;", "notificationHelper", "Lbr/com/wappalarme/util/NotificationHelper;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;Lbr/com/wappalarme/service/WhatsAppService;Lbr/com/wappalarme/util/NotificationHelper;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
@androidx.hilt.work.HiltWorker()
public final class SendWhatsAppWorker extends androidx.work.CoroutineWorker {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.repository.ScheduledMessageRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.service.WhatsAppService whatsAppService = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.util.NotificationHelper notificationHelper = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_MESSAGE_ID = "message_id";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WORK_TAG = "send_whatsapp";
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.worker.SendWhatsAppWorker.Companion Companion = null;
    
    @dagger.assisted.AssistedInject()
    public SendWhatsAppWorker(@dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @dagger.assisted.Assisted()
    @org.jetbrains.annotations.NotNull()
    androidx.work.WorkerParameters workerParams, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.ScheduledMessageRepository repository, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.service.WhatsAppService whatsAppService, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.util.NotificationHelper notificationHelper) {
        super(null, null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object doWork(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lbr/com/wappalarme/worker/SendWhatsAppWorker$Companion;", "", "()V", "KEY_MESSAGE_ID", "", "WORK_TAG", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}