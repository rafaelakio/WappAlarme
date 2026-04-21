package br.com.wappalarme;

import androidx.hilt.work.HiltWorkerFactory;
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
public final class WappAlarmeApplication_MembersInjector implements MembersInjector<WappAlarmeApplication> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public WappAlarmeApplication_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<WappAlarmeApplication> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new WappAlarmeApplication_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(WappAlarmeApplication instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("br.com.wappalarme.WappAlarmeApplication.workerFactory")
  public static void injectWorkerFactory(WappAlarmeApplication instance,
      HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
