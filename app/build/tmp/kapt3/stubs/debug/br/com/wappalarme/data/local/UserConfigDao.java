package br.com.wappalarme.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lbr/com/wappalarme/data/local/UserConfigDao;", "", "getConfig", "Lkotlinx/coroutines/flow/Flow;", "Lbr/com/wappalarme/data/model/UserConfig;", "getConfigOnce", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveConfig", "", "config", "(Lbr/com/wappalarme/data/model/UserConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLastCheckDate", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface UserConfigDao {
    
    @androidx.room.Query(value = "SELECT * FROM user_config WHERE id = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<br.com.wappalarme.data.model.UserConfig> getConfig();
    
    @androidx.room.Query(value = "SELECT * FROM user_config WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getConfigOnce(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super br.com.wappalarme.data.model.UserConfig> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveConfig(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.data.model.UserConfig config, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE user_config SET lastHolidayCheckDate = :date WHERE id = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateLastCheckDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}