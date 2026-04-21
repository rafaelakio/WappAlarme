package br.com.wappalarme;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import br.com.wappalarme.data.local.AlarmDao;
import br.com.wappalarme.data.local.AppDatabase;
import br.com.wappalarme.data.local.ScheduledMessageDao;
import br.com.wappalarme.data.local.UserConfigDao;
import br.com.wappalarme.data.remote.HolidayApiService;
import br.com.wappalarme.data.repository.AlarmRepository;
import br.com.wappalarme.data.repository.HolidayRepository;
import br.com.wappalarme.data.repository.ScheduledMessageRepository;
import br.com.wappalarme.data.repository.UserConfigRepository;
import br.com.wappalarme.di.AppModule_ProvideWorkManagerFactory;
import br.com.wappalarme.di.DatabaseModule_ProvideAlarmDaoFactory;
import br.com.wappalarme.di.DatabaseModule_ProvideDatabaseFactory;
import br.com.wappalarme.di.DatabaseModule_ProvideScheduledMessageDaoFactory;
import br.com.wappalarme.di.DatabaseModule_ProvideUserConfigDaoFactory;
import br.com.wappalarme.di.NetworkModule_ProvideGsonFactory;
import br.com.wappalarme.di.NetworkModule_ProvideHolidayApiServiceFactory;
import br.com.wappalarme.di.NetworkModule_ProvideOkHttpClientFactory;
import br.com.wappalarme.di.NetworkModule_ProvideRetrofitFactory;
import br.com.wappalarme.receiver.BootReceiver;
import br.com.wappalarme.receiver.BootReceiver_MembersInjector;
import br.com.wappalarme.receiver.HolidayCheckReceiver;
import br.com.wappalarme.receiver.HolidayCheckReceiver_MembersInjector;
import br.com.wappalarme.receiver.WhatsAppMessageReceiver;
import br.com.wappalarme.receiver.WhatsAppMessageReceiver_MembersInjector;
import br.com.wappalarme.service.AlarmManagerService;
import br.com.wappalarme.service.WhatsAppService;
import br.com.wappalarme.ui.MainActivity;
import br.com.wappalarme.ui.alarm.AddEditAlarmFragment;
import br.com.wappalarme.ui.alarm.AlarmFragment;
import br.com.wappalarme.ui.alarm.AlarmViewModel;
import br.com.wappalarme.ui.alarm.AlarmViewModel_HiltModules;
import br.com.wappalarme.ui.message.NewMessageFragment;
import br.com.wappalarme.ui.message.ScheduledMessageFragment;
import br.com.wappalarme.ui.message.ScheduledMessageViewModel;
import br.com.wappalarme.ui.message.ScheduledMessageViewModel_HiltModules;
import br.com.wappalarme.ui.settings.SettingsFragment;
import br.com.wappalarme.ui.settings.SettingsViewModel;
import br.com.wappalarme.ui.settings.SettingsViewModel_HiltModules;
import br.com.wappalarme.util.NotificationHelper;
import br.com.wappalarme.worker.MessageSchedulerService;
import br.com.wappalarme.worker.SendWhatsAppWorker;
import br.com.wappalarme.worker.SendWhatsAppWorker_AssistedFactory;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.Gson;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerWappAlarmeApplication_HiltComponents_SingletonC {
  private DaggerWappAlarmeApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public WappAlarmeApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements WappAlarmeApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements WappAlarmeApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements WappAlarmeApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements WappAlarmeApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements WappAlarmeApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements WappAlarmeApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements WappAlarmeApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public WappAlarmeApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends WappAlarmeApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends WappAlarmeApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectAddEditAlarmFragment(AddEditAlarmFragment addEditAlarmFragment) {
    }

    @Override
    public void injectAlarmFragment(AlarmFragment alarmFragment) {
    }

    @Override
    public void injectNewMessageFragment(NewMessageFragment newMessageFragment) {
    }

    @Override
    public void injectScheduledMessageFragment(ScheduledMessageFragment scheduledMessageFragment) {
    }

    @Override
    public void injectSettingsFragment(SettingsFragment settingsFragment) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends WappAlarmeApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends WappAlarmeApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(3).put(LazyClassKeyProvider.br_com_wappalarme_ui_alarm_AlarmViewModel, AlarmViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.br_com_wappalarme_ui_message_ScheduledMessageViewModel, ScheduledMessageViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.br_com_wappalarme_ui_settings_SettingsViewModel, SettingsViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String br_com_wappalarme_ui_settings_SettingsViewModel = "br.com.wappalarme.ui.settings.SettingsViewModel";

      static String br_com_wappalarme_ui_alarm_AlarmViewModel = "br.com.wappalarme.ui.alarm.AlarmViewModel";

      static String br_com_wappalarme_ui_message_ScheduledMessageViewModel = "br.com.wappalarme.ui.message.ScheduledMessageViewModel";

      @KeepFieldType
      SettingsViewModel br_com_wappalarme_ui_settings_SettingsViewModel2;

      @KeepFieldType
      AlarmViewModel br_com_wappalarme_ui_alarm_AlarmViewModel2;

      @KeepFieldType
      ScheduledMessageViewModel br_com_wappalarme_ui_message_ScheduledMessageViewModel2;
    }
  }

  private static final class ViewModelCImpl extends WappAlarmeApplication_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AlarmViewModel> alarmViewModelProvider;

    private Provider<ScheduledMessageViewModel> scheduledMessageViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.alarmViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.scheduledMessageViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(3).put(LazyClassKeyProvider.br_com_wappalarme_ui_alarm_AlarmViewModel, ((Provider) alarmViewModelProvider)).put(LazyClassKeyProvider.br_com_wappalarme_ui_message_ScheduledMessageViewModel, ((Provider) scheduledMessageViewModelProvider)).put(LazyClassKeyProvider.br_com_wappalarme_ui_settings_SettingsViewModel, ((Provider) settingsViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String br_com_wappalarme_ui_message_ScheduledMessageViewModel = "br.com.wappalarme.ui.message.ScheduledMessageViewModel";

      static String br_com_wappalarme_ui_settings_SettingsViewModel = "br.com.wappalarme.ui.settings.SettingsViewModel";

      static String br_com_wappalarme_ui_alarm_AlarmViewModel = "br.com.wappalarme.ui.alarm.AlarmViewModel";

      @KeepFieldType
      ScheduledMessageViewModel br_com_wappalarme_ui_message_ScheduledMessageViewModel2;

      @KeepFieldType
      SettingsViewModel br_com_wappalarme_ui_settings_SettingsViewModel2;

      @KeepFieldType
      AlarmViewModel br_com_wappalarme_ui_alarm_AlarmViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // br.com.wappalarme.ui.alarm.AlarmViewModel 
          return (T) new AlarmViewModel(singletonCImpl.alarmRepositoryProvider.get(), singletonCImpl.holidayRepositoryProvider.get(), singletonCImpl.alarmManagerServiceProvider.get());

          case 1: // br.com.wappalarme.ui.message.ScheduledMessageViewModel 
          return (T) new ScheduledMessageViewModel(singletonCImpl.scheduledMessageRepositoryProvider.get(), singletonCImpl.messageSchedulerServiceProvider.get());

          case 2: // br.com.wappalarme.ui.settings.SettingsViewModel 
          return (T) new SettingsViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.userConfigRepositoryProvider.get(), singletonCImpl.alarmManagerServiceProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends WappAlarmeApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends WappAlarmeApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends WappAlarmeApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppDatabase> provideDatabaseProvider;

    private Provider<ScheduledMessageRepository> scheduledMessageRepositoryProvider;

    private Provider<WhatsAppService> whatsAppServiceProvider;

    private Provider<NotificationHelper> notificationHelperProvider;

    private Provider<SendWhatsAppWorker_AssistedFactory> sendWhatsAppWorker_AssistedFactoryProvider;

    private Provider<AlarmManagerService> alarmManagerServiceProvider;

    private Provider<WorkManager> provideWorkManagerProvider;

    private Provider<MessageSchedulerService> messageSchedulerServiceProvider;

    private Provider<UserConfigRepository> userConfigRepositoryProvider;

    private Provider<OkHttpClient> provideOkHttpClientProvider;

    private Provider<Gson> provideGsonProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<HolidayApiService> provideHolidayApiServiceProvider;

    private Provider<HolidayRepository> holidayRepositoryProvider;

    private Provider<AlarmRepository> alarmRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private ScheduledMessageDao scheduledMessageDao() {
      return DatabaseModule_ProvideScheduledMessageDaoFactory.provideScheduledMessageDao(provideDatabaseProvider.get());
    }

    private Map<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mapOfStringAndProviderOfWorkerAssistedFactoryOf(
        ) {
      return Collections.<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>>singletonMap("br.com.wappalarme.worker.SendWhatsAppWorker", ((Provider) sendWhatsAppWorker_AssistedFactoryProvider));
    }

    private HiltWorkerFactory hiltWorkerFactory() {
      return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(mapOfStringAndProviderOfWorkerAssistedFactoryOf());
    }

    private UserConfigDao userConfigDao() {
      return DatabaseModule_ProvideUserConfigDaoFactory.provideUserConfigDao(provideDatabaseProvider.get());
    }

    private AlarmDao alarmDao() {
      return DatabaseModule_ProvideAlarmDaoFactory.provideAlarmDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 2));
      this.scheduledMessageRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ScheduledMessageRepository>(singletonCImpl, 1));
      this.whatsAppServiceProvider = DoubleCheck.provider(new SwitchingProvider<WhatsAppService>(singletonCImpl, 3));
      this.notificationHelperProvider = DoubleCheck.provider(new SwitchingProvider<NotificationHelper>(singletonCImpl, 4));
      this.sendWhatsAppWorker_AssistedFactoryProvider = SingleCheck.provider(new SwitchingProvider<SendWhatsAppWorker_AssistedFactory>(singletonCImpl, 0));
      this.alarmManagerServiceProvider = DoubleCheck.provider(new SwitchingProvider<AlarmManagerService>(singletonCImpl, 5));
      this.provideWorkManagerProvider = DoubleCheck.provider(new SwitchingProvider<WorkManager>(singletonCImpl, 7));
      this.messageSchedulerServiceProvider = DoubleCheck.provider(new SwitchingProvider<MessageSchedulerService>(singletonCImpl, 6));
      this.userConfigRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserConfigRepository>(singletonCImpl, 8));
      this.provideOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 12));
      this.provideGsonProvider = DoubleCheck.provider(new SwitchingProvider<Gson>(singletonCImpl, 13));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 11));
      this.provideHolidayApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<HolidayApiService>(singletonCImpl, 10));
      this.holidayRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<HolidayRepository>(singletonCImpl, 9));
      this.alarmRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<AlarmRepository>(singletonCImpl, 14));
    }

    @Override
    public void injectWappAlarmeApplication(WappAlarmeApplication wappAlarmeApplication) {
      injectWappAlarmeApplication2(wappAlarmeApplication);
    }

    @Override
    public void injectBootReceiver(BootReceiver bootReceiver) {
      injectBootReceiver2(bootReceiver);
    }

    @Override
    public void injectHolidayCheckReceiver(HolidayCheckReceiver holidayCheckReceiver) {
      injectHolidayCheckReceiver2(holidayCheckReceiver);
    }

    @Override
    public void injectWhatsAppMessageReceiver(WhatsAppMessageReceiver whatsAppMessageReceiver) {
      injectWhatsAppMessageReceiver2(whatsAppMessageReceiver);
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    @CanIgnoreReturnValue
    private WappAlarmeApplication injectWappAlarmeApplication2(WappAlarmeApplication instance) {
      WappAlarmeApplication_MembersInjector.injectWorkerFactory(instance, hiltWorkerFactory());
      return instance;
    }

    @CanIgnoreReturnValue
    private BootReceiver injectBootReceiver2(BootReceiver instance) {
      BootReceiver_MembersInjector.injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
      BootReceiver_MembersInjector.injectMessageSchedulerService(instance, messageSchedulerServiceProvider.get());
      BootReceiver_MembersInjector.injectUserConfigRepository(instance, userConfigRepositoryProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private HolidayCheckReceiver injectHolidayCheckReceiver2(HolidayCheckReceiver instance) {
      HolidayCheckReceiver_MembersInjector.injectHolidayRepository(instance, holidayRepositoryProvider.get());
      HolidayCheckReceiver_MembersInjector.injectUserConfigRepository(instance, userConfigRepositoryProvider.get());
      HolidayCheckReceiver_MembersInjector.injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
      HolidayCheckReceiver_MembersInjector.injectNotificationHelper(instance, notificationHelperProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private WhatsAppMessageReceiver injectWhatsAppMessageReceiver2(
        WhatsAppMessageReceiver instance) {
      WhatsAppMessageReceiver_MembersInjector.injectAlarmRepository(instance, alarmRepositoryProvider.get());
      WhatsAppMessageReceiver_MembersInjector.injectAlarmManagerService(instance, alarmManagerServiceProvider.get());
      return instance;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // br.com.wappalarme.worker.SendWhatsAppWorker_AssistedFactory 
          return (T) new SendWhatsAppWorker_AssistedFactory() {
            @Override
            public SendWhatsAppWorker create(Context context, WorkerParameters workerParams) {
              return new SendWhatsAppWorker(context, workerParams, singletonCImpl.scheduledMessageRepositoryProvider.get(), singletonCImpl.whatsAppServiceProvider.get(), singletonCImpl.notificationHelperProvider.get());
            }
          };

          case 1: // br.com.wappalarme.data.repository.ScheduledMessageRepository 
          return (T) new ScheduledMessageRepository(singletonCImpl.scheduledMessageDao());

          case 2: // br.com.wappalarme.data.local.AppDatabase 
          return (T) DatabaseModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // br.com.wappalarme.service.WhatsAppService 
          return (T) new WhatsAppService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // br.com.wappalarme.util.NotificationHelper 
          return (T) new NotificationHelper(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 5: // br.com.wappalarme.service.AlarmManagerService 
          return (T) new AlarmManagerService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // br.com.wappalarme.worker.MessageSchedulerService 
          return (T) new MessageSchedulerService(singletonCImpl.provideWorkManagerProvider.get(), singletonCImpl.scheduledMessageRepositoryProvider.get());

          case 7: // androidx.work.WorkManager 
          return (T) AppModule_ProvideWorkManagerFactory.provideWorkManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // br.com.wappalarme.data.repository.UserConfigRepository 
          return (T) new UserConfigRepository(singletonCImpl.userConfigDao());

          case 9: // br.com.wappalarme.data.repository.HolidayRepository 
          return (T) new HolidayRepository(singletonCImpl.provideHolidayApiServiceProvider.get());

          case 10: // br.com.wappalarme.data.remote.HolidayApiService 
          return (T) NetworkModule_ProvideHolidayApiServiceFactory.provideHolidayApiService(singletonCImpl.provideRetrofitProvider.get());

          case 11: // retrofit2.Retrofit 
          return (T) NetworkModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpClientProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 12: // okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOkHttpClientFactory.provideOkHttpClient();

          case 13: // com.google.gson.Gson 
          return (T) NetworkModule_ProvideGsonFactory.provideGson();

          case 14: // br.com.wappalarme.data.repository.AlarmRepository 
          return (T) new AlarmRepository(singletonCImpl.alarmDao());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
