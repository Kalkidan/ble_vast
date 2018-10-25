package com.blevast.motion.dagger.module;

import com.squareup.moshi.Moshi;

import javax.inject.Singleton;

import dagger.Module;
import okhttp3.HttpUrl;


/**
 *  Ordered injection
 */
@Module
public class ApiModule {

    //disk cache
    public static final long DISK_CACHE_SIZE = 10 * 1024 * 1024;
    //base url
    public static final HttpUrl PRODUCTION_API_URL = HttpUrl.parse("https://api.github.com/");

    //Weather end point base url
    public static final HttpUrl WEATHER_END_POINT = HttpUrl.parse("https://samples.openweathermap.org");

}
