package br.com.wappalarme.data.repository;

import br.com.wappalarme.data.remote.HolidayApiService;
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
public final class HolidayRepository_Factory implements Factory<HolidayRepository> {
  private final Provider<HolidayApiService> apiServiceProvider;

  public HolidayRepository_Factory(Provider<HolidayApiService> apiServiceProvider) {
    this.apiServiceProvider = apiServiceProvider;
  }

  @Override
  public HolidayRepository get() {
    return newInstance(apiServiceProvider.get());
  }

  public static HolidayRepository_Factory create(Provider<HolidayApiService> apiServiceProvider) {
    return new HolidayRepository_Factory(apiServiceProvider);
  }

  public static HolidayRepository newInstance(HolidayApiService apiService) {
    return new HolidayRepository(apiService);
  }
}
