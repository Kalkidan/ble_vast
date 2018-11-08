package com.blevast.motion.ui.activity.landing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
//
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.blevast.motion.BR;
import com.blevast.motion.Constant;
import com.blevast.motion.NavigationController;
import com.blevast.motion.R;
import com.blevast.motion.databinding.ActivityBaseBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.HighlightsPageViewModel;

import javax.inject.Inject;

public class HighLightActivity extends BaseActivity<ActivityBaseBinding, HighlightsPageViewModel> implements Callback{

    //View Model instances
    @Inject HighlightsPageViewModel viewModel;

    @Inject NavigationController navigationController;

    public static Intent createIntent(Context applicationContext) {
        return new Intent(applicationContext, TrailActivity.class);
    }


    //
    @Override
    protected int getActivityView() {
        return R.layout.activity_base;
    }

    //
    @Override
    protected HighlightsPageViewModel getViewModel() {
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //
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

        //
        navigationController.getStartFragmentCallback().startFragment(Constant.WEATHER_FRAGMENT);
    }

    @Override
    public void onBackPressed() {

        //Takecare of the drawer
        DrawerLayout drawer = binding.drawerLayout;
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

            //
        } else {
            if(getSupportFragmentManager().getBackStackEntryCount() ==1){
                finish();
            } else {
                super.onBackPressed();
            }
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
    public boolean onNavigationItemClickListener(MenuItem menuItem, HighlightsPageViewModel viewModel) {

        switch (menuItem.getItemId()){
            case R.id.nav_ad:
                    navigationController.getStartFragmentCallback().startFragment(Constant.WEATHER_FRAGMENT);
                break;
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
