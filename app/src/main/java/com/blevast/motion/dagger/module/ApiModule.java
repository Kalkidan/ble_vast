package com.blevast.motion.dagger.module;

import com.blevast.motion.App;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.data.service.LiveDataCallAdapterFactory;
import com.google.gson.GsonBuilder;
import com.squareup.moshi.Moshi;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

//
//
//Injections concerning api and network calls
//Url
//cache
//Retrofit api service
//OKHttp client
//HttpLogging Interceptor
//Retrofit
//
//
@Module
public class ApiModule {

    //disk cache
    public static final long DISK_CACHE_SIZE = 10 * 1024 * 1024;

    //Weather end point base url
    public static final HttpUrl WEATHER_END_POINT = HttpUrl.parse("https://samples.openweathermap.org");

    //End point
    @Provides @Singleton
    public HttpUrl provideUrl(){ return WEATHER_END_POINT; }

    //Cache
    @Provides @Singleton
    Cache provideHttpCache(App recipeApp) {
        Cache cache = new Cache(recipeApp.getCacheDir(), DISK_CACHE_SIZE);
        return cache;
    }

    //
    @Provides
    @Singleton
    ApiService provideService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }

    //
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor
                                             httpLoggingInterceptor,
                                     Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache);
        return builder.build();
    }

    //
    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    //provide global retrofit instance
    @Provides
    @Singleton
    Retrofit provideRetrofit(HttpUrl baseUrl, OkHttpClient client) {
        return new Retrofit.Builder() //
                .client(client)//
                .addConverterFactory(GsonConverterFactory.create())//
                .baseUrl(baseUrl) //
                .addCallAdapterFactory(new LiveDataCallAdapterFactory()) //
                .build();//
    }

}
