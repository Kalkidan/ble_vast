package com.blevast.motion.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

public class CustomLiveData<T> extends MediatorLiveData<T> {
    /**
     * @param apiCredentials this is a custom {@link LiveData<T>}
     *                       that will add a source and observe it when
     *                       it changes
     *
     */
    public CustomLiveData(LiveData<T> apiCredentials){
        addSource(apiCredentials, input -> setValue(input));
    }
}
