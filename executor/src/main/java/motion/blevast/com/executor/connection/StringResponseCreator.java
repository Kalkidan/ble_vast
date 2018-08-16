package motion.blevast.com.executor.connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * A string response creator
 */

public class  StringResponseCreator extends NetworkContractImpl {

    /**
     * @param data
     * @param responseCode
     *
     * create response from the network call.
     */
    @Override
    public ResponseValues createResponse(int responseCode, InputStream data) throws IOException {
        return new ResponseValues(responseCode, data);
    }

    //This is a string response from the network call
    public static class ResponseValues extends NetworkContractImpl.ResponseValues<String>{

        /**
         * @param inputStream
         * @param serverCode
         *
         */
        public ResponseValues(int serverCode, InputStream inputStream) throws IOException {
            super(serverCode, inputStream);
        }

        @Override
        public String getResponse() {
            return super.getResponse();
        }

        /**
         * @param inputStream
         * parse and return string from the {@link InputStream}
         */
        @Override
        public String parseRawResponse(InputStream inputStream) throws IOException {

            int BUFFER_SIZE = 4096;
            ByteArrayOutputStream resultStream = new ByteArrayOutputStream(BUFFER_SIZE);

            byte[] buffer = new byte[BUFFER_SIZE];
            int length;

            while ((length = inputStream.read(buffer)) != -1) {
                resultStream.write(buffer, 0, length);
            }
            return resultStream.toString("UTF-8");
        }

    }
}
