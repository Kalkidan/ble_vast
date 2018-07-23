package motion.blevast.com.executor;

/**
 * A Generic Usecase call back on success and error
 */

public interface UsecaseCallback<RES, ERR> {

    //Defines a contract for the execution of the Usecase:
    //1.onSuccess()
    //2.onError()
    void onSuccess(RES response);
    void onError(ERR error);
}

