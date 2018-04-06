package motion.blevast.parser.parser;

import android.content.Context;
import android.text.TextUtils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import mf.javax.xml.transform.Source;
import mf.javax.xml.transform.stream.StreamSource;
import mf.javax.xml.validation.Schema;
import mf.javax.xml.validation.SchemaFactory;
import mf.javax.xml.validation.Validator;
import mf.org.apache.xerces.jaxp.validation.XMLSchemaFactory;

/**
 * The main line-of-thinking behind this is the idea that
 * the parser is generic and we wont have to do a separate
 * parser for each. It takes a little time for parsing but
 * we have a generic parser for that. And the time is not
 * that high
 *
 */

public class XmlParser {

    XmlPullParserFactory xmlPullParserFactory;


    /**
     *  @param doc this block will validate against
     *            vast 2.0 schema
     * @param context
     */
    public static boolean validateSchema(Document doc, WeakReference<Context> context, SchemaVersion schemaVersion) {

        String schemaVer = null;

        switch (schemaVersion){
            case VERSION_2_0:
                schemaVer = "vast_2_0_1_schema.xsd";
                break;
            case VERSION_3_0:
                schemaVer = "vast_3_0_schema.xsd";
                break;
            case VERSION_4_0:
                schemaVer = "vast_4_0_schema.xsd";
                break;
        }
        /**
         *
         * Get the schema from the resources
         */
        InputStream stream = null;
        try {
            stream = context.get().getAssets().open(schemaVer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         *
         * Build a {@link String} out of the xml string responses
         */
        String xml = xmlDocumentToString(doc);
        boolean isValid = validate(stream, xml);

        try {
            stream.close();
        } catch (IOException e) {

        }
        return isValid;
    }

    /**
     * @param doc takes in the document and puts out a {@link DOMSource}
     *            string transformation of it.
     *
     */
    public static String xmlDocumentToString(Document doc) {

        StringWriter stringWriter = null;

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            stringWriter = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));


        } catch (Exception e) {

        }

