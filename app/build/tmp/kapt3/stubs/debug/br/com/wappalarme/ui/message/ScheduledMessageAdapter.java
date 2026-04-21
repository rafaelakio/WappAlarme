package br.com.wappalarme.ui.message;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0013\u0014B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u000b\u001a\u00020\u00062\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lbr/com/wappalarme/ui/message/ScheduledMessageAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "Lbr/com/wappalarme/ui/message/ScheduledMessageAdapter$MessageViewHolder;", "onCancel", "Lkotlin/Function1;", "", "onDelete", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "dateFormat", "Ljava/text/SimpleDateFormat;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MessageDiffCallback", "MessageViewHolder", "app_debug"})
public final class ScheduledMessageAdapter extends androidx.recyclerview.widget.ListAdapter<br.com.wappalarme.data.model.ScheduledMessageEntity, br.com.wappalarme.ui.message.ScheduledMessageAdapter.MessageViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<br.com.wappalarme.data.model.ScheduledMessageEntity, kotlin.Unit> onCancel = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<br.com.wappalarme.data.model.ScheduledMessageEntity, kotlin.Unit> onDelete = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateFormat = null;
    
    public ScheduledMessageAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super br.com.wappalarme.data.model.ScheduledMessageEntity, kotlin.Unit> onCancel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super br.com.wappalarme.data.model.ScheduledMessageEntity, kotlin.Unit> onDelete) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public br.com.wappalarme.ui.message.ScheduledMessageAdapter.MessageViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    br.com.wappalarme.ui.message.ScheduledMessageAdapter.MessageViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lbr/com/wappalarme/ui/message/ScheduledMessageAdapter$MessageDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class MessageDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<br.com.wappalarme.data.model.ScheduledMessageEntity> {
        
        public MessageDiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        br.com.wappalarme.data.model.ScheduledMessageEntity oldItem, @org.jetbrains.annotations.NotNull()
        br.com.wappalarme.data.model.ScheduledMessageEntity newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        br.com.wappalarme.data.model.ScheduledMessageEntity oldItem, @org.jetbrains.annotations.NotNull()
        br.com.wappalarme.data.model.ScheduledMessageEntity newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lbr/com/wappalarme/ui/message/ScheduledMessageAdapter$MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lbr/com/wappalarme/databinding/ItemScheduledMessageBinding;", "(Lbr/com/wappalarme/ui/message/ScheduledMessageAdapter;Lbr/com/wappalarme/databinding/ItemScheduledMessageBinding;)V", "bind", "", "message", "Lbr/com/wappalarme/data/model/ScheduledMessageEntity;", "app_debug"})
    public final class MessageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final br.com.wappalarme.databinding.ItemScheduledMessageBinding binding = null;
        
        public MessageViewHolder(@org.jetbrains.annotations.NotNull()
        br.com.wappalarme.databinding.ItemScheduledMessageBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        br.com.wappalarme.data.model.ScheduledMessageEntity message) {
        }
    }
}