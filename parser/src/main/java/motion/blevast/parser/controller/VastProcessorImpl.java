package motion.blevast.parser.controller;

import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.UsecaseHandler;
import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.com.executor.connection.DataStreamResponseCreator;
import motion.blevast.com.executor.connection.NetworkContractImpl;

/**
 * Vast process contract implementation.
 */

public class VastProcessorImpl implements VastProcessor{

    @Override
    public boolean getVast(String destinationUrl, ConnectionParameter connectionParameter) {

        //Execute the networking UseCase
        UsecaseHandler.getInstance().execute(new DataStreamResponseCreator(),
                new NetworkContractImpl.RequestValues(destinationUrl, null, connectionParameter),
                new UsecaseCallback<DataStreamResponseCreator.ResponseValues, NetworkContractImpl.Error>() {
            //
            @Override
            public void onSuccess(DataStreamResponseCreator.ResponseValues response) {

                if(response != null){}
                 //TODO:: use the data, here!!! this is the UI thread!
                //TODO:: Parse the response and start the player.
              /*  try {
                    //new XmlParser().parse(response.getResponse());
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
*/
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
