package com.blevast.motion.dagger.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.blevast.motion.viewmodel.LandingPageViewModel;

import javax.inject.Provider;

class ViewModelFactory implements ViewModelProvider.Factory{

    private Provider<LandingPageViewModel> provider;

    public ViewModelFactory(Provider<LandingPageViewModel> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) provider.get();
    }
}
