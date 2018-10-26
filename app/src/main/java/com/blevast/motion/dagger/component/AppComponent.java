package com.blevast.motion.dagger.component;

import com.blevast.motion.App;
import com.blevast.motion.dagger.module.ActivityBindingModule;
import com.blevast.motion.dagger.module.ApiModule;
import com.blevast.motion.dagger.module.AppModule;
import com.blevast.motion.dagger.module.DataModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

//
@Singleton
@Component(modules = {

        //android dagger
        AndroidInjectionModule.class,
        //
        //android dagger-->support
        AndroidSupportInjectionModule.class,
        //
        //project modules
        AppModule.class,
        ApiModule.class,
        DataModule.class,
        ActivityBindingModule.class })
//
public interface AppComponent extends AndroidInjector<App> {

    @Override
    void inject(App instance);

    @Component.Builder
    interface Builder {

        //This is like passing an instance in the module
        //This replaces the old way of doing it...
        @BindsInstance
        AppComponent.Builder application(App application);

        AppComponent build();
    }
}
