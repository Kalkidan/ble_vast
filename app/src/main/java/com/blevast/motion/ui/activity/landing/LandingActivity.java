package com.blevast.motion.ui.activity.landing;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blevast.motion.R;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;

import javax.inject.Inject;

public class LandingActivity extends BaseActivity<LandingPageBinding, LandingPageViewModel> {

    @Inject LandingPageViewModel viewModel;

    @Override
    protected int getActivityView() {
        return R.layout.landing_page;
    }

    @Override
    protected LandingPageViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Get user info
        viewModel.getUserInfo();

        //Observe user info

    }
}
