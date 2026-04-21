package br.com.wappalarme.data.model;

/**
 * Representa uma mensagem WhatsApp agendada.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0005H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJx\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020/H\u00d6\u0001J\t\u00100\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0011\u00a8\u00061"}, d2 = {"Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "", "id", "", "contactName", "", "phoneNumber", "message", "scheduledAt", "status", "Lbr/com/wappalarme/data/model/MessageStatus;", "workerId", "createdAt", "sentAt", "errorMessage", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLbr/com/wappalarme/data/model/MessageStatus;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)V", "getContactName", "()Ljava/lang/String;", "getCreatedAt", "()J", "getErrorMessage", "getId", "getMessage", "getPhoneNumber", "getScheduledAt", "getSentAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Lbr/com/wappalarme/data/model/MessageStatus;", "getWorkerId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLbr/com/wappalarme/data/model/MessageStatus;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;)Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "scheduled_messages")
public final class ScheduledMessageEntity {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    
    /**
     * Nome do contato destinatário
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contactName = null;
    
    /**
     * Número de telefone do destinatário (formato internacional: +5511999999999)
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String phoneNumber = null;
    
    /**
     * Conteúdo da mensagem
     */
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    
    /**
     * Timestamp Unix (ms) do momento agendado para envio
     */
    private final long scheduledAt = 0L;
    
    /**
     * Status atual da mensagem
     */
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.model.MessageStatus status = null;
    
    /**
     * ID do WorkManager job para cancelamento
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String workerId = null;
    
    /**
     * Data/hora de criação
     */
    private final long createdAt = 0L;
    
    /**
     * Data/hora do envio efetivo (preenchido após envio)
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long sentAt = null;
    
    /**
     * Mensagem de erro caso o envio falhe
     */
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMessage = null;
    
    public ScheduledMessageEntity(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long scheduledAt, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.MessageStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String workerId, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long sentAt, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    /**
     * Nome do contato destinatário
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContactName() {
        return null;
    }
    
    /**
     * Número de telefone do destinatário (formato internacional: +5511999999999)
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    /**
     * Conteúdo da mensagem
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    /**
     * Timestamp Unix (ms) do momento agendado para envio
     */
    public final long getScheduledAt() {
        return 0L;
    }
    
    /**
     * Status atual da mensagem
     */
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.model.MessageStatus getStatus() {
        return null;
    }
    
    /**
     * ID do WorkManager job para cancelamento
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getWorkerId() {
        return null;
    }
    
    /**
     * Data/hora de criação
     */
    public final long getCreatedAt() {
        return 0L;
    }
    
    /**
     * Data/hora do envio efetivo (preenchido após envio)
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSentAt() {
        return null;
    }
    
    /**
     * Mensagem de erro caso o envio falhe
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final long component5() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.model.MessageStatus component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final br.com.wappalarme.data.model.ScheduledMessageEntity copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String contactName, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message, long scheduledAt, @org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.MessageStatus status, @org.jetbrains.annotations.Nullable()
    java.lang.String workerId, long createdAt, @org.jetbrains.annotations.Nullable()
    java.lang.Long sentAt, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}