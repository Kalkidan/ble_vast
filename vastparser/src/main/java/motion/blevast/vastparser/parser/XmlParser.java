package motion.blevast.vastparser.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;

import motion.blevast.vastparser.vast_2_0.Vast;

/**
 * An xml parser
 */

public class XmlParser {

    XmlPullParserFactory xmlPullParserFactory;

    public XmlParser(XmlPullParserFactory xmlPullParserFactory){
        this. xmlPullParserFactory = xmlPullParserFactory;
    }

    /**
     * @param inputStream pass the input stream
     *                    from the network call
     */
    public Vast parse(InputStream inputStream) throws XmlPullParserException {
        XmlPullParser xmlPullParser  = xmlPullParserFactory.newPullParser();
        xmlPullParser.setInput(inputStream, "UTF-8");
        return parseVast(xmlPullParser);
    }

    private Vast parseVast(XmlPullParser xmlPullParser) {
        //Construct vast here
        return new Vast();
    }
}
