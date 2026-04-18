package br.com.wappalarme.data.repository

import br.com.wappalarme.data.model.HolidayInfo
import br.com.wappalarme.data.model.HolidayType
import br.com.wappalarme.data.remote.HolidayApiService
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HolidayRepository @Inject constructor(
    private val apiService: HolidayApiService
) {
    // Cache em memória para evitar chamadas repetidas à API
    private val holidayCache = mutableMapOf<Int, List<HolidayInfo>>()

    /**
     * Verifica se uma data específica é feriado.
     * @param date Data no formato yyyy-MM-dd
     * @return HolidayInfo se for feriado, null caso contrário
     */
    suspend fun getHolidayForDate(date: String): HolidayInfo? {
        val localDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)
        val year = localDate.year
        val holidays = getHolidaysForYear(year)
        return holidays.firstOrNull { it.date == date }
    }

    /**
     * Retorna todos os feriados de um ano.
     */
    suspend fun getHolidaysForYear(year: Int): List<HolidayInfo> {
        // Retorna do cache se disponível
        holidayCache[year]?.let { return it }

        return try {
            val apiHolidays = apiService.getNationalHolidays(year)
            val holidays = apiHolidays.map { holiday ->
                HolidayInfo(
                    date = holiday.date,
                    name = holiday.localName,
                    type = HolidayType.NATIONAL
                )
            }
            holidayCache[year] = holidays
            holidays
        } catch (e: Exception) {
            // Em caso de falha de rede, retorna lista vazia
            emptyList()
        }
    }

    /**
     * Retorna o próximo dia útil após uma data.
     * Considera sábado e domingo como não úteis, além de feriados.
     * @param date Data de referência no formato yyyy-MM-dd
     * @return Próximo dia útil no formato yyyy-MM-dd
     */
    suspend fun getNextWorkingDay(date: String): String {
        var current = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE)
        val formatter = DateTimeFormatter.ISO_LOCAL_DATE

        do {
            current = current.plusDays(1)
            val dateStr = current.format(formatter)
            val isWeekend = current.dayOfWeek.value >= 6 // 6=Sábado, 7=Domingo
            val isHoliday = getHolidayForDate(dateStr) != null
        } while (isWeekend || isHoliday)

        return current.format(formatter)
    }

    /**
     * Verifica se amanhã é feriado.
     * @return HolidayInfo se amanhã for feriado, null caso contrário
     */
    suspend fun isTomorrowHoliday(): HolidayInfo? {
        val tomorrow = LocalDate.now().plusDays(1)
        val tomorrowStr = tomorrow.format(DateTimeFormatter.ISO_LOCAL_DATE)
        return getHolidayForDate(tomorrowStr)
    }

    /**
     * Limpa o cache (útil para forçar atualização).
     */
    fun clearCache() {
        holidayCache.clear()
    }
}
