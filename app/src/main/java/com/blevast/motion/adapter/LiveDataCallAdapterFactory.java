package com.blevast.motion.adapter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * This is a custom {@link android.arch.lifecycle.LiveData} adapter
 * factory--rather than using the rxjava one so we can make things easier
 * on the observability side
 */
public class LiveDataCallAdapterFactory extends CallAdapter.Factory {

    /**
     * @param annotations
     * @param retrofit
     * @param returnType
     */
    @Nullable
    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        return null;
    }
}
