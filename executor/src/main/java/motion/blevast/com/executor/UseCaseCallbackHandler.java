package motion.blevast.com.executor;

public class UseCaseCallbackHandler<R extends UseCase.ResponseValues, E extends UseCase.Error> implements UsecaseCallback<R, E> {

    private UsecaseCallback<R, E> usecaseCallback;
    protected UsecaseHandler usecaseHandler;


    public UseCaseCallbackHandler(UsecaseCallback<R, E>  usecaseCallback, UsecaseHandler usecaseHandler){
        this.usecaseCallback = usecaseCallback;
        this.usecaseHandler = usecaseHandler;
    }
    @Override
    public void onSuccess(R response) {
        usecaseHandler.notifyResponse(response, usecaseCallback);
    }

    @Override
    public void onError(E error) {
        usecaseHandler.notifyError(error, usecaseCallback);
    }
}
