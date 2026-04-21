package br.com.wappalarme.di;

import br.com.wappalarme.data.remote.HolidayApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideHolidayApiServiceFactory implements Factory<HolidayApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideHolidayApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public HolidayApiService get() {
    return provideHolidayApiService(retrofitProvider.get());
  }

  public static NetworkModule_ProvideHolidayApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideHolidayApiServiceFactory(retrofitProvider);
  }

  public static HolidayApiService provideHolidayApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideHolidayApiService(retrofit));
  }
}
