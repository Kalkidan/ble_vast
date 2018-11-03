package com.blevast.motion.ui.activity.landing;

import android.arch.lifecycle.ViewModel;

import com.blevast.motion.R;
import com.blevast.motion.databinding.LandingPageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingPageViewModel;

public class LandingActivity extends BaseActivity<LandingPageBinding, LandingPageViewModel> {
    @Override
    protected int getActivityView() {
        return R.layout.landing_page;
    }

    @Override
    protected LandingPageViewModel getViewModel() {
        return null;
    }

}
