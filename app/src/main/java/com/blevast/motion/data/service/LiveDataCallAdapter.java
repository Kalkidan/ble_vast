package com.blevast.motion.data.service;

import android.arch.lifecycle.LiveData;
//
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
//
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<ApiResponse<R>>> {

    //response type
    private final Type responseType;

    //live data call adapter
    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    //Response type
    @Override
    public Type responseType() {
        return this.responseType;
    }

    /**
     * @param call
     */
    @Override
    public LiveData<ApiResponse<R>> adapt(Call<R> call) {
        return new LiveData<ApiResponse<R>>() {

            AtomicBoolean inProgress = new AtomicBoolean(false);
            //This is when the observer is added to the
            //observing mechanism
            @Override
            protected void onActive() {
                super.onActive();
                //Thread safe atomic boolean.
                if(inProgress.compareAndSet(false, true)){
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(Call<R> call, Response<R> response) {
                            postValue(new ApiResponse(response));
                        }

                        @Override
                        public void onFailure(Call<R> call, Throwable throwable) {
                            postValue(new ApiResponse(throwable));
                        }
                    });
                }

            }
        };
    }


}
