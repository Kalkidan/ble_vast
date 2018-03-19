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
public class VideoClicks {

    @Tag("ClickThrough") private ClickThrough clickThrough;

    @Tag("ClickTracking") private List<ClickTracking> clickTrackingList = new ArrayList<>();

    public List<ClickTracking> getClickTrackingList() {
        return clickTrackingList;
    }

    public ClickThrough getClickThrough() {
        return clickThrough;
    }
}
