package com.blevast.motion.dagger.module;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.blevast.motion.viewmodel.WeatherPageViewModel;

import javax.inject.Provider;

/**
 * A reusable {@link ViewModelFactory#provider} factory class that is capable of
 * injecting dagger instances of the different view models
 *
 */
class ViewModelFactory<T extends ViewModel> implements ViewModelProvider.Factory{

    private Provider<T> provider;

    public ViewModelFactory(Provider<T> provider) {
        this.provider = provider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) provider.get();
    }
}