        return stringWriter.toString();
    }

    /**
     * @param schemaStream
     * @param xml  This will validate the schema
     *
     */
    public static boolean validate(InputStream schemaStream, String xml) {

        SchemaFactory factory = new XMLSchemaFactory();
        Source schemaSource = new StreamSource(schemaStream);

        Source xmlSource = new StreamSource(new ByteArrayInputStream(xml.getBytes()));
        Schema schema;

        try {
            schema = factory.newSchema(schemaSource);
            Validator validator = schema.newValidator();
            validator.validate(xmlSource);

        } catch (final Exception e) {
            //TODO:: make sure we have reporting for this

            return false;
        }

        return true;
    }

    /**
     * @param classOfT
     * @param xml
     *
     */
    public static <T> T parse(String xml, Class<T> classOfT) throws Exception {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(new StringReader(xml));
        parser.next();
        return parseTag(parser, classOfT);
    }


    /**
     * @param classOfT
     * @param parser
     *
     */
    private static <T> T parseTag(XmlPullParser parser, Class<T> classOfT) throws Exception {
        T tagInstance = classOfT.newInstance();
        parseAttributes(parser, tagInstance);
        parser.next();
        parseElements(parser, tagInstance);
        parser.next();
        return tagInstance;
    }

    /**
     * @param parser
     * @param tagInstance
     *
     */
    private static <T> void parseAttributes(XmlPullParser parser, T tagInstance) throws IllegalAccessException {
        for (Field field : tagInstance.getClass().getDeclaredFields()) {
            Attribute attribute = getAnnotation(field, Attribute.class);
            if (attribute == null) {
                continue;
            }
            String attributeValue = attribute.value();
            if (TextUtils.isEmpty(attributeValue)) {
                attributeValue = field.getName();
            }
            String value = parser.getAttributeValue(null, attributeValue);
            if (TextUtils.isEmpty(value)) {
                continue;
            }
            field.setAccessible(true);
            Class fieldClass = field.getType();
            if (fieldClass.equals(String.class)) {
                field.set(tagInstance, value);
            } else if (Long.class.equals(fieldClass) || long.class.equals(fieldClass)) {
                field.setLong(tagInstance, Long.parseLong(value));
            } else if (Integer.class.equals(fieldClass) || int.class.equals(fieldClass)) {
                field.setInt(tagInstance, Integer.parseInt(value));
            } else if (Byte.class.equals(fieldClass) || byte.class.equals(fieldClass)) {
                field.setByte(tagInstance, Byte.parseByte(value));
            } else if (Double.class.equals(fieldClass) || double.class.equals(fieldClass)) {
                field.setDouble(tagInstance, Double.parseDouble(value));
            } else if (Float.class.equals(fieldClass) || float.class.equals(fieldClass)) {
                field.setFloat(tagInstance, Float.parseFloat(value));
            } else if (Boolean.class.equals(fieldClass) || boolean.class.equals(fieldClass)) {
                field.setBoolean(tagInstance, Boolean.parseBoolean(value));
            }
        }
    }

    /**
     * @param annotationType
     * @param element
     *
     */
    @SuppressWarnings("unchecked")
    private static <T extends Annotation> T getAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationType) {
        for (Annotation annotation : element.getDeclaredAnnotations()) {
            if (annotationType.isInstance(annotation)) {
                return (T) annotation;
            }
        }
        return null;
    }
    /**
     * @param parser
     * @param tagInstance
     *
     */
    private static <T> void parseElements(XmlPullParser parser, T tagInstance) throws Exception {
        while (parser.getEventType() == XmlPullParser.START_TAG
                || parser.getEventType() == XmlPullParser.TEXT) {
            if (parser.getEventType() == XmlPullParser.TEXT) {
                parseText(parser, tagInstance);
            } else {
                parseSubTag(parser, tagInstance);
            }
        }
    }


    /**
     *
     * @param parser
     * @param parent
     *
     */
    private static <T> void parseText(XmlPullParser parser, T parent) throws Exception {
        if (parser.getEventType() != XmlPullParser.TEXT) {
            return;
        }
        Field textField = getFieldForText(parent);
        if (textField != null) {
            textField.setAccessible(true);
            textField.set(parent, parser.getText());
        }
        parser.next();
    }

    /**
     *
     * @param parser
     * @param parent
     */
    @SuppressWarnings("unchecked")
    private static <T> void parseSubTag(XmlPullParser parser, T parent) throws Exception {
        String tagName = parser.getName();
        int tagDepth = parser.getDepth();

        Field tagField = getFieldForTag(parent, tagName);
        if (tagField == null) {
            skipTag(parser, tagName, tagDepth);
        } else {
            if (List.class.isAssignableFrom(tagField.getType())) {
                ParameterizedType listGenericType = (ParameterizedType) tagField.getGenericType();
                Class<?> listGenericClass = (Class<?>) listGenericType.getActualTypeArguments()[0];
                Object tag = parseTag(parser, listGenericClass);
                tagField.setAccessible(true);
                List list = (List) tagField.get(parent);
                if (list == null) {
                    list = new ArrayList();
                    tagField.set(parent, list);
                }
                list.add(tag);
            } else {
                Object tag = parseTag(parser, tagField.getType());
                tagField.setAccessible(true);
                tagField.set(parent, tag);
            }
        }
    }

    /**
     *
     * @param parent
     * @param tagName
     */
    private static <T> Field getFieldForTag(T parent, String tagName) {
        for (Field field : parent.getClass().getDeclaredFields()) {
            Tag tagAnnotation = getAnnotation(field, Tag.class);
            if (tagAnnotation != null) {
                String tagValue = tagAnnotation.value();
                if (TextUtils.isEmpty(tagValue)) {
                    tagValue = field.getName();
                }
                if (tagValue.equalsIgnoreCase(tagName)) {
                    return field;
                }
            }
        }
        return null;
    }

    /**
     *
     * @param parent
     */
    private static <T> Field getFieldForText(T parent) {
        for (Field field : parent.getClass().getDeclaredFields()) {
            Text textAnnotation = getAnnotation(field, Text.class);
            if (textAnnotation != null) {
                return field;
            }
        }
        return null;
    }

    /**
     * @param parser
     * @param depth
     * @param name
     *
     */
    private static void skipTag(XmlPullParser parser, String name, int depth) throws Exception {
        while (true) {
            parser.next();
            if (parser.getEventType() == XmlPullParser.END_TAG && parser.getName().equalsIgnoreCase(name) && parser.getDepth() == depth) {
                break;
            }
        }
        parser.next();
    }

    /**
     * @param document
     *
     */
    public static <T extends Document> T getDocument(String  document) throws ParserConfigurationException, IOException, SAXException {
        /**
         *
         * Defines a factory API that enables applications to obtain a
         * parser that produces DOM object trees from XML documents.
         */
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
        InputSource inputSource = new InputSource();
        inputSource.setCharacterStream(new StringReader(document));
        return (T) db.parse(inputSource);
    }
}
