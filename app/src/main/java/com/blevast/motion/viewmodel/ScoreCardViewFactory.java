package com.blevast.motion.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ScoreCardViewFactory implements ViewModelProvider.Factory {

    private String name;

    /**
     * @param name
     */
    public ScoreCardViewFactory(String name){
        this.name =  name;
    }

    /**
     * @param modelClass
     */
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(ScoreCarView.class))
            return (T) new ScoreCarView(this.name);

        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
