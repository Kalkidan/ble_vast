package com.blevast.motion.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.blevast.motion.R;
import com.blevast.motion.VastAdapterListener;
import com.blevast.motion.databinding.VastReportingAdapterBinding;

/**
 *
 * This will be a general adapter
 */

public class VastAdapter extends RecyclerView.Adapter implements VastAdapterListener {


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
            case 2:
                return DataBoundViewHolder.create(parent, R.layout.vast_reporting_adapter);
                default:
                    //Default it to a certain view
        }
        return DataBoundViewHolder.create(parent, R.layout.vast_reporting_adapter);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        DataBoundViewHolder<VastReportingAdapterBinding>  vastHolder = (DataBoundViewHolder<VastReportingAdapterBinding>) holder;
        vastHolder.binding.setCallback(this);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
