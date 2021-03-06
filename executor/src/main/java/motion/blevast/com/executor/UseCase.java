package motion.blevast.com.executor;

import androidx.lifecycle.LiveData;

/**
 *
 * These are likely to be the entry points to the data-android layer
 * and also exit points from android-data layer or whichever way you
 * wish to think it.
 *
 * The logic behind the idea is for us to have a task to get into the
 * an executable state with the REQuest, RESponse, ERRor values.
 *
 * REQuest--these are values from the UI layer as an input for the execution
 * RESponse--these are values to be reported back onSuccess()
 * ERRor--these are values to be reported back onError()
 *
 * This is a self executable task() as in the context of a use case
 */

public abstract class UseCase<REQ extends UseCase.RequestValues, RES extends UseCase.ResponseValues, ERR extends UseCase.Error> {

    // Generic request and
    // response values
    private REQ requestValues;
    private RES responseValues;

    // A Usecase callback for response and Error
    private UseCaseCallback<RES, ERR> usecaseCallback;

    public REQ getRequestValues() {
        return this.requestValues;
    }
    public RES getResponseValues() {
        return this.responseValues;
    }

    // Get UseCase callback
    // Execution results
    public UseCaseCallback<RES, ERR> getUsecaseCallback() {
        return this.usecaseCallback;
    }

    /**
     * @param usecaseCallback
     */
    public void setUsecaseCallback(UseCaseCallback<RES, ERR> usecaseCallback) {
        this.usecaseCallback = usecaseCallback;
    }

    // A Self executing UseCase block
    void run(){
        executeUsecase(this.requestValues, this.usecaseCallback);
    }

    /****/
    // Inherited in the sub-classes/usecases
    public abstract void executeUsecase(REQ requestValues, UseCaseCallback<RES, ERR> usecaseCallback);

    // Sets request values
    public void setRequestValues(REQ requestValues) {
        this.requestValues = requestValues;
    }

    // Sets response values
    public void setResponseValues(RES responseValues) {
        this.responseValues = responseValues;
    }

    // possible outcomes for response types
    // 1. Response Values
    // 2. Request  Values
    // 3. Error    Values
    // Set what we need here, so we can use it in general
    public  interface ResponseValues{}
    public  interface RequestValues {}
    public  interface Error{}
}
