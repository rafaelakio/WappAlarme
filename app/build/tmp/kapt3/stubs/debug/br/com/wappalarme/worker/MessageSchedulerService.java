package br.com.wappalarme.worker;

/**
 * Serviço responsável por agendar e cancelar jobs do WorkManager
 * para envio de mensagens WhatsApp.
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lbr/com/wappalarme/worker/MessageSchedulerService;", "", "workManager", "Landroidx/work/WorkManager;", "repository", "Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;", "(Landroidx/work/WorkManager;Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;)V", "cancelMessage", "", "messageId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rescheduleAllPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleImmediate", "", "message", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "(Lbr/com/wappalarme/data/model/ScheduledMessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleMessage", "app_debug"})
public final class MessageSchedulerService {
    @org.jetbrains.annotations.NotNull()
    private final androidx.work.WorkManager workManager = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.repository.ScheduledMessageRepository repository = null;
    
    @javax.inject.Inject()
    public MessageSchedulerService(@org.jetbrains.annotations.NotNull()
    androidx.work.WorkManager workManager, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.ScheduledMessageRepository repository) {
        super();
    }
    
    /**
     * Agenda o envio de uma mensagem no horário especificado.
     * Cria um OneTimeWorkRequest com delay calculado até o horário alvo.
     *
     * @param message Mensagem a ser agendada
     * @return ID do trabalho agendado
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object scheduleMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Agenda envio imediato (para mensagens com horário já passado).
     */
    private final java.lang.Object scheduleImmediate(br.com.wappalarme.data.model.ScheduledMessageEntity message, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Cancela o agendamento de uma mensagem.
     * @param messageId ID da mensagem no banco de dados
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cancelMessage(long messageId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Reagenda todas as mensagens pendentes (usado após reinicialização do dispositivo).
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object rescheduleAllPending(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}