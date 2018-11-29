package com.blevast.motion.testmodule;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is the old way of doing dagger injection
 * {@link Application} class is the dependency here for
 * injection.
 */
@Module
public class TrialModule {

    Application application;

    /**
     * @param app
     */
    public TrialModule(Application app){
        this.application = app;
    }

    @Provides
    @Singleton
    Application provideApplicaion(){
        return this.application;
    }
}
