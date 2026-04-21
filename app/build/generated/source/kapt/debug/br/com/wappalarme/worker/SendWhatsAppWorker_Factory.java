package br.com.wappalarme.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import br.com.wappalarme.data.repository.ScheduledMessageRepository;
import br.com.wappalarme.service.WhatsAppService;
import br.com.wappalarme.util.NotificationHelper;
import dagger.internal.DaggerGenerated;
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
public final class SendWhatsAppWorker_Factory {
  private final Provider<ScheduledMessageRepository> repositoryProvider;

  private final Provider<WhatsAppService> whatsAppServiceProvider;

  private final Provider<NotificationHelper> notificationHelperProvider;

  public SendWhatsAppWorker_Factory(Provider<ScheduledMessageRepository> repositoryProvider,
      Provider<WhatsAppService> whatsAppServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    this.repositoryProvider = repositoryProvider;
    this.whatsAppServiceProvider = whatsAppServiceProvider;
    this.notificationHelperProvider = notificationHelperProvider;
  }

  public SendWhatsAppWorker get(Context context, WorkerParameters workerParams) {
    return newInstance(context, workerParams, repositoryProvider.get(), whatsAppServiceProvider.get(), notificationHelperProvider.get());
  }

  public static SendWhatsAppWorker_Factory create(
      Provider<ScheduledMessageRepository> repositoryProvider,
      Provider<WhatsAppService> whatsAppServiceProvider,
      Provider<NotificationHelper> notificationHelperProvider) {
    return new SendWhatsAppWorker_Factory(repositoryProvider, whatsAppServiceProvider, notificationHelperProvider);
  }

  public static SendWhatsAppWorker newInstance(Context context, WorkerParameters workerParams,
      ScheduledMessageRepository repository, WhatsAppService whatsAppService,
      NotificationHelper notificationHelper) {
    return new SendWhatsAppWorker(context, workerParams, repository, whatsAppService, notificationHelper);
  }
}
