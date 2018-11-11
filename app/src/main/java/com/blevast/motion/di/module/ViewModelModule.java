package com.blevast.motion.di.module;


import com.blevast.motion.di.TrialViewModel;
import com.blevast.motion.viewmodel.LandingPageViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public  abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(TrialViewModel.class)
    abstract ViewModel landing(TrialViewModel model);

    @Binds
    @IntoMap
    @ViewModelKey(LandingPageViewModel.class)
    abstract ViewModel landingPage(LandingPageViewModel model);


    @Binds
    abstract ViewModelProvider.Factory factory(ViewModelFactoryImpl viewModelFactory);



}
