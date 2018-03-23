package motion.blevast.vastparser.controller;

import android.text.TextUtils;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.com.executor.connection.NetworkContractImpl;
import motion.blevast.com.executor.connection.StringResponse;
import motion.blevast.com.executor.connection.StringResponseCreator;

/**
 * Vast process contract implementation.
 */

public class VastProcessorImpl implements VastProcessor{

    @Override
    public boolean getVast(String destinationUrl, ConnectionParameter connectionParameter) {

        //Execute the networking UseCase
        UsecaseHandler.getInstance().execute(new StringResponseCreator(),
                new NetworkContractImpl.RequestValues(destinationUrl, null, connectionParameter),
                new UsecaseCallback<StringResponse, NetworkContractImpl.Error>() {
            //
            @Override
            public void onSuccess(StringResponse response) {
                //
                if(response.getResponse() != null){

                }


            }

            //
            @Override
            public void onError(NetworkContractImpl.Error error) {

            }
        });
        return true;
    }
    //

}
