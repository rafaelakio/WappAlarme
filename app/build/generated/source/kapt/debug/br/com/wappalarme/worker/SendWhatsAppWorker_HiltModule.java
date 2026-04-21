package br.com.wappalarme.worker;

import androidx.hilt.work.WorkerAssistedFactory;
import androidx.work.ListenableWorker;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import javax.annotation.processing.Generated;

@Generated("androidx.hilt.AndroidXHiltProcessor")
@Module
@InstallIn(SingletonComponent.class)
@OriginatingElement(
    topLevelClass = SendWhatsAppWorker.class
)
public interface SendWhatsAppWorker_HiltModule {
  @Binds
  @IntoMap
  @StringKey("br.com.wappalarme.worker.SendWhatsAppWorker")
  WorkerAssistedFactory<? extends ListenableWorker> bind(
      SendWhatsAppWorker_AssistedFactory factory);
}
