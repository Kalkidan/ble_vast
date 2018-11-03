package com.blevast.motion.dagger.module;

import android.arch.lifecycle.ViewModelProvider;

import com.blevast.motion.dagger.scope.PerHighlightActivity;
import com.blevast.motion.viewmodel.HighlightsPageViewModel;

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
}
