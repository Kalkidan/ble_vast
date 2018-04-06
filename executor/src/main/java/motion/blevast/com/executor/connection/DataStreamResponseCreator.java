package motion.blevast.com.executor.connection;

import java.io.IOException;
import java.io.InputStream;

import motion.blevast.com.executor.UseCase;

/**
 * Often, our response needs an {@link java.io.InputStream} to function
 * properly, and we need
 */

public class DataStreamResponseCreator extends NetworkContractImpl{

    /**
     * @param responseCode
     * @param data
     */
    @Override ResponseValues createResponse(int responseCode, InputStream data) throws IOException {
        return new ResponseValues(responseCode, data);
    }


    public static class ResponseValues extends NetworkContractImpl.ResponseValues<InputStream> {
        /**
         * @param responseCode The generic response from a network call.
         * @param inputStream
         */
        public ResponseValues(int responseCode, InputStream inputStream) throws IOException {
            super(responseCode, inputStream);
        }

        @Override InputStream parseRawResponse(InputStream inputStream) throws IOException {
            return inputStream;
        }
    }
}
