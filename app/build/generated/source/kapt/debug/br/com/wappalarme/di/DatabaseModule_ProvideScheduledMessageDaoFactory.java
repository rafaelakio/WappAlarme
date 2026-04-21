package br.com.wappalarme.di;

import br.com.wappalarme.data.local.AppDatabase;
import br.com.wappalarme.data.local.ScheduledMessageDao;
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
public final class DatabaseModule_ProvideScheduledMessageDaoFactory implements Factory<ScheduledMessageDao> {
  private final Provider<AppDatabase> dbProvider;

  public DatabaseModule_ProvideScheduledMessageDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ScheduledMessageDao get() {
    return provideScheduledMessageDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideScheduledMessageDaoFactory create(
      Provider<AppDatabase> dbProvider) {
    return new DatabaseModule_ProvideScheduledMessageDaoFactory(dbProvider);
  }

  public static ScheduledMessageDao provideScheduledMessageDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideScheduledMessageDao(db));
  }
}
