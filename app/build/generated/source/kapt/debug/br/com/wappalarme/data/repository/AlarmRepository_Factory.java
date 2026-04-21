package br.com.wappalarme.data.repository;

import br.com.wappalarme.data.local.AlarmDao;
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
public final class AlarmRepository_Factory implements Factory<AlarmRepository> {
  private final Provider<AlarmDao> alarmDaoProvider;

  public AlarmRepository_Factory(Provider<AlarmDao> alarmDaoProvider) {
    this.alarmDaoProvider = alarmDaoProvider;
  }

  @Override
  public AlarmRepository get() {
    return newInstance(alarmDaoProvider.get());
  }

  public static AlarmRepository_Factory create(Provider<AlarmDao> alarmDaoProvider) {
    return new AlarmRepository_Factory(alarmDaoProvider);
  }

  public static AlarmRepository newInstance(AlarmDao alarmDao) {
    return new AlarmRepository(alarmDao);
  }
}
