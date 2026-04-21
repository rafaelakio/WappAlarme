package br.com.wappalarme.receiver;

import br.com.wappalarme.data.repository.AlarmRepository;
import br.com.wappalarme.service.AlarmManagerService;
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
public final class WhatsAppMessageReceiver_MembersInjector implements MembersInjector<WhatsAppMessageReceiver> {
  private final Provider<AlarmRepository> alarmRepositoryProvider;

  private final Provider<AlarmManagerService> alarmManagerServiceProvider;

  public WhatsAppMessageReceiver_MembersInjector(Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    this.alarmRepositoryProvider = alarmRepositoryProvider;
    this.alarmManagerServiceProvider = alarmManagerServiceProvider;
  }

  public static MembersInjector<WhatsAppMessageReceiver> create(
      Provider<AlarmRepository> alarmRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    return new WhatsAppMessageReceiver_MembersInjector(alarmRepositoryProvider, alarmManagerServiceProvider);
  }

  @Override
  public void injectMembers(WhatsAppMessageReceiver instance) {
    injectAlarmRepository(instance, alarmRepositoryProvider.get());
    injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.WhatsAppMessageReceiver.alarmRepository")
  public static void injectAlarmRepository(WhatsAppMessageReceiver instance,
      AlarmRepository alarmRepository) {
    instance.alarmRepository = alarmRepository;
  }

  @InjectedFieldSignature("br.com.wappalarme.receiver.WhatsAppMessageReceiver.alarmManagerService")
  public static void injectAlarmManagerService(WhatsAppMessageReceiver instance,
      AlarmManagerService alarmManagerService) {
    instance.alarmManagerService = alarmManagerService;
  }
}
