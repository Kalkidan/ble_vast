package motion.blevast.com.executor;

public abstract class LiveDataUseCase<REQ extends UseCase.RequestValues,
        RES extends UseCase.ResponseValues,
        ERR extends UseCase.Error> extends UseCase<REQ, RES, ERR>{


    Response<RES, ERR> runTask(){ return  executeUsecaseLiveData(getRequestValues(), getUsecaseCallback()); }

    public abstract Response<RES, ERR> executeUsecaseLiveData(REQ requestValues, UseCaseCallback<RES, ERR> usecaseCallback);
}
