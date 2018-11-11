package com.blevast.motion.ui.activity.landing;

import android.os.Bundle;

import com.blevast.motion.R;
import com.blevast.motion.di.module.ViewModelFactory;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;
import com.blevast.motion.viewmodel.callback.LandingPageCallback;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.DataBinderMapperImpl;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class LandingActivity extends BaseActivity<LandingPageBinding, LandingPageViewModel> implements LandingPageCallback {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getActivityView() {
        return R.layout.landing_page;
    }

    @Override
    protected LandingPageViewModel getViewModel() {
        return ViewModelProviders.of(this, modelFactory).get(LandingPageViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void startButtonCallback(LandingPageViewModel viewModel) {

    }
}
