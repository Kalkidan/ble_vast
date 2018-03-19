package motion.blevast.vastparser.vast_2_0;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.vastparser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class CompanionAds {

    @Tag("Companion") private List<Companion> companionList = new ArrayList<>();

    public List<Companion> getCompanionList() {
        return companionList;
    }
}
