package com.blevast.motion.ui.activity.landing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.blevast.motion.R;
import com.blevast.motion.adapter.CustomFragmentPagerAdapter;
import com.blevast.motion.data.response.git.User;
import com.blevast.motion.databinding.ActivityHomePageBinding;
import com.blevast.motion.ui.BaseActivity;
import com.blevast.motion.viewmodel.HomePageViewModel;
import com.blevast.motion.viewmodel.callback.NavigationViewClickListener;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

public class HomePageActivity extends BaseActivity<ActivityHomePageBinding, HomePageViewModel> implements NavigationViewClickListener {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getActivityView() {
        return R.layout.activity_home_page;
    }

    @Override
    protected HomePageViewModel getViewModel() {
        return ViewModelProviders.of(this, modelFactory).get(HomePageViewModel.class);
    }

    public static Intent getIntent(Context applicationContext) {
        return new Intent(applicationContext, HomePageActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        Toolbar toolbar = binding.header.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //
        DrawerLayout drawer = binding.drawerLayout;
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        ViewPager vp = binding.header.viewpager;

        CustomFragmentPagerAdapter adapter;
        //Setup the viewpager
        vp.setAdapter(adapter = new CustomFragmentPagerAdapter(this.getSupportFragmentManager(), getApplicationContext()));
        //Set up the tab layout
        binding.header.detailTabs.setupWithViewPager(vp);

        getViewModel().setGithubUser("Kalkidan");

        //Start observe data
        getViewModel().getUserDataResponse().observe(this, user -> {
           User gitHubUser = user.getBody();
           getViewModel().setAvatarUrl(gitHubUser.getAvatarUrl());

        });
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
        getMenuInflater().inflate(R.menu.home_page, menu);
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


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationViewItemClickListener(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = binding.drawerLayout;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
