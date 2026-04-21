package br.com.wappalarme.service;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class WhatsAppService_Factory implements Factory<WhatsAppService> {
  private final Provider<Context> contextProvider;

  public WhatsAppService_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public WhatsAppService get() {
    return newInstance(contextProvider.get());
  }

  public static WhatsAppService_Factory create(Provider<Context> contextProvider) {
    return new WhatsAppService_Factory(contextProvider);
  }

  public static WhatsAppService newInstance(Context context) {
    return new WhatsAppService(context);
  }
}
