package com.blevast.motion.dagger.module;

import com.blevast.motion.dagger.scope.PerHighlightActivity;
import com.blevast.motion.dagger.scope.PerFragment;
import com.blevast.motion.dagger.scope.PerLandingActivity;
import com.blevast.motion.ui.activity.landing.HighLightActivity;
import com.blevast.motion.ui.activity.landing.LandingActivity;
import com.blevast.motion.ui.fragment.AdFragment;
import com.blevast.motion.viewmodel.LandingPageViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {


    @PerFragment
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract AdFragment landingPageInjector();

    @PerHighlightActivity
    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract HighLightActivity highLightActivity();

    @PerLandingActivity
    @ContributesAndroidInjector(modules = ActivityModule.class)
    abstract LandingActivity landingActivity();

}
