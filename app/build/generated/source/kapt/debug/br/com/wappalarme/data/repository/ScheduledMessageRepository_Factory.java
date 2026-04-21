package br.com.wappalarme.data.repository;

import br.com.wappalarme.data.local.ScheduledMessageDao;
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
public final class ScheduledMessageRepository_Factory implements Factory<ScheduledMessageRepository> {
  private final Provider<ScheduledMessageDao> daoProvider;

  public ScheduledMessageRepository_Factory(Provider<ScheduledMessageDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public ScheduledMessageRepository get() {
    return newInstance(daoProvider.get());
  }

  public static ScheduledMessageRepository_Factory create(
      Provider<ScheduledMessageDao> daoProvider) {
    return new ScheduledMessageRepository_Factory(daoProvider);
  }

  public static ScheduledMessageRepository newInstance(ScheduledMessageDao dao) {
    return new ScheduledMessageRepository(dao);
  }
}
