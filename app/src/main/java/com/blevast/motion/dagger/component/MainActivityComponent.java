package com.blevast.motion.dagger.component;

import com.blevast.motion.MainActivity;
import com.blevast.motion.dagger.module.MainActivityModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = MainActivityModule.class)
public abstract interface MainActivityComponent {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}

}
