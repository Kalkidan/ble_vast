package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Attribute;
import motion.blevast.vastparser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Linear {

    @Tag
    private Duration duration;

    @Tag private TrackingEvents trackingEvents;

    @Tag private VideoClicks videoClicks;

    @Tag private MediaFiles mediaFiles;

    @Tag private AdParameters adParameters;

    @Attribute
    private String skipoffset;

    public Duration getDuration() {
        return duration;
    }

    public TrackingEvents getTrackingEvents() {
        return trackingEvents;
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
}
