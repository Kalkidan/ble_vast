package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Text;

/**
 * Created by kaltadesse on 7/11/17.
 *
 * <xs:element name="VASTAdTagURI" type="xs:anyURI" maxOccurs="1" minOccurs="1">
 <xs:annotation>
 <xs:documentation>URL of ad tag of downstream Secondary Ad Server</xs:documentation>
 </xs:annotation>
 </xs:element>
 */

public class VASTAdTagUri {
    @Text
    private String text;

    public String getText() {
        return text;
    }
}
