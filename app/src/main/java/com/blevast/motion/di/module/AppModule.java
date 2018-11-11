package com.blevast.motion.di.module;

import android.content.Context;
import com.blevast.motion.App;
import dagger.Binds;
import dagger.Module;

@Module(includes = ViewModelModule.class)
public abstract class AppModule {

    @Binds
    abstract Context provideContext(App app);

}