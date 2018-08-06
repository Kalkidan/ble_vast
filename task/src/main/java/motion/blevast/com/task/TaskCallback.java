package motion.blevast.com.task;


/**
 * This is a task callback that defines what will happen
 * on success or on error.
 *
 */
public interface TaskCallback<RES, ERR> {

    void onSuccess(RES response);
    void onError(ERR error);
}
