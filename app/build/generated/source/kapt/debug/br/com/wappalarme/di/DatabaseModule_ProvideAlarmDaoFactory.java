package br.com.wappalarme.di;

import br.com.wappalarme.data.local.AlarmDao;
import br.com.wappalarme.data.local.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class DatabaseModule_ProvideAlarmDaoFactory implements Factory<AlarmDao> {
  private final Provider<AppDatabase> dbProvider;

  public DatabaseModule_ProvideAlarmDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public AlarmDao get() {
    return provideAlarmDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideAlarmDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new DatabaseModule_ProvideAlarmDaoFactory(dbProvider);
  }

  public static AlarmDao provideAlarmDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAlarmDao(db));
  }
}
