package motion.blevast.com.executor.connection;

import java.io.IOException;
import java.io.InputStream;

/**
 * A contract that is implemented for every response if any
 */

abstract class BaseResponseImpl<RES> implements BaseResponse{

    //A common server code
    private int serverCode;

    //A common response type
    RES resopnseResponse;

    /**
     * @param inputStream
     * @param serverCode
     *
     */
    public BaseResponseImpl(int serverCode, InputStream inputStream) throws IOException {
        this.serverCode = serverCode;
        this.resopnseResponse = parseRawResponse(inputStream);
    }

    //Return the serve code.
    @Override
    public int getServerCode() {
        return serverCode;
    }

    @Override
    public RES getResponse() {
        return resopnseResponse;
    }

    /**
     * @param inputStream
     */
    public abstract RES parseRawResponse(InputStream inputStream) throws IOException;
}
