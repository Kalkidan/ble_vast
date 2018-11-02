package com.blevast.motion.ui;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

public class CustomLiveData<T> extends MediatorLiveData<T> {

    public CustomLiveData(LiveData<T> apiCredentials){
        addSource(apiCredentials, input -> setValue(input));
    }
}
