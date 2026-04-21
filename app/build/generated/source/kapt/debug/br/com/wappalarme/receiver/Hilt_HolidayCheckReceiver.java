package br.com.wappalarme.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.CallSuper;
import dagger.hilt.android.internal.OnReceiveBytecodeInjectionMarker;
import dagger.hilt.android.internal.managers.BroadcastReceiverComponentManager;
import dagger.hilt.internal.UnsafeCasts;
import java.lang.Object;
import java.lang.Override;
import javax.annotation.processing.Generated;

/**
 * A generated base class to be extended by the @dagger.hilt.android.AndroidEntryPoint annotated class. If using the Gradle plugin, this is swapped as the base class via bytecode transformation.
 */
@OnReceiveBytecodeInjectionMarker
@Generated("dagger.hilt.android.processor.internal.androidentrypoint.BroadcastReceiverGenerator")
public abstract class Hilt_HolidayCheckReceiver extends BroadcastReceiver {
  private volatile boolean injected = false;

  private final Object injectedLock = new Object();

  @Override
  @CallSuper
  public void onReceive(Context context, Intent intent) {
    inject(context);
  }

  protected void inject(Context context) {
    if (!injected) {
      synchronized (injectedLock) {
        if (!injected) {
          ((HolidayCheckReceiver_GeneratedInjector) BroadcastReceiverComponentManager.generatedComponent(context)).injectHolidayCheckReceiver(UnsafeCasts.<HolidayCheckReceiver>unsafeCast(this));
          injected = true;
        }
      }
    }
  }
}
