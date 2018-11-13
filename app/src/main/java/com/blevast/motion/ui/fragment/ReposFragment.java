package com.blevast.motion.ui.fragment;

import com.blevast.motion.R;
import com.blevast.motion.databinding.RepoFragmentBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.ReposFragmentViewModel;
import javax.inject.Inject;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class ReposFragment extends BaseFragment<RepoFragmentBinding, ReposFragmentViewModel> {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.repo_fragment;
    }

    @Override
    protected void attachObserver() { }

    @Override
    protected ReposFragmentViewModel getViewModel() {
        return ViewModelProviders.of(this, modelFactory).get(ReposFragmentViewModel.class);
    }
}
