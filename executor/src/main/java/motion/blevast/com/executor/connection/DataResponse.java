package motion.blevast.com.executor.connection;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/**
 * A data response
 */
class DataResponse extends BaseResponseImpl<DataResponse.Data>{

    /**
     * @param serverCode
     * @param inputStream
     */
    public DataResponse(int serverCode, InputStream inputStream) throws IOException {
        super(serverCode, inputStream);
    }

    DataResponse(int serverCode, HttpURLConnection httpURLConnection) throws IOException{
        super(serverCode, httpURLConnection.getInputStream());
    }

    /**
     * @param inputStream
     */
    @Override
    public Data parseRawResponse(InputStream inputStream) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[0xFFFF];

        for (int len; (len = inputStream.read(buffer)) != -1;)
            os.write(buffer, 0, len);
        os.flush();
        Data data = new Data();
        data.array = os.toByteArray();
        return data;
    }

    class Data {
        byte[] array;
    }
}
