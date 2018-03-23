package motion.blevast.vastparser.request;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.connection.NetworkContractImpl;
import motion.blevast.com.executor.connection.StringResponseCreator;

/**
 * An implementation of a {@link VastRequest}
 */

public class VastRequestImpl implements VastRequest{

    //Call out to get VAST response
    @Override
    public void getVast() {

        UsecaseHandler.getInstance().execute(new StringResponseCreator(),
                new StringResponseCreator.RequestValues("", "", null),
                new UsecaseCallback<NetworkContractImpl.ResponseValues, NetworkContractImpl.Error>() {
            @Override
            public void onSuccess(NetworkContractImpl.ResponseValues response) {

            }

            @Override
            public void onError(NetworkContractImpl.Error error) {

            }
        });

    }
}
