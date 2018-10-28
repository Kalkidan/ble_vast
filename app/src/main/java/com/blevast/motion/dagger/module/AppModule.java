package com.blevast.motion.dagger.module;

import android.content.Context;
import com.blevast.motion.App;
import dagger.Binds;
import dagger.Module;

//Introduce subcomponents
@Module
public abstract class AppModule { //TODO:: define what goes in here globally

    //Since Dagger can instantiate no-args modules

    @Binds abstract Context provideContext(App app);
}