package motion.blevast.com.executor.connection;

/**
 * A base run class for each request needed
 */
class BaseRequestImpl implements BaseRequest{

    private String baserUrl;
    private String body;
    private ConnectionParameter connectionParameter;


    public BaseRequestImpl(String baserUrl, String body, ConnectionParameter connectionParameter){
        this.baserUrl = baserUrl;
        this.body = body;
        this.connectionParameter = connectionParameter;
    }

    @Override
    public ConnectionParameter getConnectionParameter() {
        return connectionParameter;
    }

    @Override
    public String getBaseUrl() {
        return baserUrl;
    }

    @Override
    public String getBody() {
        return body;
    }
}
