package com.blevast.motion;

import com.blevast.motion.di.component.AppComponent;
import com.blevast.motion.di.component.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {


    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(App.this);

        /**
         * This is a good practice in order to avoid boiler plate code
         * and still be able to deliver on what we need.
         */
        return appComponent;
    }

}
