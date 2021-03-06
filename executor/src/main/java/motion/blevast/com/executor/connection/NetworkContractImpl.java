package motion.blevast.com.executor.connection;

import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import motion.blevast.com.executor.UseCase;
import motion.blevast.com.executor.UseCaseCallback;
import motion.blevast.com.executor.util.Constants;

/**
 * An implementation of a network contract
 */

public abstract class NetworkContractImpl<RESPONSE extends UseCase.ResponseValues>
        extends UseCase<NetworkContractImpl.RequestValues, NetworkContractImpl.ResponseValues, NetworkContractImpl.Error> {

    private static final String TAG = NetworkContractImpl.class.getSimpleName();

    abstract RESPONSE createResponse(int responseCode, InputStream data) throws IOException;

    /**
     * @param requestValues
     * @param usecaseCallback A single line of execution for executing a usecase
     */
    @Override
    public void executeUsecase(RequestValues requestValues, UseCaseCallback usecaseCallback) {
        try {
            call(requestValues, usecaseCallback);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param callback
     * @param request  call over the network, get the response and return it.
     */

    private void call(RequestValues request, UseCaseCallback callback) throws IOException {
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

        //This is for CORS cross-origin resource sharing
        httpURLConnection.setRequestProperty("Access-Control-Allow-Origin", "*");

        /**
         * @see HttpURLConnection#setRequestMethod(String)
         */
        httpURLConnection.setRequestMethod(request.getConnectionParameter().getRequestType().toString());
        OutputStreamWriter outputStreamWriter = null;

        if (RequestType.POST.equals(request.getConnectionParameter().getRequestType()) ||
                RequestType.PUT.equals(request.getConnectionParameter().getRequestType())) {
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
                break;
            case HttpURLConnection.HTTP_NOT_AUTHORITATIVE:
            case HttpURLConnection.HTTP_RESET:
                httpURLConnection.disconnect();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                callback.onError(new Error(httpURLConnection.getResponseCode(), "Response code failure!"));
                break;
            default:
                httpURLConnection.disconnect();
                if (outputStreamWriter != null) {
                    outputStreamWriter.close();
                }
                callback.onError(new Error(httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage()));
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
                              UseCaseCallback useCaseCallback) throws IOException {
        /*
         * Send the response back
         */
        useCaseCallback.onSuccess(createResponse(httpURLConnection.getResponseCode(),
                httpURLConnection.getInputStream()));
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

    // This is the base response for a networking call
    public abstract static class ResponseValues<RESPONSE> implements UseCase.ResponseValues{

        // Response
        // Generic response from the api call
        private RESPONSE response;
        // TODO:: we will think if we can genericize if but don't need it now.
        private int responseCode;

        /**
         * @param responseCode  The generic response from a network call.
         * @param inputStream
         */
        public ResponseValues(int responseCode, InputStream inputStream) throws IOException {
            this.response = parseRawResponse(inputStream);
            this.responseCode = responseCode;
        }

        public int getResponseCode() {
            return responseCode;
        }
        public RESPONSE getResponse() {
            return response;
        }
        void setResponse(RESPONSE response){
            this.response = response;
        }
        //An object representation of the network response
        abstract RESPONSE parseRawResponse(InputStream inputStream) throws IOException;
    }

    //Request Values
    public static class RequestValues  implements UseCase.RequestValues{

        private String baseUrl;
        private String body;
        private ConnectionParameter connectionParameter;

        /**
         * @param baseUrl
         * @param connectionParameter
         * @param body
         */
        public RequestValues(String baseUrl, String body, ConnectionParameter connectionParameter){
            this.baseUrl = baseUrl;
            this.body = body;
            this.connectionParameter = connectionParameter;
        }

        String getBaseUrl() {
            return baseUrl;
        }
        public String getBody() {
            return body;
        }
        ConnectionParameter getConnectionParameter() {
            return connectionParameter;
        }


        void setBaseUrl(String baseUrl){
            this.baseUrl = baseUrl;
        }
        void setDestinationUrl(String destinationUrl){
            this.baseUrl = destinationUrl;
        }
        void setConnectionParameter(ConnectionParameter connectionParameter){
            this.connectionParameter  = connectionParameter;
        }
    }
    //Error values
    public static class Error implements UseCase.Error{
        private int responseCode;
        private String errorMessage;

        public Error(int responseCode, String errorMessage) {
            this.responseCode = responseCode;
            this.errorMessage = errorMessage;
        }

        public int getResponseCode() {
            return responseCode;
        }
        public String getErrorMessage() {
            return errorMessage;
        }
    }

}
