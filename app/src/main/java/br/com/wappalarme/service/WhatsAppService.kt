package br.com.wappalarme.service

import android.content.Context
import android.content.Intent
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

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
@Singleton
class WhatsAppService @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        const val WHATSAPP_PACKAGE = "com.whatsapp"
        const val WHATSAPP_BUSINESS_PACKAGE = "com.whatsapp.w4b"
    }

    /**
     * Verifica se o WhatsApp está instalado no dispositivo.
     */
    fun isWhatsAppInstalled(): Boolean {
        return try {
            context.packageManager.getPackageInfo(WHATSAPP_PACKAGE, 0)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Abre o WhatsApp com uma conversa e mensagem pré-preenchida.
     * Usa o deep link oficial: https://wa.me/<número>?text=<mensagem>
     *
     * @param phoneNumber Número no formato internacional sem '+' (ex: 5511999999999)
     * @param message Texto da mensagem
     */
    fun openWhatsAppWithMessage(phoneNumber: String, message: String) {
        val cleanNumber = phoneNumber.replace(Regex("[^0-9]"), "")
        val encodedMessage = Uri.encode(message)

        // Tenta primeiro via URI direto do WhatsApp (mais confiável)
        val directIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("whatsapp://send?phone=$cleanNumber&text=$encodedMessage")
            setPackage(WHATSAPP_PACKAGE)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(directIntent)
            return
        } catch (e: Exception) {
            // Fallback para deep link web
        }

        // Fallback: deep link via browser/wa.me
        val webIntent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse("https://wa.me/$cleanNumber?text=$encodedMessage")
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        try {
            context.startActivity(webIntent)
        } catch (e: Exception) {
            // WhatsApp não instalado ou erro
        }
    }

    /**
     * Abre o WhatsApp via Accessibility Service para envio automático.
     * Esta abordagem requer que o usuário habilite o AccessibilityService do app.
     *
     * @param phoneNumber Número no formato internacional
     * @param message Texto da mensagem
     */
    fun sendMessageViaAccessibility(phoneNumber: String, message: String) {
        // Primeiro abre o WhatsApp com a mensagem pré-preenchida
        openWhatsAppWithMessage(phoneNumber, message)
        // O AccessibilityService (WappAccessibilityService) detectará a tela
        // e automaticamente pressionará o botão de enviar
    }
}
