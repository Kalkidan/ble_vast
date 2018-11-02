package com.blevast.motion.ui.activity.landing;

import android.view.MenuItem;

import com.blevast.motion.viewmodel.LandingActivityViewModel;
import com.blevast.motion.viewmodel.WeatherPageViewModel;

public interface Callback {

    boolean onNavigationItemClickListener(MenuItem menuItem, LandingActivityViewModel viewModel);
}
