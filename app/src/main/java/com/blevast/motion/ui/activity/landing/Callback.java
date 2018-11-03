package com.blevast.motion.ui.activity.landing;

import android.view.MenuItem;

import com.blevast.motion.viewmodel.HighlightsPageViewModel;

public interface Callback {

    boolean onNavigationItemClickListener(MenuItem menuItem, HighlightsPageViewModel viewModel);
}
