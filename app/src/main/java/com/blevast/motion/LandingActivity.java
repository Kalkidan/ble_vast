package com.blevast.motion;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.blevast.motion.callback.LandingPageCallback;
import com.blevast.motion.viewmodel.WeatherPageViewModel;

public class LandingActivity extends Activity implements LandingPageCallback {

    //
  /*  @Inject SharedPreferences app;

    @Inject NavigationController navigationController;

    @Inject WeatherPageViewModel landingPageViewModel;*/

    //
   /* @Override public int inflateView() {
        return R.layout.landing_page;
    }

    //This returns the view model
    @Override
    public WeatherPageViewModel getViewModel() {
        return ViewModelProviders.of(this).get(WeatherPageViewModel.class);
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        //Set the callback listener
       /* getViewbinding().setVariable(BR.cb, this);

        //Instances of score card view
        //With provider class
        //Score card view
        //Get the toolbar instancee
        Toolbar toolbar = getViewbinding().head.toolbar;
        setSupportActionBar(toolbar);

        //Get the drawer layout instance
        DrawerLayout drawerLayout = getViewbinding().drawerLayout;
        //
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        //
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //set as a life cycle observer...
        getViewbinding().setLifecycleOwner(this);*/


        /*landingPageViewModel.setApiKey("London, UK", Constant.API_KEY);

        landingPageViewModel.getResponse().observe(this, response -> {

        });*/

    }

    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = getViewbinding().drawerLayout;
       /* if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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
            //start.startFragment(Constant.SETTINGS_PAGE_FRAGMENT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemClickListener(MenuItem menuItem, WeatherPageViewModel landingPageViewModel) {
        // Handle navigation view item clicks here.
        int id = menuItem.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        //getViewbinding().drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
