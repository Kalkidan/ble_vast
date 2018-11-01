package com.blevast.motion.dagger.module;

import android.arch.lifecycle.ViewModelProvider;

import com.blevast.motion.dagger.scope.PerActivity;
import com.blevast.motion.viewmodel.LandingActivityViewModel;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @PerActivity
    @Provides
    public LandingActivityViewModel provideViewModel(){
        return new LandingActivityViewModel();
    }

    @PerActivity
    @Provides
    public ViewModelProvider.Factory viewModelProvider(Provider<LandingActivityViewModel> provider){
        return new ViewModelFactory<>(provider);
    }
}
