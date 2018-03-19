package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 *
 <xs:element name="Impression" type="xs:anyURI" maxOccurs="unbounded" minOccurs="1">
 <xs:annotation>
 <xs:documentation>URL to request to track an impression</xs:documentation>
 </xs:annotation>
 </xs:element>
 *
 */
public class Impression {

    @Text
    private String text;

    public String getText() {
        return text;
    }
}
