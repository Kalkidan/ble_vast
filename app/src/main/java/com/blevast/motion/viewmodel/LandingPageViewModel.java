package com.blevast.motion.viewmodel;


import com.blevast.motion.data.response.git.User;
import com.blevast.motion.data.service.ApiResponse;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.ui.CustomLiveData;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.databinding.ObservableField;

public class LandingPageViewModel extends ViewModel {

    private ObservableField<String> landingButtonText = new ObservableField<>();

    CustomLiveData<String> customLiveData = new CustomLiveData<>();

    LiveData<ApiResponse<User>> userData;

    @Inject LandingPageViewModel(ApiService apiService){
      userData = Transformations.switchMap(customLiveData, result -> apiService.getGithubUser(result));
    }

    public void setLandingButtonText(String landingButton) {
        this.landingButtonText.set(landingButton);
    }

    public ObservableField<String> getLandingButtonText() {
        return landingButtonText;
    }

    public void setUser(String userName){
        customLiveData.setValue(userName);
    }
}
