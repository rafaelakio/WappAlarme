package br.com.wappalarme.data.repository;

import br.com.wappalarme.data.local.UserConfigDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UserConfigRepository_Factory implements Factory<UserConfigRepository> {
  private final Provider<UserConfigDao> daoProvider;

  public UserConfigRepository_Factory(Provider<UserConfigDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public UserConfigRepository get() {
    return newInstance(daoProvider.get());
  }

  public static UserConfigRepository_Factory create(Provider<UserConfigDao> daoProvider) {
    return new UserConfigRepository_Factory(daoProvider);
  }

  public static UserConfigRepository newInstance(UserConfigDao dao) {
    return new UserConfigRepository(dao);
  }
}
