package com.blevast.motion.di.component;

import com.blevast.motion.App;
import com.blevast.motion.di.module.ActivityBindingModule;
import com.blevast.motion.di.module.ApiModule;
import com.blevast.motion.di.module.AppModule;
import com.blevast.motion.di.module.DataModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {  AppModule.class, ApiModule.class, DataModule.class, AndroidSupportInjectionModule.class, ActivityBindingModule.class} )
public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);

    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(App app);
        AppComponent build();
    }
}

