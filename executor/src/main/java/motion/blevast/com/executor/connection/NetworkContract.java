package motion.blevast.com.executor.connection;

import java.io.IOException;
import java.io.InputStream;

/**
 * A generic contract defining network connectivity and its
 * basic functions
 */

public interface NetworkContract<RESPONSE extends BaseResponse> {
    RESPONSE createResponse(int responseCode, InputStream data) throws IOException;
}
