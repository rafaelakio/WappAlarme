package br.com.wappalarme.di;

import br.com.wappalarme.data.local.AppDatabase;
import br.com.wappalarme.data.local.UserConfigDao;
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
public final class DatabaseModule_ProvideUserConfigDaoFactory implements Factory<UserConfigDao> {
  private final Provider<AppDatabase> dbProvider;

  public DatabaseModule_ProvideUserConfigDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public UserConfigDao get() {
    return provideUserConfigDao(dbProvider.get());
  }

  public static DatabaseModule_ProvideUserConfigDaoFactory create(
      Provider<AppDatabase> dbProvider) {
    return new DatabaseModule_ProvideUserConfigDaoFactory(dbProvider);
  }

  public static UserConfigDao provideUserConfigDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideUserConfigDao(db));
  }
}
