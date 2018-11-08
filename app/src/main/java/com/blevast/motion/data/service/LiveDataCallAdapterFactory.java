package com.blevast.motion.data.service;

import androidx.lifecycle.LiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * This is a custom {@link androidx.lifecycle.LiveData} adapter
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

        //We need to make sure that
        //Get the type of the class that takes another class
        //as the parameter
        if(getRawType(returnType) != LiveData.class){
            return null;
        }
        //These are like stepped questions
        //1-Is it parameterized
        //2-and is it a type of ApiRespose.clss
        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Class<?> type = getRawType(observableType);

        //Make sure it is a response type resource
        if(type != ApiResponse.class || !( observableType instanceof ParameterizedType)){
            //Log the error here
            //This will crash when we test
            throw new IllegalArgumentException("type must be a resource OR resource must be parameterized");
        }

        return new LiveDataCallAdapter<>(getParameterUpperBound(0, (ParameterizedType) observableType));
    }
}
