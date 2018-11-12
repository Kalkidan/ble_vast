package com.blevast.motion.adapter;

import com.blevast.motion.ui.BaseFragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

public class DefaultFragmnet extends BaseFragment {
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
