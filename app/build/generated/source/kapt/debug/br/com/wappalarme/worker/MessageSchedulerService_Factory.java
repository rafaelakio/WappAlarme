package br.com.wappalarme.worker;

import androidx.work.WorkManager;
import br.com.wappalarme.data.repository.ScheduledMessageRepository;
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
public final class MessageSchedulerService_Factory implements Factory<MessageSchedulerService> {
  private final Provider<WorkManager> workManagerProvider;

  private final Provider<ScheduledMessageRepository> repositoryProvider;

  public MessageSchedulerService_Factory(Provider<WorkManager> workManagerProvider,
      Provider<ScheduledMessageRepository> repositoryProvider) {
    this.workManagerProvider = workManagerProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public MessageSchedulerService get() {
    return newInstance(workManagerProvider.get(), repositoryProvider.get());
  }

  public static MessageSchedulerService_Factory create(Provider<WorkManager> workManagerProvider,
      Provider<ScheduledMessageRepository> repositoryProvider) {
    return new MessageSchedulerService_Factory(workManagerProvider, repositoryProvider);
  }

  public static MessageSchedulerService newInstance(WorkManager workManager,
      ScheduledMessageRepository repository) {
    return new MessageSchedulerService(workManager, repository);
  }
}
