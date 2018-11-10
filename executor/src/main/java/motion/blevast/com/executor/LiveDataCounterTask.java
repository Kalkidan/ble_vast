package motion.blevast.com.executor;

public class LiveDataCounterTask extends LiveDataUseCase<LiveDataCounterTask.RequestValues,
        LiveDataCounterTask.ResponseValue, LiveDataCounterTask.Error> {


    @Override
    public Response<ResponseValue, Error> executeUsecaseLiveData(RequestValues requestValues, UseCaseCallback<ResponseValue, Error> usecaseCallback) {
        return null;
    }

    @Override
    public void executeUsecase(RequestValues requestValues, UseCaseCallback<ResponseValue, Error> usecaseCallback) { }

    public static class ResponseValue implements UseCase.ResponseValues{}
    public static class RequestValues implements UseCase.RequestValues {}
    public static class Error implements UseCase.Error{}
}
