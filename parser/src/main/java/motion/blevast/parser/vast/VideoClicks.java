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
public class VideoClicks {

    public static final String VIDEO_CLICKS = "VideoClicks" ;
    public static final String CLICK_THROUGH = "ClickThrough";
    public static final String CLICK_TRACKING = "ClickTracking";
    public static final String CUSTOM_CLICK = "CustomClick";
    @Tag("ClickThrough") private ClickThrough clickThrough;

    @Tag("ClickTracking") private List<ClickTracking> clickTrackingList = new ArrayList<>();

    public List<ClickTracking> getClickTrackingList() {
        return clickTrackingList;
    }

    public ClickThrough getClickThrough() {
        return clickThrough;
    }

    public void setClickThrough(ClickThrough clickThrough) {
        this.clickThrough = clickThrough;
    }

    public void setClickTrackingList(ClickTracking clickTracking) {
        this.clickTrackingList.add(clickTracking);
    }
}
