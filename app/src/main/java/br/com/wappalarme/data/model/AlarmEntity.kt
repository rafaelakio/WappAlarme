package br.com.wappalarme.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa um alarme gerenciado pelo app.
 * O app espelha os alarmes do sistema e controla sua ativação/desativação em feriados.
 */
@Entity(tableName = "alarms")
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    /** ID do alarme no sistema Android (AlarmManager) */
    val systemAlarmId: Int,

    /** Hora do alarme (0-23) */
    val hour: Int,

    /** Minuto do alarme (0-59) */
    val minute: Int,

    /** Rótulo/descrição do alarme */
    val label: String = "",

    /** Dias da semana ativos: bitmask (1=Dom, 2=Seg, 4=Ter, 8=Qua, 16=Qui, 32=Sex, 64=Sab) */
    val daysOfWeek: Int = 0,

    /** Se o alarme está ativo */
    val isEnabled: Boolean = true,

    /** Se o alarme foi desativado temporariamente por feriado */
    val disabledForHoliday: Boolean = false,

    /** Data em que o alarme foi desativado por feriado (yyyy-MM-dd) */
    val holidayDisabledDate: String? = null,

    /** Data de criação */
    val createdAt: Long = System.currentTimeMillis()
)
