package br.com.wappalarme.data.remote;

/**
 * API de feriados brasileiros usando BrasilAPI (gratuita, sem autenticação).
 * Documentação: https://brasilapi.com.br/docs#tag/Feriados-Nacionais
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lbr/com/wappalarme/data/remote/HolidayApiService;", "", "getNationalHolidays", "", "Lbr/com/wappalarme/data/model/Holiday;", "year", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface HolidayApiService {
    
    /**
     * Retorna os feriados nacionais de um determinado ano.
     */
    @retrofit2.http.GET(value = "api/feriados/v1/{year}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getNationalHolidays(@retrofit2.http.Path(value = "year")
    int year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.Holiday>> $completion);
}