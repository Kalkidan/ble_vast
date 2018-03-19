package motion.blevast.com.executor;

/**
 * A thread pool executor that executes, notify response, and notify error
 */

public class TestThreadPoolScheduler implements UsecaseScheduler {

    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void notifyResponse(V response, UsecaseCallback<V, E> useCaseCallback) {
            useCaseCallback.onSuccess(response);
    }

    @Override
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void onError(E error, UsecaseCallback<V, E> useCaseCallback) {
            useCaseCallback.onError(error);
    }
}
