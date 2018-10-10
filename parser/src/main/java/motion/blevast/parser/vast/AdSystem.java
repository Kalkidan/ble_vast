package motion.blevast.parser.vast;


import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * Indicates source ad server
 *
 *
 <xs:element name="AdSystem" maxOccurs="1" minOccurs="1" type="AdSystem_type">
 <xs:annotation>
 <xs:documentation>Indicates source ad server</xs:documentation>
 </xs:annotation>
 </xs:element>
 *
 *
 */
public class AdSystem {

    @Attribute private String version;

    //this will indicate the source ad server
    @Text private String sourceAdServer;

    public String getVersion() {
        return version;
    }

    public String getSourceAdServer() {
        return sourceAdServer;
    }

    public void setSourceAdServer(String sourceAdServer) {
        this.sourceAdServer = sourceAdServer;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
