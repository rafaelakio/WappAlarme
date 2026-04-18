# WappAlarme 📱⏰

Aplicativo Android para gerenciamento de alarmes com detecção de feriados e envio agendado de mensagens WhatsApp.

## Funcionalidades

### ⏰ Gerenciamento de Alarmes
- Cadastro de alarmes com horário, descrição e dias da semana
- Integração com o app de relógio nativo do Samsung Galaxy S23
- Detecção automática de feriados nacionais (via BrasilAPI)
- Notificação na véspera do feriado perguntando se deseja desativar os alarmes
- Reativação automática dos alarmes no próximo dia útil

### 💬 Mensagens WhatsApp Agendadas
- Seleção de destinatário diretamente dos contatos do celular
- Editor de mensagem com contador de caracteres
- Seleção de data e hora para envio
- Agendamento via WorkManager (funciona como cron job)
- Envio automático via Accessibility Service (sem interação manual)
- Histórico de mensagens com status (Pendente, Enviando, Enviada, Falhou, Cancelada)

### ⚙️ Configurações
- Cidade e estado para verificação de feriados locais
- Horário diário de verificação de feriados (padrão: 20:00)
- Ativação do Serviço de Acessibilidade para envio automático

---

## Configuração do Projeto

### Pré-requisitos
- Android Studio Hedgehog (2023.1.1) ou superior
- JDK 17
- Android SDK 34
- Dispositivo/emulador com Android 12+ (API 31+)

### Como compilar

```bash
# Clone o repositório
git clone <url>
cd WappAlarme

# Compile e instale no dispositivo
./gradlew installDebug
```

---

## Configuração Inicial no Dispositivo

### 1. Permissões necessárias
O app solicitará automaticamente:
- **Notificações** — para alertas de feriado e status de mensagens
- **Alarmes exatos** — para disparo preciso no horário agendado
- **Contatos** — para seleção de destinatários

### 2. Serviço de Acessibilidade (para envio automático)
Para que as mensagens sejam enviadas **sem interação manual**:

1. Abra o app → aba **Configurações**
2. Toque em **"Abrir Configurações de Acessibilidade"**
3. Localize **"WappAlarme"** na lista de serviços
4. Ative o serviço e confirme

> **Sem o Accessibility Service:** O app abrirá o WhatsApp com a mensagem pré-preenchida, mas o usuário precisará pressionar "Enviar" manualmente.

### 3. Otimização de bateria
Para garantir que os alarmes e mensagens disparem no horário exato:

1. Configurações do Android → Bateria → Otimização de bateria
2. Localize **WappAlarme** → Selecione **"Não otimizar"**

---

## Arquitetura

```
app/
├── data/
│   ├── local/          # Room Database (DAOs)
│   ├── model/          # Entidades e modelos
│   ├── remote/         # Retrofit (API de feriados)
│   └── repository/     # Repositórios
├── di/                 # Módulos Hilt (injeção de dependência)
├── receiver/           # BroadcastReceivers
│   ├── BootReceiver            # Reagenda após reinicialização
│   ├── HolidayCheckReceiver    # Verificação diária de feriados
│   └── WhatsAppMessageReceiver # Ações de notificação
├── service/
│   ├── AlarmManagerService     # Integração com AlarmManager
│   ├── WhatsAppService         # Abertura do WhatsApp via Intent
│   └── WappAccessibilityService # Envio automático
├── ui/
│   ├── alarm/          # Tela de alarmes
│   ├── message/        # Tela de mensagens agendadas
│   ├── settings/       # Tela de configurações
│   └── MainActivity
└── worker/
    ├── SendWhatsAppWorker      # Worker de envio (WorkManager)
    └── MessageSchedulerService # Agendamento de jobs
```

### Stack tecnológica
| Componente | Tecnologia |
|---|---|
| Linguagem | Kotlin |
| UI | Material Design 3 + ViewBinding |
| Navegação | Navigation Component |
| DI | Hilt |
| Banco de dados | Room |
| Background jobs | WorkManager |
| Rede | Retrofit + OkHttp |
| Feriados | BrasilAPI (gratuita, sem autenticação) |
| Alarmes | AlarmManager + AlarmClock Intent |
| WhatsApp | Deep link + Accessibility Service |

---

## API de Feriados

Utiliza a [BrasilAPI](https://brasilapi.com.br/docs#tag/Feriados-Nacionais) — gratuita, sem necessidade de chave de API.

Endpoint: `GET https://brasilapi.com.br/api/feriados/v1/{ano}`

---

## Limitações conhecidas

1. **WhatsApp não tem API pública** — o envio é feito via deep link + Accessibility Service. Mudanças no layout do WhatsApp podem quebrar a automação.

2. **Feriados municipais** — a BrasilAPI retorna apenas feriados nacionais. Feriados municipais precisariam de uma fonte adicional.

3. **Samsung One UI** — em versões recentes do One UI, o sistema pode matar processos em background. Configure a exceção de bateria conforme descrito acima.

4. **Android 12+** — requer permissão explícita para alarmes exatos (`SCHEDULE_EXACT_ALARM`).

---

## Licença

MIT License — veja [LICENSE](LICENSE) para detalhes.
