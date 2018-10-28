package com.blevast.motion.dagger.module;

import com.blevast.motion.LandingActivity;
import com.blevast.motion.dagger.scope.PerActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @PerActivity
    @ContributesAndroidInjector(modules = LandingPageModule.class)
    abstract LandingActivity landingPageInjector();

}
