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
public class TrackingEvents {

    @Tag("Tracking") private List<Tracking> trackingList = new ArrayList<>();

    public List<Tracking> getTrackingList() {
        return trackingList;
    }

    public void setTrackingList(Tracking tracking) {
        this.trackingList.add(tracking);
    }
}
