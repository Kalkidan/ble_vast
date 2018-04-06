package motion.blevast.parser.controller;

import android.content.Context;
import android.util.Log;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.com.executor.connection.NetworkContractImpl;
import motion.blevast.com.executor.connection.StringResponseCreator;
import motion.blevast.parser.task.XSDValidateVast;
import motion.blevast.parser.task.ManualValidateTast;

/**
 * Vast process contract implementation.
 */

public class VastProcessorImpl implements VastProcessor{


    private static final String TAG =  VastProcessorImpl.class.getSimpleName();

    @Override
    public boolean getVast(String destinationUrl, ConnectionParameter connectionParameter, final Context context) {

        Log.d(TAG, "Make a network call to get the String Url");
        //Execute the networking UseCase
        UsecaseHandler.getInstance().execute(new StringResponseCreator(),
                new NetworkContractImpl.RequestValues(destinationUrl, null, connectionParameter),
                new UsecaseCallback<StringResponseCreator.ResponseValues, NetworkContractImpl.Error>() {
            /**
             * @param response
             * onSuccess
             */
            @Override
            public void onSuccess(StringResponseCreator.ResponseValues response) {

                //Just to guard
                if(response != null){

                    Log.d(TAG, "Start processing it.");
                    //This is the UI thread
                    //This is where we can launch another thread to take care of the processing
                    processVast(response.getResponse(), context);

                } else {

                    //
                }
            }

            /**
             * @param error
             * onError
             */
            @Override
            public void onError(NetworkContractImpl.Error error) {

            }
        });
        return true;
    }

    /**
     * @param vastResponse  process the VAST
     * @param context
     */
    @Override
    public void processVast(String vastResponse, Context context) {
        UsecaseHandler.getInstance().execute(new ManualValidateTast(),
                new XSDValidateVast.RequestValues(vastResponse, context),
                new UsecaseCallback<XSDValidateVast.ResponseValues, XSDValidateVast.Error>() {
            @Override
            public void onSuccess(XSDValidateVast.ResponseValues response) {

            }

            @Override
            public void onError(XSDValidateVast.Error error) {

            }
        });
    }
    //

}
