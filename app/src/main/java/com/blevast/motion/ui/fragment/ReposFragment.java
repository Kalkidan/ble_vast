package com.blevast.motion.ui.fragment;

import com.blevast.motion.ui.BaseFragment;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ReposFragment extends BaseFragment {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getFragmentLayout() {
        return 0;
    }

    @Override
    protected void attachObserver() {

    }

    @Override
    protected ViewModel getViewModel() {
        return null;
    }
}
