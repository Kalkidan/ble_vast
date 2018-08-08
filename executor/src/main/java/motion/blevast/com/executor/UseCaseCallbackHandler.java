package motion.blevast.com.executor;

public class UseCaseCallbackHandler<R extends UseCase.ResponseValues, E extends UseCase.Error> implements UseCaseCallback<R, E> {

    private UseCaseCallback<R, E> usecaseCallback;
    protected UsecaseHandler usecaseHandler;


    public UseCaseCallbackHandler(UseCaseCallback<R, E> usecaseCallback, UsecaseHandler usecaseHandler){
        this.usecaseCallback = usecaseCallback;
        this.usecaseHandler = usecaseHandler;
    }
    @Override
    public void onSuccess(R response) {
        this.usecaseHandler.notifyResponse(response, this.usecaseCallback);
    }

    @Override
    public void onError(E error) {
        this.usecaseHandler.notifyError(error, this.usecaseCallback);
    }
}
