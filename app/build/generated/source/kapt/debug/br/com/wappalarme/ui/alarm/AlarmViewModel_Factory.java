package br.com.wappalarme.ui.alarm;

import br.com.wappalarme.data.repository.AlarmRepository;
import br.com.wappalarme.data.repository.HolidayRepository;
import br.com.wappalarme.service.AlarmManagerService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AlarmViewModel_Factory implements Factory<AlarmViewModel> {
  private final Provider<AlarmRepository> alarmRepositoryProvider;

  private final Provider<HolidayRepository> holidayRepositoryProvider;

  private final Provider<AlarmManagerService> alarmManagerServiceProvider;

  public AlarmViewModel_Factory(Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<HolidayRepository> holidayRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    this.alarmRepositoryProvider = alarmRepositoryProvider;
    this.holidayRepositoryProvider = holidayRepositoryProvider;
    this.alarmManagerServiceProvider = alarmManagerServiceProvider;
  }

  @Override
  public AlarmViewModel get() {
    return newInstance(alarmRepositoryProvider.get(), holidayRepositoryProvider.get(), alarmManagerServiceProvider.get());
  }

  public static AlarmViewModel_Factory create(Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<HolidayRepository> holidayRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    return new AlarmViewModel_Factory(alarmRepositoryProvider, holidayRepositoryProvider, alarmManagerServiceProvider);
  }

  public static AlarmViewModel newInstance(AlarmRepository alarmRepository,
      HolidayRepository holidayRepository, AlarmManagerService alarmManagerService) {
    return new AlarmViewModel(alarmRepository, holidayRepository, alarmManagerService);
  }
}
