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

    /**
     * When dealing with the instance of the module, the STATIC keyword
     * will no longer need the instance state of the module to access the
     * methods.
     * This is an example of new instances every time it is required.
     */
    @Provides
    static HighlightsPageViewModel provideViewModel(){
        return new HighlightsPageViewModel();
    }

    @PerHighlightActivity
    @Provides
    static ViewModelProvider.Factory viewModelProvider(Provider<HighlightsPageViewModel> provider){
        return new ViewModelFactory<>(provider);
    }

    @PerLandingActivity
    @Provides
    static LandingPageViewModel landingPageViewModel(){
        return new LandingPageViewModel();
    }


    @PerLandingActivity
    @Provides
    static ViewModelProvider.Factory landingPageViewFactory(Provider<LandingPageViewModel> provider){
        return new ViewModelFactory<>(provider);
    }

}
