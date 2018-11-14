package com.blevast.motion.viewmodel;

import com.blevast.motion.BR;

import java.util.Observable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.lifecycle.ViewModel;
import dagger.Binds;

public class SubscriptionViewModel extends BaseObservable {


    private String fullName;

    public SubscriptionViewModel(String full_name) {
        this.fullName = full_name;
        notifyPropertyChanged(BR.fullName);
    }

    @Bindable public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
