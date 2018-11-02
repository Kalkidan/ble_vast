package com.blevast.motion.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Pair;

public class CustomLiveData<T extends MutableLiveData, P extends MutableLiveData> extends MediatorLiveData<Pair<T, P>> {


    public CustomLiveData(LiveData<T> apiKey, LiveData<P> cityName){
        addSource(apiKey, o -> Pair.create(apiKey.getValue(), cityName.getValue()));
    }
}
