package motion.blevast.com.executor;


import android.os.Handler;
import android.util.Log;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static motion.blevast.com.executor.util.Constants.MAX_POOL_SIZE;
import static motion.blevast.com.executor.util.Constants.POOL_SIZE;
import static motion.blevast.com.executor.util.Constants.TIME_OUT;

/**
 * A use case executor
 */

public class UsecaseThreadPoolScheduler implements UsecaseScheduler {

    public static final String TAG = UsecaseThreadPoolScheduler.class.getSimpleName();

    private final Handler useCaseHandler = new Handler();
    private ThreadPoolExecutor threadPoolExecutor;

    public UsecaseThreadPoolScheduler(){
        //Init the Threadpool
        threadPoolExecutor = new ThreadPoolExecutor(POOL_SIZE, MAX_POOL_SIZE, TIME_OUT,
                TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
    }
    @Override
    public void execute(Runnable runnable) {
        //Execute the runnable
        threadPoolExecutor.execute(runnable);
    }

    /**
     * @param response
     * @param useCaseCallback
     */
    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void
    onSuccess(final V response, final UsecaseCallback<V, E> useCaseCallback) {
        useCaseHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Running onSuccess():");
                useCaseCallback.onSuccess(response);
            }
        });
    }

    /**
     * @param error
     * @param useCaseCallback
     *
     */
    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void
    onError(final E error, final UsecaseCallback<V, E> useCaseCallback) {
        useCaseHandler.post(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Running onError():");
                useCaseCallback.onError(error);
            }
        });
    }
}
