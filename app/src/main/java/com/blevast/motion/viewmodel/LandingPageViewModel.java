package com.blevast.motion.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.provider.SyncStateContract;

import com.blevast.motion.Constant;
import com.blevast.motion.data.response.city.WeatherCityResponse;
import com.blevast.motion.data.service.ApiResponse;
import com.blevast.motion.data.service.ApiService;

import motion.blevast.com.executor.util.Constants;

/**
 * A life-cycle aware view model
 * A view model class is designed and manage a data in
 * a life-cycle aware ways and means. Such as screen
 * orientations.
 *
 * We can use {@link android.arch.lifecycle.LiveData} here.
 */

public class LandingPageViewModel extends ViewModel {

    private ApiService apiService;

    public LandingPageViewModel(ApiService apiService) {
       this.apiService = apiService;
       //Call the back end

    }


    public ApiService getApiService() {
        return apiService;
    }
}
