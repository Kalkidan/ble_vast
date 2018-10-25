package com.blevast.motion.callback;

import android.view.MenuItem;

import com.blevast.motion.viewmodel.LandingPageViewModel;

public interface LandingPageCallback {

    boolean onNavigationItemClickListener(MenuItem menuItem, LandingPageViewModel landingPageViewModel);
}
