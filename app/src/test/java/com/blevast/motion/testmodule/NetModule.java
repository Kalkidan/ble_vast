package com.blevast.motion.testmodule;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * This will serve us as a network module
 */
@Module
public class NetModule {

    String url;

    //
    //a string url is the dependency here.
    //
    public NetModule(String url){
        this.url = url;
    }

    //
    //A singleton instance that is provided for the entire app
    //@Singleton signals to dagger that the instance is created once.
    //
    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Cache provideOkhttpCache(Application context){
        //define the cache sizing
        int cacheSize = 10 * 1024 * 1024; // 10 MiB
        return new Cache(context.getCacheDir(), cacheSize);
    }

    //A dependency that will provide Gson
    @Provides
    @Singleton
    Gson proivideGson(){
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
    }

    //OkHttpClient instance
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache){
        return new OkHttpClient.Builder().cache(cache).build();
    }

    //
    //This will provide a Retrofit instance
    //
    //
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient){
        return new Retrofit.Builder().
                addConverterFactory(GsonConverterFactory.create(gson)).
                baseUrl(this.url).client(okHttpClient).build();
    }
}
