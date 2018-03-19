package motion.blevast.com.executor.connection;

/**
 *
 * A base error
 */

class BaseError {

    private int responseCode;
    private String errorMessage;

    public BaseError(int responseCode, String errorMessage) {
        this.responseCode = responseCode;
        this.errorMessage = errorMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
