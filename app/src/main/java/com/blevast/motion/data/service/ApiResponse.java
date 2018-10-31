package com.blevast.motion.data.service;

import android.text.TextUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * This will hold link header style too
 * It will help us in implementing a pagination
 * if needed or else will resume the usual way.
 */
public class ApiResponse<T> {

    private int code;
    private T body;
    private String errorMessage;
    private ResponseBody responseBody;

    public ApiResponse(){

    }

    //The retrofit adapter throws this
    public ApiResponse(Throwable throwable){

    }

    //Construct it with retrofit Response<T>
    //This is expandable class that will handle what we can
    //do to the api call responsee body.
    public ApiResponse(Response<T> response){
        //The server code
        code = response.code();
        if(response.isSuccessful()){
            body = response.body();
            //if any
            errorMessage = response.message();
        } else {

            //
            ResponseBody responseBody = response.errorBody();
            String message = null;
            if(responseBody != null){
                this.responseBody = responseBody;
                try {

                    message = responseBody.string();

                } catch(IOException e){

                }
            }
            //If text message is empty try checking
            //the responde body for any message
            if(TextUtils.isEmpty(message) || message.trim().length() == 0){
                message = response.message();
            }

            this.errorMessage = message;

        }
    }

    public int getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getBody() {
        return body;
    }
}
