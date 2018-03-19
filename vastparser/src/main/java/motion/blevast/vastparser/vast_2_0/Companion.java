package motion.blevast.vastparser.vast_2_0;


import java.util.List;

import motion.blevast.vastparser.parser.Attribute;
import motion.blevast.vastparser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Companion {

    @Attribute
    private String id;

    @Attribute private int width;

    @Attribute private int height;

    @Attribute private int expandedWidth;

    @Attribute private int expandedHeight;

    @Attribute private String apiFramework;

    @Tag
    private StaticResource staticResource;

    @Tag private TrackingEvents trackingEvents;

    @Tag private CompanionClickThrough companionClickThrough;

    @Tag private List<CompanionClickTracking> companionClickTracking;

    public String getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getExpandedWidth() {
        return expandedWidth;
    }

    public int getExpandedHeight() {
        return expandedHeight;
    }

    public String getApiFramework() {
        return apiFramework;
    }

    public StaticResource getStaticResource() {
        return staticResource;
    }

    public TrackingEvents getTrackingEvents() {
        return trackingEvents;
    }

    public CompanionClickThrough getCompanionClickThrough() {
        return companionClickThrough;
    }

    public List<CompanionClickTracking> getCompanionClickTracking() {
        return companionClickTracking;
    }
}
