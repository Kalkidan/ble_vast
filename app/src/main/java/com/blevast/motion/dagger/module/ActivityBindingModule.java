package com.blevast.motion.dagger.module;

import com.blevast.motion.LandingActivity;
import com.blevast.motion.dagger.scope.PerActivity;
import com.blevast.motion.dagger.scope.PerFragment;
import com.blevast.motion.ui.fragment.WeatherFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @PerFragment
    @ContributesAndroidInjector(modules = WeatherPageModule.class)
    abstract WeatherFragment landingPageInjector();

}
