package com.blevast.motion.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.text.TextUtils;

import com.blevast.motion.data.response.city.WeatherCityResponse;
import com.blevast.motion.data.service.ApiResponse;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.model.ApiCredentialData;
import com.blevast.motion.model.BaseData;
import com.blevast.motion.ui.CustomLiveData;
import com.google.android.gms.common.api.Api;

/**
 * A life-cycle aware view model
 * A view model class is designed and manage a data in
 * a life-cycle aware ways and means. Such as screen
 * orientations.
 *
 * We can use {@link android.arch.lifecycle.LiveData} here.
 */

public class WeatherPageViewModel extends ViewModel {

    //
    private MutableLiveData<ApiCredentialData> weatherCreds = new MutableLiveData<>();

    //
    private ObservableField<WeatherCityResponse> weatherResponse = new ObservableField<>();

    //
    private CustomLiveData<ApiCredentialData> cusomLiveData = new CustomLiveData(weatherCreds);

    //This is the observed live data
    LiveData<ApiResponse<WeatherCityResponse>> response;

    /**
     * @param apiService
     */
    public WeatherPageViewModel(ApiService apiService) {
       response = Transformations.switchMap(
               cusomLiveData, input -> apiService.getWeatherByCity(input.getCityName(), input.getApiKey()));
    }

    //CustomLiveData live data
    public LiveData<ApiResponse<WeatherCityResponse>> getResponse() {
        return response;
    }

    /**
     * Post the value of the string that are being observed
     */
    public void setApiKey(String apiKey, String cityName) {
        this.weatherCreds.setValue(new ApiCredentialData(apiKey, cityName));
    }

    public ObservableField<WeatherCityResponse> getWeatherResponse() {
        return weatherResponse;
    }

    public void setWeatherResponse(ObservableField<WeatherCityResponse> weatherResponse) {
        this.weatherResponse = weatherResponse;
    }
}
