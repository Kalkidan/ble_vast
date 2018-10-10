package com.blevast.motion.dagger.component;

import android.app.Application;

import com.blevast.motion.dagger.module.ActivityBuilder;
import com.blevast.motion.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = { AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
