package br.com.wappalarme.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class SendWhatsAppWorker_AssistedFactory_Impl implements SendWhatsAppWorker_AssistedFactory {
  private final SendWhatsAppWorker_Factory delegateFactory;

  SendWhatsAppWorker_AssistedFactory_Impl(SendWhatsAppWorker_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public SendWhatsAppWorker create(Context arg0, WorkerParameters arg1) {
    return delegateFactory.get(arg0, arg1);
  }

  public static Provider<SendWhatsAppWorker_AssistedFactory> create(
      SendWhatsAppWorker_Factory delegateFactory) {
    return InstanceFactory.create(new SendWhatsAppWorker_AssistedFactory_Impl(delegateFactory));
  }

  public static dagger.internal.Provider<SendWhatsAppWorker_AssistedFactory> createFactoryProvider(
      SendWhatsAppWorker_Factory delegateFactory) {
    return InstanceFactory.create(new SendWhatsAppWorker_AssistedFactory_Impl(delegateFactory));
  }
}
