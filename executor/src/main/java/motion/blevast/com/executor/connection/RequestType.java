package motion.blevast.com.executor.connection;

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

    @Override
    public String toString() {
        return request;
    }
}
