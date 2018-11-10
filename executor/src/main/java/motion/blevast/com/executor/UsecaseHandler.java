package motion.blevast.com.executor;

import java.util.concurrent.atomic.AtomicBoolean;

import androidx.lifecycle.LiveData;

/**
 * A use case handler class that runs multiple
 * threads in a given execution.
 */

public class UsecaseHandler {


    public static UsecaseHandler getInstance() {
        return new UsecaseHandler(new UsecaseThreadPoolScheduler());
    }

    //A OS thread scheduler.
    private UsecaseScheduler usecaseScheduler;

    /**
     * @param usecaseScheduler the core of the logic to pass
     *                         a scheduler contract for handing all
     *                         the {@link Runnable} in the project
     */
    public UsecaseHandler(UsecaseScheduler usecaseScheduler) {
        this.usecaseScheduler = usecaseScheduler;
    }

    /**
     * @param requestValue
     * @param useCase
     * @param useCaseCallback
     *
     */
    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValues, E extends UseCase.Error>
    LiveData<Response<R, E>> execute(final LiveDataUseCase<T, R, E> useCase,
                                                   T requestValue,
                                                   UseCaseCallback<R, E> useCaseCallback
    ) {
        //Set the request value so it gets read  in the corresponding subclass
        useCase.setRequestValues(requestValue);
        ///Sets the usecase
        useCase.setUsecaseCallback(useCaseCallback);

        //Return the live data
        return new LiveData<Response<R, E>>() {

            AtomicBoolean atomicBoolean = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();

                if (atomicBoolean.compareAndSet(false, true)) {
                    usecaseScheduler.execute(new Runnable() {
                        @Override
                        public void run() {
                            postValue(useCase.runTask());
                        }
                    });
                }
            }
        };
    }

    //Execution
    //Request values goes in --> success/failure will carry the output of the execution
    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValues, E extends UseCase.Error> void
    execute(final UseCase<T, R, E> useCase, T requestValues, UseCaseCallback<R, E> usecaseCallback) {

        //Steps of Execution
        //.........//........//
        //1.set the request
        //2.We could have set the response values if we need to
        useCase.setRequestValues(requestValues);

        //3.set usecase callback
        useCase.setUsecaseCallback(new UseCaseCallbackHandler(usecaseCallback, this));

        //4.start executing the task
        usecaseScheduler.execute(new Runnable() {
            @Override
            public void run() {
                //Run the UseCase
                useCase.run();
            }
        });
    }

    //Notifies the response from the execution
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void
    notifyResponse(V response, UseCaseCallback<V, E> callback) {
        usecaseScheduler.onSuccess(response, callback);
    }

    //Notifies the error from the execution
    public <V extends UseCase.ResponseValues, E extends UseCase.Error> void
    notifyError(final E error, UseCaseCallback<V, E> callback) {
        usecaseScheduler.onError(error, callback);
    }
}
