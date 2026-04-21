package br.com.wappalarme.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u0018\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000fJ\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00100\u000fJ\u001e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u001c\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ*\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0019H\u0086@\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lbr/com/wappalarme/data/repository/ScheduledMessageRepository;", "", "dao", "Lbr/com/wappalarme/data/local/ScheduledMessageDao;", "(Lbr/com/wappalarme/data/local/ScheduledMessageDao;)V", "cancelMessage", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessage", "message", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "(Lbr/com/wappalarme/data/model/ScheduledMessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMessages", "Lkotlinx/coroutines/flow/Flow;", "", "getMessageById", "getOverdueMessages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPendingCount", "", "getPendingMessages", "markAsFailed", "error", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsSent", "saveMessage", "updateMessage", "updateStatus", "status", "Lbr/com/wappalarme/data/model/MessageStatus;", "workerId", "(JLbr/com/wappalarme/data/model/MessageStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ScheduledMessageRepository {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.local.ScheduledMessageDao dao = null;
    
    @javax.inject.Inject()
    public ScheduledMessageRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.local.ScheduledMessageDao dao) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMessageById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.ScheduledMessageEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateStatus(long id, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.MessageStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String workerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsSent(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsFailed(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object cancelMessage(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOverdueMessages(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> $completion) {
        return null;
    }
}