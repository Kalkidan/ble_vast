package motion.blevast.parser.task;

import android.content.Context;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.lang.ref.WeakReference;

import javax.xml.parsers.ParserConfigurationException;

import motion.blevast.com.executor.UseCase;
import motion.blevast.com.executor.UsecaseCallback;
import motion.blevast.parser.parser.SchemaVersion;
import motion.blevast.parser.parser.XSDParsingReport;
import motion.blevast.parser.parser.XmlParser;
import motion.blevast.parser.vastad.model.VastData;

/**
 *
 *
 * This is a task that will parse VAST in a pre-defined order
 * 1. Parse through the xsd validation
 * or 2. Parse using tag by tag
 */

abstract class XSDValidateVast extends
        UseCase<XSDValidateVast.RequestValues, XSDValidateVast.ResponseValues, XSDValidateVast.Error> implements XSDParsingReport{

    public abstract void useSelectedValuesForValidation(String response);

    public abstract void processVast(String  response);

    /**
     * @param usecaseCallback
     * @param requestValues
     *
     * As much as possible keep it as local variable for thread safety, however, new instance of
     * a task is created always
     *
     */
    @Override
    public void executeUsecase(RequestValues requestValues, UsecaseCallback<ResponseValues, Error> usecaseCallback) {
        //
        org.w3c.dom.Document document = null;
        /**
         * Validate it using XSD
         */
        try {
           document = XmlParser.getDocument(requestValues.responseValues);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
            //
            getUsecaseCallback().onError(new Error(e.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
            //
            getUsecaseCallback().onError(new Error(e.getMessage()));
        } catch (SAXException e) {
            e.printStackTrace();
            //
            getUsecaseCallback().onError(new Error(e.getMessage()));
        }

        //Guard
        if(document != null){

            if (XmlParser.validateSchema(document, requestValues.context, SchemaVersion.VERSION_3_0, this)){

                //process vast using XSD
                processVast(requestValues.responseValues);
            } else {

                //use manual inspection
                useSelectedValuesForValidation(requestValues.responseValues);
            }
        } else {
            //TODO:: report an Error due to conversion of the document

        }

    }

    public static class ResponseValues implements UseCase.ResponseValues{

        private VastData vastData;
        private WeakReference<Context> context;
        private String report;

        public ResponseValues(VastData vastData, WeakReference<Context> context, String report) {
            this.vastData = vastData;
            this.context = context;
            this.report = report;
        }

        public VastData getVastData() {
            return vastData;
        }
        public WeakReference<Context> getContext() {
            return context;
        }
        public String getReport() {
            return report;
        }
    }

    public static class RequestValues implements UseCase.RequestValues{

        private String responseValues;
        private WeakReference<Context> context;

        public RequestValues(String responseValues, Context context) {
            this.responseValues = responseValues;
            this.context = new WeakReference<>(context);
        }

        public String getResponseValues() {
            return responseValues;
        }
        public WeakReference<Context> getContext() {
            return context;
        }
    }

    public static class Error implements UseCase.Error{

        private String message;
        public Error(String message) {
            this.message = message;
        }
    }
}
