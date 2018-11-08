package com.blevast.motion.ui.activity.landing;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.blevast.motion.R;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;
import com.blevast.motion.viewmodel.callback.LandingPageCallback;

import javax.inject.Inject;

public class LandingActivity extends BaseActivity<LandingPageBinding, LandingPageViewModel> implements LandingPageCallback {

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
        //
        viewModel.setLandingButtonText("Start");

        //Observe user info

    }

    @Override
    public void startButtonCallback(LandingPageViewModel viewModel) {
        //First store it in shared preferences
        //that it has been shown already
        //this will be part of the api call, so we check up on launcth
        startActivity(HighLightActivity.createIntent(getApplicationContext()));
    }
}
