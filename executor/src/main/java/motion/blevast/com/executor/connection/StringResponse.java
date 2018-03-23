package motion.blevast.com.executor.connection;

import android.support.annotation.VisibleForTesting;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * A common format of response
 */

public class StringResponse extends NetworkContractImpl.ResponseValues<String>{

    /**
     * @param inputStream
     * @param serverCode
     *
     */
    public StringResponse(int serverCode, InputStream inputStream) throws IOException {
        super(serverCode, inputStream);
    }

    StringResponse(int serverCode, HttpURLConnection httpURLConnection) throws IOException {
        super(serverCode, httpURLConnection.getInputStream());
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
