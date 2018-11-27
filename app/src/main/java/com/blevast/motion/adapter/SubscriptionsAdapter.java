package com.blevast.motion.adapter;

import android.view.ViewGroup;

import com.blevast.motion.R;
import com.blevast.motion.data.response.git.Subscriptions;
import com.blevast.motion.databinding.SubscriptionsRowBinding;
import com.blevast.motion.viewmodel.SubscriptionViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubscriptionsAdapter extends RecyclerView.Adapter {

    private List<Subscriptions> body;
    private  SubscriptionsRowBinding binding;

    public SubscriptionsAdapter(List<Subscriptions> body)
    {
        this.body = body;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return DataBoundViewHolder.create(parent, R.layout.subscriptions_row);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        this.binding = ((DataBoundViewHolder<SubscriptionsRowBinding>) holder).binding;
        Subscriptions sub = body.get(position);
        this.binding.setVm(new SubscriptionViewModel(sub.getFull_name()));
        this.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return this.body.size();
    }
}
