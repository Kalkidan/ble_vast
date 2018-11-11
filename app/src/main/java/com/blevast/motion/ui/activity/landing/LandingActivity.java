package com.blevast.motion.ui.activity.landing;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.blevast.motion.R;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;
import com.blevast.motion.viewmodel.callback.LandingPageCallback;
import javax.inject.Inject;

import androidx.databinding.DataBindingComponent;
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
        //Singleton instance of the view model factory
        return ViewModelProviders.of(this, modelFactory).get(LandingPageViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().setLandingButtonText("Start");
    }

    /**
     * @param viewModel
     */
    @Override
    public void startButtonCallback(LandingPageViewModel viewModel) {
        startActivity(HomePageActivity.getIntent(getApplicationContext()));
    }
}
