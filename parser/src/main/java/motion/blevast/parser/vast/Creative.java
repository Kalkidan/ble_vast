package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Creative {

    public static final String CREATIVE ="Creative" ;
    public static final String AD_ID ="adID" ;
    public static final String SEQUENCE ="sequence" ;
    public static final String API_FRAMEWORK ="apiFramework" ;
    public static final String ID ="id" ;

    @Attribute(value = "adID") private String adID;

    @Attribute(value = "id") private String id;

    @Attribute private String sequence;

    @Attribute private String apiFramework;

    @Tag private Linear linear;

    @Tag private CompanionAds companionAds;

    @Tag private NonLinearAds nonLinearAds;

    public String getId() {
        return id;
    }

    public String getSequence() {
        return sequence;
    }

    public Linear getLinear() {
        return linear;
    }

    public CompanionAds getCompanionAds() {
        return companionAds;
    }

    public NonLinearAds getNonLinearAds() {
        return nonLinearAds;
    }

    public void setLinear(Linear linear) {
        this.linear = linear;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAdID(String adID) {
        this.adID = adID;
    }

    public void setApiFramework(String apiFramework) {
        this.apiFramework = apiFramework;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }
}
