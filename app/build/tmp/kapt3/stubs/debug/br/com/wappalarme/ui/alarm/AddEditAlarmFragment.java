package br.com.wappalarme.ui.alarm;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\u001a\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020!H\u0002J\b\u0010%\u001a\u00020!H\u0002J\b\u0010&\u001a\u00020!H\u0002J\b\u0010\'\u001a\u00020!H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006("}, d2 = {"Lbr/com/wappalarme/ui/alarm/AddEditAlarmFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lbr/com/wappalarme/databinding/FragmentAddEditAlarmBinding;", "args", "Lbr/com/wappalarme/ui/alarm/AddEditAlarmFragmentArgs;", "getArgs", "()Lbr/com/wappalarme/ui/alarm/AddEditAlarmFragmentArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "getBinding", "()Lbr/com/wappalarme/databinding/FragmentAddEditAlarmBinding;", "selectedDays", "", "selectedHour", "selectedMinute", "viewModel", "Lbr/com/wappalarme/ui/alarm/AlarmViewModel;", "getViewModel", "()Lbr/com/wappalarme/ui/alarm/AlarmViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "setupDayChips", "setupSaveButton", "setupTimeButton", "updateTimeDisplay", "app_debug"})
public final class AddEditAlarmFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private br.com.wappalarme.databinding.FragmentAddEditAlarmBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    private int selectedHour = 7;
    private int selectedMinute = 0;
    private int selectedDays = 0;
    
    public AddEditAlarmFragment() {
        super();
    }
    
    private final br.com.wappalarme.databinding.FragmentAddEditAlarmBinding getBinding() {
        return null;
    }
    
    private final br.com.wappalarme.ui.alarm.AlarmViewModel getViewModel() {
        return null;
    }
    
    private final br.com.wappalarme.ui.alarm.AddEditAlarmFragmentArgs getArgs() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupTimeButton() {
    }
    
    private final void setupDayChips() {
    }
    
    private final void setupSaveButton() {
    }
    
    private final void updateTimeDisplay() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}