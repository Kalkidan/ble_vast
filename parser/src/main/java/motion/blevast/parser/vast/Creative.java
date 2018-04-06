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

    @Attribute(value = "AdID") private String id;

    @Attribute private String sequence;

    @Tag
    private Linear linear;

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
}
