package com.blevast.motion.ui.activity.landing;

import android.os.Bundle;
//
import android.os.ConditionVariable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
//
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.blevast.motion.BR;
import com.blevast.motion.Constant;
import com.blevast.motion.NavigationController;
import com.blevast.motion.R;
import com.blevast.motion.databinding.ActivityBaseBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.LandingActivityViewModel;

import javax.inject.Inject;

public class LandingActivity extends BaseActivity<ActivityBaseBinding, LandingActivityViewModel> implements Callback{

    //View Model instances
    @Inject  LandingActivityViewModel viewModel;

    @Inject NavigationController navigationController;

    //
    @Override
    protected int getActivityView() {
        return R.layout.activity_base;
    }

    //
    @Override
    protected LandingActivityViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toolbar toolbar = binding.header.toolbar;
        setSupportActionBar(toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        binding.setVariable(BR.cb, this);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = binding.drawerLayout;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemClickListener(MenuItem menuItem, LandingActivityViewModel viewModel) {

        switch (menuItem.getItemId()){
            case R.id.nav_weather:
                    navigationController.getStartFragmentCallback().startFragment(Constant.WEATHER_FRAGMENT);
                break;
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
