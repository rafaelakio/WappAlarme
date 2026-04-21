package br.com.wappalarme.receiver;

import br.com.wappalarme.data.repository.UserConfigRepository;
import br.com.wappalarme.service.AlarmManagerService;
import br.com.wappalarme.worker.MessageSchedulerService;
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
public final class BootReceiver_MembersInjector implements MembersInjector<BootReceiver> {
  private final Provider<AlarmManagerService> alarmManagerServiceProvider;

  private final Provider<MessageSchedulerService> messageSchedulerServiceProvider;

  private final Provider<UserConfigRepository> userConfigRepositoryProvider;

  public BootReceiver_MembersInjector(Provider<AlarmManagerService> alarmManagerServiceProvider,
      Provider<MessageSchedulerService> messageSchedulerServiceProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider) {
    this.alarmManagerServiceProvider = alarmManagerServiceProvider;
    this.messageSchedulerServiceProvider = messageSchedulerServiceProvider;
    this.userConfigRepositoryProvider = userConfigRepositoryProvider;
  }

  public static MembersInjector<BootReceiver> create(
      Provider<AlarmManagerService> alarmManagerServiceProvider,
      Provider<MessageSchedulerService> messageSchedulerServiceProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider) {
    return new BootReceiver_MembersInjector(alarmManagerServiceProvider, messageSchedulerServiceProvider, userConfigRepositoryProvider);
  }

  @Override
  public void injectMembers(BootReceiver instance) {
    injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
    injectMessageSchedulerService(instance, messageSchedulerServiceProvider.get());
    injectUserConfigRepository(instance, userConfigRepositoryProvider.get());
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.BootReceiver.alarmManagerService")
  public static void injectAlarmManagerService(BootReceiver instance,
      AlarmManagerService alarmManagerService) {
    instance.alarmManagerService = alarmManagerService;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.BootReceiver.messageSchedulerService")
  public static void injectMessageSchedulerService(BootReceiver instance,
      MessageSchedulerService messageSchedulerService) {
    instance.messageSchedulerService = messageSchedulerService;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.BootReceiver.userConfigRepository")
  public static void injectUserConfigRepository(BootReceiver instance,
      UserConfigRepository userConfigRepository) {
    instance.userConfigRepository = userConfigRepository;
  }
}
