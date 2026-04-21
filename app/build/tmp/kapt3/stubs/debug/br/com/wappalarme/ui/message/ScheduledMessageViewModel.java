package br.com.wappalarme.ui.message;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cH\u0002J\u0006\u0010\"\u001a\u00020\u001aJ&\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001cR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\'"}, d2 = {"Lbr/com/wappalarme/ui/message/ScheduledMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;", "schedulerService", "Lbr/com/wappalarme/worker/MessageSchedulerService;", "(Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;Lbr/com/wappalarme/worker/MessageSchedulerService;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lbr/com/wappalarme/ui/message/MessageUiState;", "allMessages", "Lkotlinx/coroutines/flow/Flow;", "", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "getAllMessages", "()Lkotlinx/coroutines/flow/Flow;", "pendingCount", "", "getPendingCount", "pendingMessages", "getPendingMessages", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "cancelMessage", "", "messageId", "", "deleteMessage", "message", "formatTimestamp", "", "timestamp", "resetState", "scheduleMessage", "contactName", "phoneNumber", "scheduledAt", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ScheduledMessageViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.repository.ScheduledMessageRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.worker.MessageSchedulerService schedulerService = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> allMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> pendingMessages = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> pendingCount = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<br.com.wappalarme.ui.message.MessageUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<br.com.wappalarme.ui.message.MessageUiState> uiState = null;
    
    @javax.inject.Inject()
    public ScheduledMessageViewModel(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.repository.ScheduledMessageRepository repository, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.worker.MessageSchedulerService schedulerService) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> getAllMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> getPendingMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getPendingCount() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<br.com.wappalarme.ui.message.MessageUiState> getUiState() {
        return null;
    }
    
    /**
     * Agenda uma nova mensagem WhatsApp.
     */
    public final void scheduleMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long scheduledAt) {
    }
    
    /**
     * Cancela uma mensagem agendada.
     */
    public final void cancelMessage(long messageId) {
    }
    
    /**
     * Remove uma mensagem do histórico.
     */
    public final void deleteMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message) {
    }
    
    private final java.lang.String formatTimestamp(long timestamp) {
        return null;
    }
    
    public final void resetState() {
    }
}