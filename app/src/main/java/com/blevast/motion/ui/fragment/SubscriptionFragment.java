package com.blevast.motion.ui.fragment;

import android.widget.Toast;

import com.blevast.motion.R;
import com.blevast.motion.adapter.SubscriptionsAdapter;
import com.blevast.motion.data.response.git.Subscriptions;
import com.blevast.motion.databinding.RepoFragmentBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.HomePageViewModel;

import java.util.List;

import javax.inject.Inject;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

public class SubscriptionFragment extends BaseFragment<RepoFragmentBinding, HomePageViewModel> {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.repo_fragment;
    }

    @Override
    protected void attachObserver() {
        getViewModel().loadSubscription("Kalkidan", "subscriptions");
        getViewModel().getSubscriptions().observe(this, subscription->{

            binding.recyclerView.setAdapter(new SubscriptionsAdapter(subscription.getBody()));
            binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        });
    }

    @Override
    protected HomePageViewModel getViewModel() {
        return ViewModelProviders.of(getActivity(), modelFactory).get(HomePageViewModel.class);
    }

    @Override
    protected void createViewModle() { }
}
