package com.blevast.motion.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.util.Pair;

/**
 * A custom live data for specific purposes
 */
public class CustomLiveData extends MediatorLiveData<Pair<String, String>> {

    public CustomLiveData(LiveData<String> apiKey, LiveData<String> cityName){
        addSource(apiKey, key ->
            setValue(Pair.create(key, apiKey.getValue())));
        addSource(cityName, name ->
            setValue(Pair.create(name, cityName.getValue())));
    }

}
