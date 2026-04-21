package br.com.wappalarme.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0086@\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lbr/com/wappalarme/data/repository/HolidayRepository;", "", "apiService", "Lbr/com/wappalarme/data/remote/HolidayApiService;", "(Lbr/com/wappalarme/data/remote/HolidayApiService;)V", "holidayCache", "", "", "", "Lbr/com/wappalarme/data/model/HolidayInfo;", "clearCache", "", "getHolidayForDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHolidaysForYear", "year", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNextWorkingDay", "isTomorrowHoliday", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class HolidayRepository {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.remote.HolidayApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Integer, java.util.List<br.com.wappalarme.data.model.HolidayInfo>> holidayCache = null;
    
    @javax.inject.Inject()
    public HolidayRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.remote.HolidayApiService apiService) {
        super();
    }
    
    /**
     * Verifica se uma data específica é feriado.
     * @param date Data no formato yyyy-MM-dd
     * @return HolidayInfo se for feriado, null caso contrário
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHolidayForDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.HolidayInfo> $completion) {
        return null;
    }
    
    /**
     * Retorna todos os feriados de um ano.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getHolidaysForYear(int year, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<br.com.wappalarme.data.model.HolidayInfo>> $completion) {
        return null;
    }
    
    /**
     * Retorna o próximo dia útil após uma data.
     * Considera sábado e domingo como não úteis, além de feriados.
     * @param date Data de referência no formato yyyy-MM-dd
     * @return Próximo dia útil no formato yyyy-MM-dd
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getNextWorkingDay(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    /**
     * Verifica se amanhã é feriado.
     * @return HolidayInfo se amanhã for feriado, null caso contrário
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object isTomorrowHoliday(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.HolidayInfo> $completion) {
        return null;
    }
    
    /**
     * Limpa o cache (útil para forçar atualização).
     */
    public final void clearCache() {
    }
}