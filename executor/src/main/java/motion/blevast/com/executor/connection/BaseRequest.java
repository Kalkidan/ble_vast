package motion.blevast.com.executor.connection;

/**
 * A contract defining base requirements for every connection run.
 */

public interface BaseRequest {

    String getBaseUrl();
    String getBody();
    ConnectionParameter getConnectionParameter();
}


