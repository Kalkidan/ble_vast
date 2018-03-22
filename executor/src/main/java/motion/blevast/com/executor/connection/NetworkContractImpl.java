package motion.blevast.com.executor.connection;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import motion.blevast.com.executor.UseCase;
import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.com.executor.util.Constants;

/**
 * An implementation of a network contract
 */

public abstract class NetworkContractImpl
        extends UseCase<NetworkContractImpl.RequestValues, NetworkContractImpl.ResponseValues, NetworkContractImpl.Error>
        implements NetworkContract<StringResponse> {

    private static final String TAG = NetworkContractImpl.class.getSimpleName();

    /**
     * @param requestValues
     * @param usecaseCallback A single line of execution for executing a usecase
     */
    @Override
    public void executeUsecase(RequestValues requestValues, UsecaseCallback usecaseCallback) {
        try {
            call(new BaseRequestImpl(requestValues.baseUrl,
                    requestValues.destinationUrl,
                    requestValues.connectionParameter), usecaseCallback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param callback
     * @param request  call over the network, get the response and return it.
     */

    private void call(BaseRequest request, UsecaseCallback callback) throws IOException {
        URL requestUrl = new URL(request.getBaseUrl());

        /**
         *
         * @see #openConnection(URL, int)
         *
         */
        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection(requestUrl, Constants.NO_FLAG);

        /**
         * @see HttpURLConnection#setDoOutput(boolean)
         * @see HttpURLConnection#setRequestProperty(String, String)
         */
        //TODO:: we don't need this for now:--> httpURLConnection.setRequestProperty("Content-Type", "text/xml");
        //TODO:: there could be a 415 ERROR code due to the content type -- we will decide to put it for GET only???
        //TODO:: so let it be defaulted to the system for http & https
        httpURLConnection.setRequestProperty("User-agent", System.getProperty("http.agent"));

        /**
         *
         * @see HttpURLConnection#setConnectTimeout(int)
         * @see HttpURLConnection#setReadTimeout(int)
         */
        int timeout = request.getConnectionParameter().getTimeout();
        httpURLConnection.setConnectTimeout(timeout);
        httpURLConnection.setReadTimeout(timeout);

        /**
         * @see HttpURLConnection#setRequestMethod(String)
         */
        httpURLConnection.setRequestMethod(request.getConnectionParameter().getRequestType().toString());
        OutputStreamWriter outputStreamWriter = null;

        if (RequestType.POST.equals(request.getConnectionParameter().getRequestType()) || RequestType.PUT.equals(request.getConnectionParameter().getRequestType())) {
            httpURLConnection.setDoOutput(true);

            /**
             *
             * A check put in place when whether we have a valid body or not.
             */
            if (!TextUtils.isEmpty(request.getBody())) {
                /**
                 *
                 * Write the POST body to the out going request
                 */
                outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream());
                outputStreamWriter.write(request.getBody());
                outputStreamWriter.flush();
            }
        } else {
            httpURLConnection.setDoInput(true);
        }
        Log.d(TAG, String.valueOf(httpURLConnection.getResponseCode()));

        //TODO:: changeable as we see fit, for now this will suffice
        switch (httpURLConnection.getResponseCode()) {
            case HttpURLConnection.HTTP_OK:
            case HttpURLConnection.HTTP_CREATED:
            case HttpURLConnection.HTTP_ACCEPTED:
            case HttpURLConnection.HTTP_PARTIAL:
            case HttpURLConnection.HTTP_NO_CONTENT:

                /**
                 * @see
                 * ConnectionHelper#readResponse(HttpURLConnection, ConnectionParams, OutputStreamWriter, UseCase.UseCaseCallback)
                 */
                readResponse(httpURLConnection, request.getConnectionParameter(), outputStreamWriter, callback);
            case HttpURLConnection.HTTP_NOT_AUTHORITATIVE:
            case HttpURLConnection.HTTP_RESET:
                httpURLConnection.disconnect();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                callback.onError(new BaseError(httpURLConnection.getResponseCode(), "Response code failure!"));
                break;
            default:
                httpURLConnection.disconnect();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                callback.onError(new BaseError(httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage()));
                break;
        }
    }

    /**
     * @param useCaseCallback
     * @param connectionParams
     * @param httpURLConnection
     * @param outputStreamWriter
     *
     */
    private void readResponse(HttpURLConnection httpURLConnection,
                              ConnectionParameter connectionParams,
                              OutputStreamWriter outputStreamWriter,
                              UsecaseCallback useCaseCallback) throws IOException {
        /*
         * Send the response back
         */
        useCaseCallback.onSuccess(createResponse(httpURLConnection.getResponseCode(),  httpURLConnection.getInputStream()));
        /**
         * Close the {@link OutputStreamWriter} and {@link BufferedReader}
         */
        httpURLConnection.disconnect();
    }


        /**
         * @param flags if we need any info/payload to be checked for any requirements.
         *
         * @param url  The {@link URL} for which the connection will be opened.
         */
    private URLConnection openConnection(URL url, int flags) throws IOException {
        return url.openConnection();
    }

    //Response Values
    public static class ResponseValues implements UseCase.ResponseValues{

        private String response;

        /**
         * @param response  The generic response from a network call.
         */
        public ResponseValues(String response){
            this.response = response;
        }

        public String getResponse() {
            return response;
        }

        @VisibleForTesting
        void setResponse(String response){
            this.response = response;
        }
    }

    //Request Values
    public static class RequestValues  implements UseCase.RequestValues{

        private String baseUrl;
        private String destinationUrl;
        private ConnectionParameter connectionParameter;

        /**
         * @param baseUrl
         * @param connectionParameter
         * @param destinationUrl
         */
        public RequestValues(String baseUrl, String destinationUrl, ConnectionParameter connectionParameter){
            this.baseUrl = baseUrl;
            this.destinationUrl = destinationUrl;
            this.connectionParameter = connectionParameter;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public String getDestinationUrl() {
            return destinationUrl;
        }

        public ConnectionParameter getConnectionParameter() {
            return connectionParameter;
        }


        @VisibleForTesting
        void setBaseUrl(String baseUrl){
            this.baseUrl = baseUrl;
        }

        @VisibleForTesting
        void setDestinationUrl(String destinationUrl){
            this.baseUrl = destinationUrl;
        }


        @VisibleForTesting
        void setConnectionParameter(ConnectionParameter connectionParameter){
            this.connectionParameter  = connectionParameter;
        }
    }
    //Error values
    public static class Error implements UseCase.Error{}

}
