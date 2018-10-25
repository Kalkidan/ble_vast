package com.blevast.motion.dagger.module;


import android.content.SharedPreferences;


import com.blevast.motion.App;

import dagger.Module;
import dagger.Provides;


import static android.content.Context.MODE_PRIVATE;

/**
 * Data layer instances, we need this at the application level
 *
 */
@Module
public class DataModule {


    //Provides shared preferences
    @Provides
    static SharedPreferences provideSharedPreferences(App airSideApp) {
        return airSideApp.getSharedPreferences("u2020", MODE_PRIVATE);
    }

}