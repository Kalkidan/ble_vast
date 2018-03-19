package motion.blevast.com.executor.connection;

import motion.blevast.com.executor.util.Constants;

/**
 * A specified connection parameter for making a network connection
 */

public class ConnectionParameter {

    private RequestType mRequestType;
    /**
     * The time out property for the connection to last.
     *
     * Is set by default but can be overridden with the use of proper constructor.
     */
    private int mTimeout = Constants.DEFAULT_TIMEOUT_API_REQUEST_SECONDS;

    public ConnectionParameter(RequestType requestType) {
        this.mRequestType = requestType;
    }

    public ConnectionParameter(RequestType requestType, int timeoutMilliseconds) {
        mRequestType = requestType;
        mTimeout = timeoutMilliseconds;

    }

    public RequestType getRequestType() {
        return mRequestType;
    }

    public int getTimeout() {
        return mTimeout * 1000 /** pass the time out in milli seconds */;
    }
}
