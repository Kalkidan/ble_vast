package com.blevast.motion.di.module;

import com.blevast.motion.ui.activity.landing.HomePageActivity;
import com.blevast.motion.ui.activity.landing.LandingActivity;
import com.blevast.motion.ui.fragment.PersonalDetailPage;
import com.blevast.motion.ui.fragment.ReposFragment;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module

public abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract LandingActivity mainActivity();

    @ContributesAndroidInjector
    abstract HomePageActivity homePageActivity();

    @ContributesAndroidInjector
    abstract PersonalDetailPage personalDetailPage();

    @ContributesAndroidInjector
    abstract ReposFragment reposFragment();


}
