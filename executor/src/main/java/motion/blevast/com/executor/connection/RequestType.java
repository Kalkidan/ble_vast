package motion.blevast.com.executor.connection;

import android.support.annotation.VisibleForTesting;

/**
 * This will be used as a template for selecting the type of
 * call-- POST, GET, PUT, DELETE.
 */
public enum RequestType {

    POST("POST"), GET("GET"), PUT("PUT"), DELETE("DELETE");

    private String request;

    RequestType(String request){
        this.request = request;
    }

    /**
     * Override the toString methods to return the
     * underlying REQUEST_TYPE that can be used by the
     * HttpURLConnection.
     */
    @Override
    public String toString() {
        return request;
    }
}
