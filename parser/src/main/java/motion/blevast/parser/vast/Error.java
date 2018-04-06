package motion.blevast.parser.vast;


import motion.blevast.parser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * <xs:element name="Error" type="xs:anyURI" minOccurs="0" maxOccurs="1">
 <xs:annotation>
 <xs:documentation>URL to request if ad does not play due to error</xs:documentation>
 </xs:annotation>
 </xs:element>
 *
 */
public class Error {

    @Text
    private String text;

    public String getText() {
        return text;
    }
}
