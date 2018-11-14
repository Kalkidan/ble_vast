package com.blevast.motion.viewmodel;

import com.blevast.motion.data.response.git.Subscriptions;
import com.blevast.motion.data.response.git.User;
import com.blevast.motion.data.service.ApiResponse;
import com.blevast.motion.data.service.ApiService;
import com.blevast.motion.model.SubscriptionCredentials;
import com.blevast.motion.ui.CustomLiveData;

import java.util.List;

import javax.inject.Inject;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class HomePageViewModel extends ViewModel {
    //
    //
    // Start
    private ObservableField<String> avatarUrl = new ObservableField<>();
    //
    private CustomLiveData<String> customLiveData = new CustomLiveData<>();

    private CustomLiveData<SubscriptionCredentials> subscrCreds = new CustomLiveData<>();
    //
    private ObservableField<User> userObservableData = new ObservableField<>();
    //
    private LiveData<ApiResponse<User>> userDataResponse;
    //
    private LiveData<ApiResponse<List<Subscriptions>>> subscriptions;
    // End
    //
    //

    @Inject HomePageViewModel(ApiService apiService){
        /***
         * These are subscriptions that we need for this page and beyond
         *
         *
         **/
        userDataResponse = Transformations.switchMap(customLiveData, user -> apiService.getGithubUser(user));
        subscriptions = Transformations.switchMap(subscrCreds, result -> apiService.getSubscriptions(result.getUserName(),
                result.getSubscriptionName()) );
    }

    public void setAvatarUrl(String url){
      avatarUrl.set(url);
    }

    public void setGithubUser(String githubUser){
        customLiveData.setValue(githubUser);
    }

    public LiveData<ApiResponse<User>> getUserDataResponse() {
        return userDataResponse;
    }

    public ObservableField<String> getAvatarUrl() {
        return avatarUrl;
    }

    public ObservableField<User> getUserObservableData() {
        return userObservableData;
    }

    public void setUserObservableData(User user) {
        this.userObservableData.set(user);
    }

    public LiveData<ApiResponse<List<Subscriptions>>> getSubscriptions() {
        return subscriptions;
    }

    public void loadSubscription(String user, String subs) {
        subscrCreds.setValue(new SubscriptionCredentials(user, subs));
    }
}
