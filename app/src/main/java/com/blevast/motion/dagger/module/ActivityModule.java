package com.blevast.motion.dagger.module;

import androidx.lifecycle.ViewModelProvider;

import com.blevast.motion.dagger.scope.PerHighlightActivity;
import com.blevast.motion.dagger.scope.PerLandingActivity;
import com.blevast.motion.viewmodel.HighlightsPageViewModel;
import com.blevast.motion.viewmodel.LandingPageViewModel;

import javax.inject.Provider;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @PerHighlightActivity
    @Provides
    public HighlightsPageViewModel provideViewModel(){
        return new HighlightsPageViewModel();
    }

    @PerHighlightActivity
    @Provides
    public ViewModelProvider.Factory viewModelProvider(Provider<HighlightsPageViewModel> provider){
        return new ViewModelFactory<>(provider);
    }

    @PerLandingActivity
    @Provides
    public LandingPageViewModel landingPageViewModel(){
        return new LandingPageViewModel();
    }


    @PerLandingActivity
    @Provides
    public ViewModelProvider.Factory landingPageViewFactory(Provider<LandingPageViewModel> provider){
        return new ViewModelFactory<>(provider);
    }

}
