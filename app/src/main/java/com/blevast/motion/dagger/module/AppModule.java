package com.blevast.motion.dagger.module;

import android.app.Application;
import android.content.Context;

import com.blevast.motion.dagger.component.MainActivityComponent;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

//Introduce subcomponents
@Module( subcomponents = { MainActivityComponent.class })
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

}