package br.com.wappalarme.service

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Intent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

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
class WappAccessibilityService : AccessibilityService() {

    private var pendingSendAction = false
    private var targetPackage = ""

    override fun onServiceConnected() {
        super.onServiceConnected()
        serviceInfo = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or
                    AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            packageNames = arrayOf(
                WhatsAppService.WHATSAPP_PACKAGE,
                WhatsAppService.WHATSAPP_BUSINESS_PACKAGE
            )
            flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS
            notificationTimeout = 100
        }
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        event ?: return

        val packageName = event.packageName?.toString() ?: return

        // Só processa eventos do WhatsApp
        if (packageName != WhatsAppService.WHATSAPP_PACKAGE &&
            packageName != WhatsAppService.WHATSAPP_BUSINESS_PACKAGE) return

        if (!pendingSendAction) return

        // Tenta encontrar e clicar no botão de enviar
        if (event.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED ||
            event.eventType == AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED) {
            tryClickSendButton()
        }
    }

    /**
     * Tenta localizar e clicar no botão de enviar do WhatsApp.
     * O botão de enviar tem diferentes IDs dependendo da versão do WhatsApp.
     */
    private fun tryClickSendButton() {
        val root = rootInActiveWindow ?: return

        // IDs conhecidos do botão de enviar no WhatsApp
        val sendButtonIds = listOf(
            "com.whatsapp:id/send",
            "com.whatsapp:id/send_btn",
            "com.whatsapp.w4b:id/send",
            "com.whatsapp.w4b:id/send_btn"
        )

        for (buttonId in sendButtonIds) {
            val nodes = root.findAccessibilityNodeInfosByViewId(buttonId)
            if (nodes.isNotEmpty()) {
                val sendButton = nodes[0]
                if (sendButton.isEnabled && sendButton.isClickable) {
                    sendButton.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                    pendingSendAction = false
                    return
                }
            }
        }

        // Fallback: busca por descrição de conteúdo
        val sendByDescription = findNodeByDescription(root, "Enviar")
            ?: findNodeByDescription(root, "Send")

        sendByDescription?.let {
            if (it.isEnabled && it.isClickable) {
                it.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                pendingSendAction = false
            }
        }
    }

    private fun findNodeByDescription(
        root: AccessibilityNodeInfo,
        description: String
    ): AccessibilityNodeInfo? {
        val nodes = root.findAccessibilityNodeInfosByText(description)
        return nodes.firstOrNull { it.isClickable }
    }

    override fun onInterrupt() {
        pendingSendAction = false
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            if (it.action == ACTION_TRIGGER_SEND) {
                pendingSendAction = true
                targetPackage = it.getStringExtra(EXTRA_PACKAGE) ?: WhatsAppService.WHATSAPP_PACKAGE
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    companion object {
        const val ACTION_TRIGGER_SEND = "br.com.wappalarme.ACTION_TRIGGER_SEND"
        const val EXTRA_PACKAGE = "extra_package"
    }
}
