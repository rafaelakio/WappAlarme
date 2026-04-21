package br.com.wappalarme.receiver;

import br.com.wappalarme.data.repository.HolidayRepository;
import br.com.wappalarme.data.repository.UserConfigRepository;
import br.com.wappalarme.service.AlarmManagerService;
import br.com.wappalarme.util.NotificationHelper;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class HolidayCheckReceiver_MembersInjector implements MembersInjector<HolidayCheckReceiver> {
  private final Provider<HolidayRepository> holidayRepositoryProvider;

  private final Provider<UserConfigRepository> userConfigRepositoryProvider;

  private final Provider<AlarmManagerService> alarmManagerServiceProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public HolidayCheckReceiver_MembersInjector(Provider<HolidayRepository> holidayRepositoryProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.holidayRepositoryProvider = holidayRepositoryProvider;
    this.userConfigRepositoryProvider = userConfigRepositoryProvider;
    this.alarmManagerServiceProvider = alarmManagerServiceProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  public static MembersInjector<HolidayCheckReceiver> create(
      Provider<HolidayRepository> holidayRepositoryProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new HolidayCheckReceiver_MembersInjector(holidayRepositoryProvider, userConfigRepositoryProvider, alarmManagerServiceProvider, notificationHelperProvider);
  }

  @Override
  public void injectMembers(HolidayCheckReceiver instance) {
    injectHolidayRepository(instance, holidayRepositoryProvider.get());
    injectUserConfigRepository(instance, userConfigRepositoryProvider.get());
    injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
    injectNotificationHelper(instance, notificationHelperProvider.get());
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.HolidayCheckReceiver.holidayRepository")
  public static void injectHolidayRepository(HolidayCheckReceiver instance,
      HolidayRepository holidayRepository) {
    instance.holidayRepository = holidayRepository;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.HolidayCheckReceiver.userConfigRepository")
  public static void injectUserConfigRepository(HolidayCheckReceiver instance,
      UserConfigRepository userConfigRepository) {
    instance.userConfigRepository = userConfigRepository;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.HolidayCheckReceiver.alarmManagerService")
  public static void injectAlarmManagerService(HolidayCheckReceiver instance,
      AlarmManagerService alarmManagerService) {
    instance.alarmManagerService = alarmManagerService;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.HolidayCheckReceiver.notificationHelper")
  public static void injectNotificationHelper(HolidayCheckReceiver instance,
      NotificationHelper notificationHelper) {
    instance.notificationHelper = notificationHelper;
  }
}
