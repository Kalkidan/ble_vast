package motion.blevast.com.executor;

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
    public UsecaseHandler(UsecaseScheduler usecaseScheduler){
        this.usecaseScheduler = usecaseScheduler;
    }

    //Execution
    //Request values goes in --> success/failure will carry the output of the execution
    public <T extends UseCase.RequestValues, R extends UseCase.ResponseValues, E extends UseCase.Error> void
    execute(final UseCase<T, R, E> useCase, T requestValues, UseCaseCallback<R, E> usecaseCallback){

        //Steps of Execution
        //.........//........//
        //1.set the request
        //2.We could have set the response values if we need to
        useCase.setRequestValues(requestValues);

        //3.set usecase callback
        useCase.setUsecaseCallback(new  UseCaseCallbackHandler(usecaseCallback, this));

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
