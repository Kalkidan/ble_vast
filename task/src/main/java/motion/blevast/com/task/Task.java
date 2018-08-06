package motion.blevast.com.task;


/**
 * An executable task parent class that
 * will be used as a {@link Runnable}
 */
public abstract class Task<RES extends Task.ResponseValues,
        REQ extends Task.RequestValues,
        ERR extends Task.ErrorValues> implements Runnable{

    /**
     * REQ, RES, and ERR values
     * generic for all tasks that will extend this parent class.
     */
    private RES responseValues;
    private REQ requestValues;
    private ERR errorValues;

    public ERR getErrorValues() {
        return errorValues;
    }

    public REQ getRequestValues() {
        return requestValues;
    }

    public RES getResponseValues() {
        return responseValues;
    }

    public void setErrorValues(ERR errorValues) {
        this.errorValues = errorValues;
    }

    public void setRequestValues(REQ requestValues) {
        this.requestValues = requestValues;
    }

    public void setResponseValues(RES responseValues) {
        this.responseValues = responseValues;
    }

    public abstract void execute(REQ requestValues) throws Exception;

    @Override public void run() {
        try {
            execute(this.requestValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    interface RequestValues{}
    interface ResponseValues{}
    interface ErrorValues{}
}
