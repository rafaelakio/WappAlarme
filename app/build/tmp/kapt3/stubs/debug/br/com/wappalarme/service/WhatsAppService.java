package br.com.wappalarme.service;

/**
 * Serviço responsável por abrir o WhatsApp e enviar mensagens via Intent.
 *
 * O WhatsApp não possui uma API pública para envio direto de mensagens.
 * A abordagem utilizada é via deep link oficial do WhatsApp:
 * https://wa.me/<número>?text=<mensagem>
 *
 * Isso abre o WhatsApp com a conversa e a mensagem pré-preenchida.
 * O usuário precisa pressionar "Enviar" — limitação da plataforma.
 *
 * Para automação completa sem interação do usuário, seria necessário
 * usar Accessibility Service (requer permissão especial do usuário).
 */
@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lbr/com/wappalarme/service/WhatsAppService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isWhatsAppInstalled", "", "openWhatsAppWithMessage", "", "phoneNumber", "", "message", "sendMessageViaAccessibility", "Companion", "app_debug"})
public final class WhatsAppService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WHATSAPP_PACKAGE = "com.whatsapp";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String WHATSAPP_BUSINESS_PACKAGE = "com.whatsapp.w4b";
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.service.WhatsAppService.Companion Companion = null;
    
    @javax.inject.Inject()
    public WhatsAppService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * Verifica se o WhatsApp está instalado no dispositivo.
     */
    public final boolean isWhatsAppInstalled() {
        return false;
    }
    
    /**
     * Abre o WhatsApp com uma conversa e mensagem pré-preenchida.
     * Usa o deep link oficial: https://wa.me/<número>?text=<mensagem>
     *
     * @param phoneNumber Número no formato internacional sem '+' (ex: 5511999999999)
     * @param message Texto da mensagem
     */
    public final void openWhatsAppWithMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    /**
     * Abre o WhatsApp via Accessibility Service para envio automático.
     * Esta abordagem requer que o usuário habilite o AccessibilityService do app.
     *
     * @param phoneNumber Número no formato internacional
     * @param message Texto da mensagem
     */
    public final void sendMessageViaAccessibility(@org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lbr/com/wappalarme/service/WhatsAppService$Companion;", "", "()V", "WHATSAPP_BUSINESS_PACKAGE", "", "WHATSAPP_PACKAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}