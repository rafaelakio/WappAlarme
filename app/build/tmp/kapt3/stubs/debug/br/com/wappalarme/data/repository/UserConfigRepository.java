package br.com.wappalarme.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lbr/com/wappalarme/data/repository/UserConfigRepository;", "", "dao", "Lbr/com/wappalarme/data/local/UserConfigDao;", "(Lbr/com/wappalarme/data/local/UserConfigDao;)V", "getConfig", "Lkotlinx/coroutines/flow/Flow;", "Lbr/com/wappalarme/data/model/UserConfig;", "getConfigOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrDefault", "saveConfig", "", "config", "(Lbr/com/wappalarme/data/model/UserConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastCheckDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserConfigRepository {
    @org.jetbrains.annotations.NotNull()
    private final br.com.wappalarme.data.local.UserConfigDao dao = null;
    
    @javax.inject.Inject()
    public UserConfigRepository(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.local.UserConfigDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<br.com.wappalarme.data.model.UserConfig> getConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getConfigOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.UserConfig> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveConfig(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.UserConfig config, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLastCheckDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    /**
     * Retorna a configuração atual ou um padrão se não existir.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOrDefault(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.UserConfig> $completion) {
        return null;
    }
}