package com.blevast.motion.dagger.module;


import androidx.lifecycle.ViewModelProvider;

import com.blevast.motion.dagger.scope.PerFragment;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.viewmodel.WeatherPageViewModel;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @PerFragment
    @Provides
    public WeatherPageViewModel provideLandingPageViewModel(ApiService apiService){
        return new WeatherPageViewModel(apiService);
    }

    @PerFragment
    @Provides
    public ViewModelProvider.Factory viewModelProvider(Provider<WeatherPageViewModel> provider){
        return new ViewModelFactory<>(provider);
    }


}
