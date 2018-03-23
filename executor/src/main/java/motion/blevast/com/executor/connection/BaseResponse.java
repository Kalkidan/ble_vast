package motion.blevast.com.executor.connection;

import java.io.IOException;
import java.io.InputStream;

/**
 * A base response for every response received, if any
 */

public interface BaseResponse<RESPONSE> {

    //Every response has a server code to return
    int getServerCode();

    //An object representation of the network response
    RESPONSE parseRawResponse(InputStream inputStream) throws IOException;

    RESPONSE getResponse();
}
