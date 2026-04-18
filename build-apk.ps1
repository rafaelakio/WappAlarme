# =============================================================================
# build-apk.ps1 — Script de compilação do WappAlarme
# Executa como: powershell -ExecutionPolicy Bypass -File build-apk.ps1
# =============================================================================

$ErrorActionPreference = "Stop"

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  WappAlarme — Compilador de APK" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# --- 1. Verificar Java ---
Write-Host "[1/4] Verificando Java..." -ForegroundColor Yellow

$javaExe = $null

# Tenta JAVA_HOME primeiro
if ($env:JAVA_HOME -and (Test-Path "$env:JAVA_HOME\bin\java.exe")) {
    $javaExe = "$env:JAVA_HOME\bin\java.exe"
}

# Busca em locais comuns
if (-not $javaExe) {
    $commonPaths = @(
        "C:\Program Files\Microsoft\jdk-17*\bin\java.exe",
        "C:\Program Files\Eclipse Adoptium\jdk-17*\bin\java.exe",
        "C:\Program Files\Java\jdk-17*\bin\java.exe",
        "C:\Program Files\OpenJDK\jdk-17*\bin\java.exe",
        "C:\Program Files\Android\Android Studio\jbr\bin\java.exe"
    )
    foreach ($pattern in $commonPaths) {
        $found = Get-Item $pattern -ErrorAction SilentlyContinue | Select-Object -First 1
        if ($found) { $javaExe = $found.FullName; break }
    }
}

if (-not $javaExe) {
    Write-Host ""
    Write-Host "ERRO: Java 17 não encontrado!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Instale com:" -ForegroundColor White
    Write-Host "  winget install Microsoft.OpenJDK.17" -ForegroundColor Green
    Write-Host ""
    Write-Host "Depois feche e reabra o terminal e execute este script novamente." -ForegroundColor White
    exit 1
}

$env:JAVA_HOME = Split-Path (Split-Path $javaExe)
Write-Host "  Java encontrado: $javaExe" -ForegroundColor Green

# --- 2. Verificar Android SDK ---
Write-Host "[2/4] Verificando Android SDK..." -ForegroundColor Yellow

$sdkRoot = $null
$sdkCandidates = @(
    $env:ANDROID_HOME,
    $env:ANDROID_SDK_ROOT,
    "$env:LOCALAPPDATA\Android\Sdk",
    "C:\Android\Sdk",
    "C:\Android"
)

foreach ($candidate in $sdkCandidates) {
    if ($candidate -and (Test-Path "$candidate\platforms")) {
        $sdkRoot = $candidate
        break
    }
}

if (-not $sdkRoot) {
    Write-Host ""
    Write-Host "ERRO: Android SDK não encontrado!" -ForegroundColor Red
    Write-Host ""
    Write-Host "Siga estes passos:" -ForegroundColor White
    Write-Host ""
    Write-Host "1. Baixe as Command Line Tools em:" -ForegroundColor White
    Write-Host "   https://developer.android.com/studio#command-line-tools-only" -ForegroundColor Cyan
    Write-Host ""
    Write-Host "2. Extraia em C:\Android\cmdline-tools\latest\" -ForegroundColor White
    Write-Host ""
    Write-Host "3. Execute no terminal (como Administrador):" -ForegroundColor White
    Write-Host '   $env:ANDROID_HOME = "C:\Android"' -ForegroundColor Green
    Write-Host '   C:\Android\cmdline-tools\latest\bin\sdkmanager.bat "platforms;android-34" "build-tools;34.0.0" "platform-tools"' -ForegroundColor Green
    Write-Host ""
    Write-Host "4. Execute este script novamente." -ForegroundColor White
    exit 1
}

$env:ANDROID_HOME = $sdkRoot
$env:ANDROID_SDK_ROOT = $sdkRoot
Write-Host "  Android SDK: $sdkRoot" -ForegroundColor Green

# Verificar build-tools
$buildTools = Get-ChildItem "$sdkRoot\build-tools" -ErrorAction SilentlyContinue | 
              Sort-Object Name -Descending | Select-Object -First 1
if (-not $buildTools) {
    Write-Host "  AVISO: build-tools não encontrado no SDK" -ForegroundColor Red
    Write-Host "  Execute: sdkmanager.bat `"build-tools;34.0.0`"" -ForegroundColor Yellow
    exit 1
}
Write-Host "  Build Tools: $($buildTools.Name)" -ForegroundColor Green

# --- 3. Compilar ---
Write-Host "[3/4] Compilando APK (pode demorar na primeira vez)..." -ForegroundColor Yellow
Write-Host "  O Gradle irá baixar dependências (~200MB na primeira execução)" -ForegroundColor Gray
Write-Host ""

$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path
Set-Location $scriptDir

# Limpa build anterior se existir
if (Test-Path "app\build\outputs\apk") {
    Remove-Item "app\build\outputs\apk" -Recurse -Force
}

# Executa o build
$process = Start-Process -FilePath ".\gradlew.bat" `
    -ArgumentList "assembleDebug", "--stacktrace" `
    -NoNewWindow -Wait -PassThru

if ($process.ExitCode -ne 0) {
    Write-Host ""
    Write-Host "ERRO: Compilação falhou! Verifique os logs acima." -ForegroundColor Red
    exit 1
}

# --- 4. Resultado ---
$apkPath = "app\build\outputs\apk\debug\app-debug.apk"
if (Test-Path $apkPath) {
    $apkSize = [math]::Round((Get-Item $apkPath).Length / 1MB, 1)
    Write-Host ""
    Write-Host "========================================" -ForegroundColor Green
    Write-Host "  APK gerado com sucesso!" -ForegroundColor Green
    Write-Host "========================================" -ForegroundColor Green
    Write-Host ""
    Write-Host "  Arquivo: $((Resolve-Path $apkPath).Path)" -ForegroundColor White
    Write-Host "  Tamanho: ${apkSize} MB" -ForegroundColor White
    Write-Host ""
    Write-Host "Para instalar no celular via USB:" -ForegroundColor Yellow
    Write-Host "  1. Ative 'Depuração USB' no celular (Configurações > Sobre > toque 7x em 'Número da versão')" -ForegroundColor White
    Write-Host "  2. Conecte o cabo USB" -ForegroundColor White
    Write-Host "  3. Execute:" -ForegroundColor White
    Write-Host "     $sdkRoot\platform-tools\adb.exe install $((Resolve-Path $apkPath).Path)" -ForegroundColor Green
    Write-Host ""
    Write-Host "Ou copie o APK para o celular e instale manualmente." -ForegroundColor Gray
} else {
    Write-Host "ERRO: APK não encontrado após compilação." -ForegroundColor Red
    exit 1
}
