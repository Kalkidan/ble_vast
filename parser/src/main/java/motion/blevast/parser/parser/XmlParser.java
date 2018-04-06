package motion.blevast.parser.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;

import motion.blevast.parser.vast.Vast;

/**
 * An xml parser
 */

public class XmlParser {

    XmlPullParserFactory xmlPullParserFactory;

    public XmlParser() throws XmlPullParserException {
        this. xmlPullParserFactory = XmlPullParserFactory.newInstance();
    }

    /**
     * @param inputStream pass the input stream
     *                    from the network call
     */
    public Vast parse(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser  = xmlPullParserFactory.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        return parseVast(xmlPullParser);
    }

    private Vast parseVast(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {

        xmlPullParser.next();
        int attributeCount = xmlPullParser.getAttributeCount();
        String name = xmlPullParser.getName();

        if(attributeCount > 0){

        }
        //Construct vast here
        return new Vast();
    }
}
