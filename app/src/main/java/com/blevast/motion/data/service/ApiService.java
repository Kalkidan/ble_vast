package com.blevast.motion.data.service;

import androidx.lifecycle.LiveData;

import com.blevast.motion.data.response.git.Subscriptions;
import com.blevast.motion.data.response.git.User;
import com.blevast.motion.data.response.city.WeatherCityResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    /*@GET("/data/2.5/weather")
    Observable<WeatherCityResponse> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);*/

    @GET("/data/2.5/weather")
    LiveData<ApiResponse<WeatherCityResponse>> getWeatherByCity(@Query("q") String city, @Query("appid") String apiKey);

    @GET("/users/{user}")
    LiveData<ApiResponse<User>>  getGithubUser(@Path("user") String user);

    @GET("/users/{user}/{subscriptions}")
    LiveData<ApiResponse<List<Subscriptions>>>  getSubscriptions(@Path("user") String user, @Path("subscriptions") String subscriptions);


}
