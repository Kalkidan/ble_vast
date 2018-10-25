package com.blevast.motion.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

/**
 * A life-cycle aware view model
 * A view model class is designed and manage a data in
 * a life-cycle aware ways and means. Such as screen
 * orientations.
 *
 * We can use {@link android.arch.lifecycle.LiveData} here.
 */

public class LandingPageViewModel extends AndroidViewModel {

    private ObservableField<String> name = new ObservableField<>();

    public LandingPageViewModel(@NonNull Application application) {
        super(application);
    }

    public ObservableField<String> getName() {
        return name;
    }

    public void setName(ObservableField<String> name) {
        this.name = name;
    }
}
