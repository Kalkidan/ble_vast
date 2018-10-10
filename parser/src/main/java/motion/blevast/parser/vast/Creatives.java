package motion.blevast.parser.vast;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Creatives {

    @Tag("Creative") private List<Creative> creativeList = new ArrayList<>();

    public List<Creative> getCreativeList() {
        return creativeList;
    }

    public void setCreativeList(Creative creative) {
        this.creativeList.add(creative);
    }
}
