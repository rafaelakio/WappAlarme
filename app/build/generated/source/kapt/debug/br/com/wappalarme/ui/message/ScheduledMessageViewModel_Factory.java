package br.com.wappalarme.ui.message;

import br.com.wappalarme.data.repository.ScheduledMessageRepository;
import br.com.wappalarme.worker.MessageSchedulerService;
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
public final class ScheduledMessageViewModel_Factory implements Factory<ScheduledMessageViewModel> {
  private final Provider<ScheduledMessageRepository> repositoryProvider;

  private final Provider<MessageSchedulerService> schedulerServiceProvider;

  public ScheduledMessageViewModel_Factory(Provider<ScheduledMessageRepository> repositoryProvider,
      Provider<MessageSchedulerService> schedulerServiceProvider) {
    this.repositoryProvider = repositoryProvider;
    this.schedulerServiceProvider = schedulerServiceProvider;
  }

  @Override
  public ScheduledMessageViewModel get() {
    return newInstance(repositoryProvider.get(), schedulerServiceProvider.get());
  }

  public static ScheduledMessageViewModel_Factory create(
      Provider<ScheduledMessageRepository> repositoryProvider,
      Provider<MessageSchedulerService> schedulerServiceProvider) {
    return new ScheduledMessageViewModel_Factory(repositoryProvider, schedulerServiceProvider);
  }

  public static ScheduledMessageViewModel newInstance(ScheduledMessageRepository repository,
      MessageSchedulerService schedulerService) {
    return new ScheduledMessageViewModel(repository, schedulerService);
  }
}
