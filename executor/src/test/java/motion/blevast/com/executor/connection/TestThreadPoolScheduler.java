package motion.blevast.com.executor.connection;

import motion.blevast.com.executor.UseCase;
import motion.blevast.com.executor.UseCaseCallback;
import motion.blevast.com.executor.UsecaseScheduler;

/**
 * A thread pool executor that executes, notify response, and notify error
 */

public class TestThreadPoolScheduler implements UsecaseScheduler {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void onSuccess(V response, UseCaseCallback<V, E> useCaseCallback) {
        useCaseCallback.onSuccess(response);
    }

    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void onError(E error, UseCaseCallback<V, E> useCaseCallback) {
            useCaseCallback.onError(error);
    }
}
