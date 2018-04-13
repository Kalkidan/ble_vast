package motion.blevast.parser.controller;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.com.executor.connection.NetworkContractImpl;
import motion.blevast.com.executor.connection.RequestType;
import motion.blevast.com.executor.connection.StringResponseCreator;
import motion.blevast.parser.VastResultListener;
import motion.blevast.parser.task.ProcessVast;
import motion.blevast.parser.vastad.model.VastData;

/**
 * Vast process contract implementation.
 */

class VastProcessorImpl implements VastProcessor{


    private static final String TAG =  VastProcessorImpl.class.getSimpleName();
    private static final int   WRAPPER_HIT_COUNT_MAX = 5;

    //TODO:: This can be put in to a model, let it be like this for now
    List<VastData> vastDataList = new ArrayList<>();
    int wrapperHitCount;

    /**
     * @param destinationUrl
     * @param connectionParameter
     * @param context
     * @param vastResultListener
     */
    @Override
    public boolean getVast(String destinationUrl,
                           ConnectionParameter connectionParameter,
                           final Context context,
                           final VastResultListener vastResultListener) {

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
                    processVast(response.getResponse(), context, vastResultListener);

                } else {

                    //
                }
            }

            @Override
            public void onError(NetworkContractImpl.Error error) {

            }
        });
        return true;
    }
    //

    /**
     * @param vastResponse  process the VAST
     * @param context
     * @param vastResultListener
     */
    @Override
    public void processVast(final String vastResponse,
                            Context context,
                            final VastResultListener vastResultListener) {
        //Execute the use case
        UsecaseHandler.getInstance().execute(new ProcessVast(),
                new ProcessVast.RequestValues(vastResponse, context),
                new UsecaseCallback<ProcessVast.ResponseValues, ProcessVast.Error>() {
            @Override
            public void onSuccess(ProcessVast.ResponseValues response) {

                //Vast data
                VastData vastData = response.getVastData();
                vastData.setReport(response.getReport());
                vastDataList.add(vastData);

                //Check if it is a wrapper and re-iterate
                if(vastData.isWrapper() && wrapperHitCount < WRAPPER_HIT_COUNT_MAX){

                    //If we just in case need the wrapper count
                    vastData.setWrapperHitCount(++wrapperHitCount);
                    getVast(vastData.getVASTAdTagUri(),
                            new ConnectionParameter(RequestType.GET),
                            response.getContext().get(),
                            vastResultListener);
                } else {

                    //spit out the processed vast
                    vastResultListener.onVastDataProcessed(vastDataList);
                }
            }

            @Override
            public void onError(ProcessVast.Error error) {}
        });
    }
    //

}
