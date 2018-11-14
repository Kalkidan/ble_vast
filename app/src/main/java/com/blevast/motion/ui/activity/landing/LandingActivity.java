package com.blevast.motion.ui.activity.landing;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import com.blevast.motion.AppCypher;
import com.blevast.motion.CustomResultReciever;
import com.blevast.motion.R;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;
import com.blevast.motion.viewmodel.callback.LandingPageCallback;
import javax.inject.Inject;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

/**
 * Landing page activity.
 */

public class LandingActivity extends BaseActivity<LandingPageBinding, LandingPageViewModel> implements LandingPageCallback {

    @Inject ViewModelProvider.Factory modelFactory;

    @Inject AppCypher appCypher;

    @Override
    protected int getActivityView() {
        return R.layout.landing_page;
    }

    @Override
    protected LandingPageViewModel getViewModel() {
        //Singleton instance of the view model factory
        return ViewModelProviders.of(this, modelFactory).get(LandingPageViewModel.class);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().setLandingButtonText("Start");

    }

    /**
     * This is just for having it here to test out
     */
    private void setUpCustomIntentServiceReceiver() {
        new CustomResultReciever(new Handler()).setReceiver((resultCode, resultData) -> {

            //lets do what we want from here when we receive the messaging
        });
    }

    /**
     * @param viewModel
     */
    @Override
    public void startButtonCallback(LandingPageViewModel viewModel) {
        startActivity(HomePageActivity.getIntent(getApplicationContext()));
    }
}
