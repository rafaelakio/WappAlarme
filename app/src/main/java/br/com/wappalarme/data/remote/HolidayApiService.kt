package br.com.wappalarme.data.remote

import br.com.wappalarme.data.model.Holiday
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * API de feriados brasileiros usando BrasilAPI (gratuita, sem autenticação).
 * Documentação: https://brasilapi.com.br/docs#tag/Feriados-Nacionais
 */
interface HolidayApiService {

    /**
     * Retorna os feriados nacionais de um determinado ano.
     */
    @GET("api/feriados/v1/{year}")
    suspend fun getNationalHolidays(
        @Path("year") year: Int
    ): List<Holiday>
}
