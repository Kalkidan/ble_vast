package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Text;

/**
 * Created by kaltadesse on 7/11/17.
 *
 * <xs:element name="VASTAdTagURI" type="xs:anyURI" maxOccurs="1" minOccurs="1">
 * <xs:annotation>
 * <xs:documentation>URL of ad tag of downstream Secondary Ad Server</xs:documentation>
 * </xs:annotation>
 * </xs:element>
 */

public class VASTAdTagUri {

    @Text private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
