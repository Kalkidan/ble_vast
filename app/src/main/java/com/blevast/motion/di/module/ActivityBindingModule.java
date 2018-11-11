package com.blevast.motion.di.module;

import com.blevast.motion.ui.activity.landing.LandingActivity;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module

public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract LandingActivity mainActivity();


}
