package com.blevast.motion.dagger.module;

import dagger.Module;
import dagger.Provides;
import motion.blevast.com.executor.UsecaseHandler;

/**
 * provides instances for injection in {@link com.blevast.motion.MainActivity}
 */
@Module
public abstract class MainActivityModule {

    @Provides UsecaseHandler provideUsecaseHandler(){
        return UsecaseHandler.getInstance();
    }
}
