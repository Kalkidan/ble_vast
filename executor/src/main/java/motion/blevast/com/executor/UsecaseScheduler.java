package motion.blevast.com.executor;

/**
 * A scheduler class that will schedule different
 * tasks that are available.
 */

public interface UsecaseScheduler {

    void execute(Runnable runnable);

    <V extends UseCase.ResponseValues, E extends UseCase.Error> void onSuccess(final V response,
                                                                                    final UseCaseCallback<V, E> useCaseCallback);

    <V extends UseCase.ResponseValues, E extends UseCase.Error> void onError(final E error,
            final UseCaseCallback<V, E> useCaseCallback);
}
