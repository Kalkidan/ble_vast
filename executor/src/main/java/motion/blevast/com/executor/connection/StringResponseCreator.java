package motion.blevast.com.executor.connection;

import java.io.IOException;
import java.io.InputStream;
/**
 * A string response creator
 */

public class StringResponseCreator extends NetworkContractImpl {

    /**
     * @param data
     * @param responseCode
     *
     * create response from the network call.
     */
    @Override
    public BaseResponse createResponse(int responseCode, InputStream data) throws IOException {
        return new StringResponse(responseCode, data);
    }
}
