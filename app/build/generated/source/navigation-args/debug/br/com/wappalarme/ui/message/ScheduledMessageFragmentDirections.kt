package br.com.wappalarme.ui.message

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import br.com.wappalarme.R

public class ScheduledMessageFragmentDirections private constructor() {
  public companion object {
    public fun actionScheduledMessageFragmentToNewMessageFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_scheduledMessageFragment_to_newMessageFragment)
  }
}
