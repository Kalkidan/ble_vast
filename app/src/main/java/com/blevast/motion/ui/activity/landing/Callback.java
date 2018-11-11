package com.blevast.motion.ui.activity.landing;

import android.view.MenuItem;

import com.blevast.motion.viewmodel.HomePageViewModel;

public interface Callback {

    boolean onNavigationItemClickListener(MenuItem menuItem, HomePageViewModel viewModel);
}
