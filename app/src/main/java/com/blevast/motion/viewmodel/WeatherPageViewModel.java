package com.blevast.motion.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import com.blevast.motion.data.CustomLiveData;
import com.blevast.motion.data.response.city.WeatherCityResponse;
import com.blevast.motion.data.service.ApiResponse;
import com.blevast.motion.data.service.ApiService;

/**
 * A life-cycle aware view model
 * A view model class is designed and manage a data in
 * a life-cycle aware ways and means. Such as screen
 * orientations.
 *
 * We can use {@link android.arch.lifecycle.LiveData} here.
 */

public class WeatherPageViewModel extends ViewModel {

    //These are the keys that are set from the UI
    private MutableLiveData<String> apiKey = new MutableLiveData<>();
    private MutableLiveData<String> cityName = new MutableLiveData<>();

    //
    private ObservableField<WeatherCityResponse> weatherResponse = new ObservableField<>();

    //A custom live data that can carry both
    //api key and city name
    private CustomLiveData customLiveData = new CustomLiveData(apiKey, cityName);

    //This is the observed live data
    LiveData<ApiResponse<WeatherCityResponse>> response;

    /**
     * @param apiService
     */
    public WeatherPageViewModel(ApiService apiService) {
       response = Transformations.switchMap(customLiveData, value -> apiService.getWeatherByCity(value.first, value.second));
       response.getValue();
    }

    public LiveData<ApiResponse<WeatherCityResponse>> getResponse() {
        return response;
    }

    //Post the value of the string
    public void setApiKey(String apiKey, String cityName) {
        this.apiKey.postValue(apiKey);
        this.cityName.postValue(cityName);
    }
}
