package br.com.wappalarme.ui

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.wappalarme.R
import br.com.wappalarme.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    // Launcher para permissão de notificações (Android 13+)
    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { /* Permissão concedida ou negada — app funciona de qualquer forma */ }

    // Launcher para permissão de alarmes exatos (Android 12+)
    private val exactAlarmPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { /* Retorno da tela de permissão de alarmes */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
        requestRequiredPermissions()
        showPreviousCrashIfAny()
    }

    private fun setupNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfig = AppBarConfiguration(
            setOf(
                R.id.alarmFragment,
                R.id.scheduledMessageFragment,
                R.id.settingsFragment
            )
        )

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfig)
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun requestRequiredPermissions() {
        // Permissão de notificações (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        // Permissão de alarmes exatos (Android 12+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val alarmManager = getSystemService(android.app.AlarmManager::class.java)
            if (!alarmManager.canScheduleExactAlarms()) {
                showExactAlarmPermissionDialog()
            }
        }
    }

    private fun showExactAlarmPermissionDialog() {
        MaterialAlertDialogBuilder(this)
            .setTitle("Permissão necessária")
            .setMessage(
                "Para que os alarmes e mensagens sejam disparados no horário exato, " +
                "o app precisa de permissão para agendar alarmes precisos.\n\n" +
                "Toque em 'Permitir' e habilite a opção para este app."
            )
            .setPositiveButton("Permitir") { _, _ ->
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM).apply {
                        data = Uri.parse("package:$packageName")
                    }
                    exactAlarmPermissionLauncher.launch(intent)
                }
            }
            .setNegativeButton("Agora não", null)
            .show()
    }

    private fun showPreviousCrashIfAny() {
        val prefs = getSharedPreferences("crash_log", MODE_PRIVATE)
        val crash = prefs.getString("crash", null) ?: return
        prefs.edit().remove("crash").apply()
        MaterialAlertDialogBuilder(this)
            .setTitle("Erro detectado na execução anterior")
            .setMessage(crash)
            .setPositiveButton("OK", null)
            .show()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
