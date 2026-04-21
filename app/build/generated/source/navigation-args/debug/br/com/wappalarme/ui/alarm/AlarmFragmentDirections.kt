package br.com.wappalarme.ui.alarm

import android.os.Bundle
import androidx.navigation.NavDirections
import br.com.wappalarme.R
import kotlin.Int
import kotlin.Long

public class AlarmFragmentDirections private constructor() {
  private data class ActionAlarmFragmentToAddEditAlarmFragment(
    public val alarmId: Long = -1L,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_alarmFragment_to_addEditAlarmFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putLong("alarmId", this.alarmId)
        return result
      }
  }

  public companion object {
    public fun actionAlarmFragmentToAddEditAlarmFragment(alarmId: Long = -1L): NavDirections =
        ActionAlarmFragmentToAddEditAlarmFragment(alarmId)
  }
}
