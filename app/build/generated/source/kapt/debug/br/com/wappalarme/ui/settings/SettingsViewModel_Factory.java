package br.com.wappalarme.ui.settings;

import android.content.Context;
import br.com.wappalarme.data.repository.UserConfigRepository;
import br.com.wappalarme.service.AlarmManagerService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class SettingsViewModel_Factory implements Factory<SettingsViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<UserConfigRepository> userConfigRepositoryProvider;

  private final Provider<AlarmManagerService> alarmManagerServiceProvider;

  public SettingsViewModel_Factory(Provider<Context> contextProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    this.contextProvider = contextProvider;
    this.userConfigRepositoryProvider = userConfigRepositoryProvider;
    this.alarmManagerServiceProvider = alarmManagerServiceProvider;
  }

  @Override
  public SettingsViewModel get() {
    return newInstance(contextProvider.get(), userConfigRepositoryProvider.get(), alarmManagerServiceProvider.get());
  }

  public static SettingsViewModel_Factory create(Provider<Context> contextProvider,
      Provider<UserConfigRepository> userConfigRepositoryProvider,
      Provider<AlarmManagerService> alarmManagerServiceProvider) {
    return new SettingsViewModel_Factory(contextProvider, userConfigRepositoryProvider, alarmManagerServiceProvider);
  }

  public static SettingsViewModel newInstance(Context context,
      UserConfigRepository userConfigRepository, AlarmManagerService alarmManagerService) {
    return new SettingsViewModel(context, userConfigRepository, alarmManagerService);
  }
}
