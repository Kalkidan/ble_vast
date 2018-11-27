package com.blevast.motion.adapter;

import android.view.ViewGroup;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
/********************************************
 * We will use this as a common recycle view
 * across the application purposes.
 *****************************************/
public abstract class DataBoundListAdapter<E, V extends ViewDataBinding> extends RecyclerView.Adapter<DataBoundViewHolder<V>> {

    private List<E> list;

    /**
     * @param parent
     * @param viewType
     */
    protected abstract V createViewBinding(ViewGroup parent, int viewType);

    /**
     * @param holder
     * @param position
     */
    protected abstract void bind(V holder, int position);

    /**
     * @param parent
     * @param viewType
     */
    @NonNull
    @Override
    public DataBoundViewHolder<V> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DataBoundViewHolder<>(createViewBinding(parent, viewType));
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(@NonNull DataBoundViewHolder<V> holder, int position) {
        bind(holder.binding, position);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return list != null ? 0 : this.list.size();
    }
}
