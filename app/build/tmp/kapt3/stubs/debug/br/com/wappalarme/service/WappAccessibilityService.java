package br.com.wappalarme.service;

/**
 * Serviço de Acessibilidade para automação do envio de mensagens no WhatsApp.
 *
 * IMPORTANTE: Este serviço precisa ser habilitado manualmente pelo usuário em:
 * Configurações > Acessibilidade > Serviços instalados > WappAlarme
 *
 * Funcionamento:
 * 1. O app abre o WhatsApp com a mensagem pré-preenchida via Intent
 * 2. Este serviço detecta quando a tela do WhatsApp está ativa
 * 3. Localiza o botão de enviar e simula o clique
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0014J\"\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\b\u0010\u0017\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lbr/com/wappalarme/service/WappAccessibilityService;", "Landroid/accessibilityservice/AccessibilityService;", "()V", "pendingSendAction", "", "targetPackage", "", "findNodeByDescription", "Landroid/view/accessibility/AccessibilityNodeInfo;", "root", "description", "onAccessibilityEvent", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "onInterrupt", "onServiceConnected", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "tryClickSendButton", "Companion", "app_debug"})
public final class WappAccessibilityService extends android.accessibilityservice.AccessibilityService {
    private boolean pendingSendAction = false;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String targetPackage = "";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ACTION_TRIGGER_SEND = "br.com.wappalarme.ACTION_TRIGGER_SEND";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String EXTRA_PACKAGE = "extra_package";
    @org.jetbrains.annotations.NotNull()
    public static final br.com.wappalarme.service.WappAccessibilityService.Companion Companion = null;
    
    public WappAccessibilityService() {
        super();
    }
    
    @java.lang.Override()
    protected void onServiceConnected() {
    }
    
    @java.lang.Override()
    public void onAccessibilityEvent(@org.jetbrains.annotations.Nullable()
    android.view.accessibility.AccessibilityEvent event) {
    }
    
    /**
     * Tenta localizar e clicar no botão de enviar do WhatsApp.
     * O botão de enviar tem diferentes IDs dependendo da versão do WhatsApp.
     */
    private final void tryClickSendButton() {
    }
    
    private final android.view.accessibility.AccessibilityNodeInfo findNodeByDescription(android.view.accessibility.AccessibilityNodeInfo root, java.lang.String description) {
        return null;
    }
    
    @java.lang.Override()
    public void onInterrupt() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lbr/com/wappalarme/service/WappAccessibilityService$Companion;", "", "()V", "ACTION_TRIGGER_SEND", "", "EXTRA_PACKAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}