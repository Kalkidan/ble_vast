package motion.blevast.parser.vast;

import java.util.List;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;

/**
 *
 *
 * Non linear ad Tag.
 */

public class NonLinear {

    @Attribute
    String id;

    @Attribute int width;

    @Attribute int height;

    @Attribute int expandedWidth;

    @Attribute int expandedHeight;

    @Attribute boolean scalable;

    @Attribute boolean maintainAspectRatio;

    @Tag
    private String apiFramework;

    @Tag private Duration duration;

    @Tag("NonLinear") private List<NonLinear> nonLinearList;

    @Tag private VideoClicks videoClicks;

    @Tag private MediaFiles mediaFiles;

    @Tag private AdParameters adParameters;

    @Attribute private String skipoffset;

    @Tag private StaticResource staticResource;

    public String getId() {
        return id;
    }

    public Duration getDuration() {
        return duration;
    }

    public VideoClicks getVideoClicks() {
        return videoClicks;
    }

    public MediaFiles getMediaFiles() {
        return mediaFiles;
    }

    public AdParameters getAdParameters() {
        return adParameters;
    }

    public String getSkipoffset() {
        return skipoffset;
    }


    public List<NonLinear> getNonLinearList() {
        return nonLinearList;
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

    public boolean isScalable() {
        return scalable;
    }

    public boolean isMaintainAspectRatio() {
        return maintainAspectRatio;
    }

    public String getApiFramework() {
        return apiFramework;
    }

    public StaticResource getStaticResource() {
        return staticResource;
    }
}
