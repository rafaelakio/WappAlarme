package br.com.wappalarme.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\fH\'J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\fH\'J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\fH\'J\u0016\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u00a7@\u00a2\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001a\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ(\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0017H\u00a7@\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Lbr/com/wappalarme/data/local/ScheduledMessageDao;", "", "cancelMessage", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMessage", "message", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "(Lbr/com/wappalarme/data/model/ScheduledMessageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMessages", "Lkotlinx/coroutines/flow/Flow;", "", "getMessageById", "getOverdueMessages", "now", "getPendingCount", "", "getPendingMessages", "insertMessage", "markAsFailed", "error", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsSent", "sentAt", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessage", "updateMessageStatus", "status", "Lbr/com/wappalarme/data/model/MessageStatus;", "workerId", "(JLbr/com/wappalarme/data/model/MessageStatus;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface ScheduledMessageDao {
    
    @androidx.room.Query(value = "SELECT * FROM scheduled_messages ORDER BY scheduledAt ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> getAllMessages();
    
    @androidx.room.Query(value = "SELECT * FROM scheduled_messages WHERE status = \'PENDING\' ORDER BY scheduledAt ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> getPendingMessages();
    
    @androidx.room.Query(value = "SELECT * FROM scheduled_messages WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMessageById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.ScheduledMessageEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM scheduled_messages WHERE status = \'PENDING\' AND scheduledAt <= :now")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOverdueMessages(long now, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.ScheduledMessageEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteMessage(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.ScheduledMessageEntity message, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE scheduled_messages SET status = :status, workerId = :workerId WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateMessageStatus(long id, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.MessageStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String workerId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE scheduled_messages SET status = \'SENT\', sentAt = :sentAt WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsSent(long id, long sentAt, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE scheduled_messages SET status = \'FAILED\', errorMessage = :error WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markAsFailed(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String error, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE scheduled_messages SET status = \'CANCELLED\' WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object cancelMessage(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM scheduled_messages WHERE status = \'PENDING\'")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getPendingCount();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}