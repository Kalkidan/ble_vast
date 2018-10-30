package com.blevast.motion.data.service;

import android.arch.lifecycle.LiveData;

import com.blevast.motion.data.response.city.WeatherCityResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    /*@GET("/data/2.5/weather")
    Observable<WeatherCityResponse> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);*/

    @GET("/data/2.5/weather")
    LiveData<ApiResponse<WeatherCityResponse>> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);


}
