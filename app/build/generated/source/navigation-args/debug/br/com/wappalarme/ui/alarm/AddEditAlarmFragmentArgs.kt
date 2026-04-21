package br.com.wappalarme.ui.alarm

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Long
import kotlin.jvm.JvmStatic

public data class AddEditAlarmFragmentArgs(
  public val alarmId: Long = -1L,
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putLong("alarmId", this.alarmId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("alarmId", this.alarmId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AddEditAlarmFragmentArgs {
      bundle.setClassLoader(AddEditAlarmFragmentArgs::class.java.classLoader)
      val __alarmId : Long
      if (bundle.containsKey("alarmId")) {
        __alarmId = bundle.getLong("alarmId")
      } else {
        __alarmId = -1L
      }
      return AddEditAlarmFragmentArgs(__alarmId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddEditAlarmFragmentArgs {
      val __alarmId : Long?
      if (savedStateHandle.contains("alarmId")) {
        __alarmId = savedStateHandle["alarmId"]
        if (__alarmId == null) {
          throw IllegalArgumentException("Argument \"alarmId\" of type long does not support null values")
        }
      } else {
        __alarmId = -1L
      }
      return AddEditAlarmFragmentArgs(__alarmId)
    }
  }
}
