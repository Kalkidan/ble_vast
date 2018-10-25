package com.blevast.motion.dagger.module;
import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

//Introduce subcomponents
@Module
public abstract class AppModule { //TODO:: define what goes in here globally

    //Since Dagger can instantiate no-args modules

    @Provides
    static Context  provideContext(Application application){
        return application.getApplicationContext();
    }
}