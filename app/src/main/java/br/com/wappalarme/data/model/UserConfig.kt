package br.com.wappalarme.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Configurações do usuário armazenadas localmente.
 */
@Entity(tableName = "user_config")
data class UserConfig(
    @PrimaryKey
    val id: Int = 1, // Sempre um único registro

    /** Cidade do usuário para verificação de feriados */
    val city: String = "",

    /** Estado (UF) do usuário */
    val state: String = "SP",

    /** Código IBGE da cidade (usado na API de feriados) */
    val cityIbgeCode: String = "",

    /** Se deve verificar feriados municipais além dos nacionais/estaduais */
    val checkMunicipalHolidays: Boolean = true,

    /** Horário para verificar feriados do dia seguinte (formato HH:mm, padrão 20:00) */
    val holidayCheckTime: String = "20:00",

    /** Se as notificações de feriado estão habilitadas */
    val holidayNotificationsEnabled: Boolean = true,

    /** Última data verificada para feriados (yyyy-MM-dd) */
    val lastHolidayCheckDate: String? = null
)
