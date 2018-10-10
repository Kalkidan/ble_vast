package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Linear {

    public static final String LINEAR = "Linear" ;
    public static final String SKIP_OFF_SET = "skipoffset";

    public static final String DURATION = "Duration";
    public static final String TRACKING_EVENTS = "TrackingEvents";
    public static final String VIDEO_CLICKS = "VideoClicks";
    public static final String MEDIA_FILES = "MediaFiles";
    public static final String AD_PARAMETERS = "AdParameters";

    //TODO: expansion
    public static final String ICONS = "Icons";

    @Tag private Duration duration;

    @Tag private TrackingEvents trackingEvents;

    @Tag private VideoClicks videoClicks;

    @Tag private MediaFiles mediaFiles;

    @Tag private AdParameters adParameters;

    @Attribute(value = "skipoffset") private String skipoffset;

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

    //

    public void setSkipoffset(String skipoffset) {
        this.skipoffset = skipoffset;
    }

    public void setTrackingEvents(TrackingEvents trackingEvents) {
        this.trackingEvents = trackingEvents;
    }

    public void setAdParameters(AdParameters adParameters) {
        this.adParameters = adParameters;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setMediaFiles(MediaFiles mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public void setVideoClicks(VideoClicks videoClicks) {
        this.videoClicks = videoClicks;
    }
}
