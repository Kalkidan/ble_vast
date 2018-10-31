package com.blevast.motion.callback;

import android.view.MenuItem;

import com.blevast.motion.viewmodel.WeatherPageViewModel;

public interface LandingPageCallback {

    boolean onNavigationItemClickListener(MenuItem menuItem, WeatherPageViewModel landingPageViewModel);
}
