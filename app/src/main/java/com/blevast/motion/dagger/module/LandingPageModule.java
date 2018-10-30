package com.blevast.motion.dagger.module;


import android.arch.lifecycle.ViewModelProvider;

import com.blevast.motion.dagger.scope.PerActivity;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.viewmodel.LandingPageViewModel;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class LandingPageModule {

    @PerActivity
    @Provides
    public LandingPageViewModel provideLandingPageViewModel(ApiService apiService){
        return new LandingPageViewModel(apiService);
    }

    @PerActivity
    @Provides
    public ViewModelProvider.Factory viewModelProvider(Provider<LandingPageViewModel> provider){
        return new ViewModelFactory(provider);
    }



}
