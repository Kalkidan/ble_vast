package com.blevast.motion.viewmodel;


import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

public class LandingPageViewModel extends ViewModel {

    private ObservableField<String> url = new ObservableField<>();

    private ObservableField<String> landingButtonText = new ObservableField<>();

    @Inject LandingPageViewModel(){ }

    public void getUserInfo() { }

    public void setUrl(String url) {
        this.url.set(url);
    }

    public ObservableField<String> getUrl() {
        return url;
    }

    public void setLandingButtonText(String landingButton) {
        this.landingButtonText.set(landingButton);
    }

    public ObservableField<String> getLandingButtonText() {
        return landingButtonText;
    }
}
