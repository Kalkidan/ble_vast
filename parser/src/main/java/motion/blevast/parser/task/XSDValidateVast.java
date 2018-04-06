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
import motion.blevast.parser.parser.XmlParser;

/**
 *
 *
 * This is a task that will parse VAST in a pre-defined order
 * 1. Parse through the xsd validation
 * or 2. Parse using tag by tag
 */

public abstract class XSDValidateVast extends UseCase<XSDValidateVast.RequestValues, XSDValidateVast.ResponseValues, XSDValidateVast.Error>{

    public abstract void useSelectedValuesForValidation();

    public abstract void processVast(Document document);

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
        org.w3c.dom.Document document = null;
        /**
         * Validate it using XSD
         */
        try {
           document = XmlParser.getDocument(requestValues.requestValues);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        //Guard
        if(document != null){

            if (XmlParser.validateSchema(document, requestValues.context, SchemaVersion.VERSION_3_0)){

                //process vast
                processVast(document);
            } else {

            }
        } else {
            //TODO:: report an Error due to conversion of the document
        }

    }

    public static class ResponseValues implements UseCase.ResponseValues{}

    public static class RequestValues implements UseCase.RequestValues{

        private String requestValues;
        private WeakReference<Context> context;

        public RequestValues(String requestValues, Context context) {
            this.requestValues = requestValues;
            this.context = new WeakReference<>(context);
        }

        public String getRequestValues() {
            return requestValues;
        }
    }

    public static class Error implements UseCase.Error{}
}
