package motion.blevast.parser.parser;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import motion.blevast.parser.vast.Ad;
import motion.blevast.parser.vast.AdParameters;
import motion.blevast.parser.vast.AdSystem;
import motion.blevast.parser.vast.AdTitle;
import motion.blevast.parser.vast.ClickThrough;
import motion.blevast.parser.vast.ClickTracking;
import motion.blevast.parser.vast.Companion;
import motion.blevast.parser.vast.Creative;
import motion.blevast.parser.vast.Creatives;
import motion.blevast.parser.vast.Description;
import motion.blevast.parser.vast.Duration;
import motion.blevast.parser.vast.Error;
import motion.blevast.parser.vast.Extensions;
import motion.blevast.parser.vast.Impression;
import motion.blevast.parser.vast.InLine;
import motion.blevast.parser.vast.Linear;
import motion.blevast.parser.vast.MediaFile;
import motion.blevast.parser.vast.MediaFiles;
import motion.blevast.parser.vast.NonLinear;
import motion.blevast.parser.vast.Survey;
import motion.blevast.parser.vast.Tracking;
import motion.blevast.parser.vast.TrackingEvents;
import motion.blevast.parser.vast.VASTAdTagUri;
import motion.blevast.parser.vast.Vast;
import motion.blevast.parser.vast.VideoClicks;
import motion.blevast.parser.vast.Wrapper;

/**
 * A simple xml parser for the purpose of
 * displaying the parsed incoming <VAST></VAST>
 *
 * This is an alternative for the reflection method.
 */
public class XmlVastPullParser {

    private XmlPullParserFactory xmlPullParserFactory;

    public XmlVastPullParser() { }

    public Vast parse(String xmlRawString) throws XmlPullParserException, IOException {
        //
        xmlPullParserFactory = XmlPullParserFactory.newInstance();
        //set this to true, just so we know it is name space aware.
        //xmlPullParserFactory.setNamespaceAware(true);
        XmlPullParser parser = xmlPullParserFactory.newPullParser();
        parser.setInput(new StringReader(xmlRawString));
        return parseVast(parser);
        //
    }

    /**
     * @param parser
     */
    private Vast parseVast(XmlPullParser parser) throws IOException, XmlPullParserException {
        Vast vast = null;
        parser.next();

        //parse the version
        if(Vast.VAST.equals(parser.getName())){
            vast = new Vast();
            //Sets the VAST version
            vast.setVastVersion(Version.getVastVersion(parser.getAttributeValue(null, Vast.VERSION)));
            /**
             * Adopted from https://developer.android.com/training/basics/network-ops/xml#java
             * on parsing xml tutorial
             */
            while (parser.next() != XmlPullParser.END_TAG) {
                if (parser.getEventType() != XmlPullParser.START_TAG) {
                    continue;
                }

                switch (parser.getName()){
                    case Vast.AD:
                        //parses the <AD> section of the <VAST>
                        vast.setAd(parseAdSection(parser));
                        break;
                        default:
                            //We need to skip on tags we don't really care about
                            skip(parser);
                            break;
                }

                //look for the <AD> section of the <VAST>
            }

        }

        return vast;

    }

    private Ad parseAdSection(XmlPullParser parser) throws IOException, XmlPullParserException {
        Ad ad = new Ad();
        //Parse the id of the ad
        ad.setId(parser.getAttributeValue(null, "id"));

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            //
            switch (parser.getName()){
                case InLine.INLINE:
                     ad.setInLine(parseInline(parser));
                    break;
                case Wrapper.WRAPPER:
                    ad.setWrapper(parseInline(parser));
                    break;
            }
        }

        return ad;
    }

    private VASTAdTagUri parseVastAdTagUri(XmlPullParser parser) throws IOException, XmlPullParserException {
        VASTAdTagUri vastAdTagUri = new VASTAdTagUri();
        vastAdTagUri.setText(readText(parser));
        return vastAdTagUri;
    }

    private InLine parseInline(XmlPullParser parser) throws IOException, XmlPullParserException {
        //
        InLine inLine = new InLine();

        //
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            //
            String tagName = parser.getName();
            switch (tagName){
                //
                case InLine.ADSYSTEM:
                    //
                    inLine.setAdSystem(parseAdSystem(parser));
                    break;
                case InLine.ADTITLE:
                    //
                    inLine.setAdTitle(parseAdTitle(parser));
                    break;
                case InLine.CREATIVES:
                    //
                    inLine.setCreatives(parseCreatives(parser));
                    break;
                case InLine.DESCRIPTION:
                    //
                    inLine.setDescription(parseDescription(parser));
                    break;
                case InLine.ERROR:
                    //
                    inLine.setError(parseError(parser));
                    break;
                case InLine.EXTENSIONS:
                    //
                    inLine.setExtensions(parseExtensions(parser));
                    break;
                case InLine.IMPRESSION:
                    //
                    inLine.setImpression(parseImpressions(parser));
                    break;
                case InLine.SURVEY:
                    //
                    inLine.setSurvey(parseSurvey(parser));
                    break;
                case InLine.VAST_AD_TAG_URI:
                    inLine.setVastAdTagUri(parseVastAdTagUri(parser));
                    //
                    default:break;
            }
            //
        }

        return inLine;
    }

    private Creatives parseCreatives(XmlPullParser parser) throws IOException, XmlPullParserException {
        Creatives creatives = new Creatives();
        creatives.setCreativeList(parseCreative(parser));
        return creatives;
    }

    private Creative parseCreative(XmlPullParser parser) throws IOException, XmlPullParserException {
        //
        Creative creative = new Creative();

        //
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            //parse attrs of a creative
            creative.setId(parser.getAttributeValue(null, Creative.ID));
            creative.setAdID(parser.getAttributeValue(null, Creative.AD_ID));
            creative.setApiFramework(parser.getAttributeValue(null, Creative.API_FRAMEWORK));
            creative.setSequence(parser.getAttributeValue(null, Creative.SEQUENCE));

                //Found a creative
                if (Creative.CREATIVE.equals(parser.getName())) {

                    while (parser.next() != XmlPullParser.END_TAG) {
                        if (parser.getEventType() != XmlPullParser.START_TAG) {
                            continue;
                        }

                        String tagName = parser.getName();
                        //For now we are only parsing Linear media file.
                        switch (tagName) {
                            case Linear.LINEAR:
                                creative.setLinear(parseLinear(parser));
                                break;
                            case NonLinear.NON_LINEAR:
                            case Companion.COMPANION:
                                break;
                        }
                    }

                } else {
                    // we skip
                    skip(parser);
                }
        }
        return creative;
    }

    private Linear parseLinear(XmlPullParser parser) throws IOException, XmlPullParserException {
        Linear linear = new Linear();
        //set linear attrs
        linear.setSkipoffset(parser.getAttributeValue(null, Linear.SKIP_OFF_SET));

        //
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            //
            String tagName = parser.getName();
            //
            switch (tagName){

                case Linear.AD_PARAMETERS:
                    linear.setAdParameters(parseAdParameters(parser));
                    break;
                case Linear.DURATION:
                    linear.setDuration(parseDuration(parser));
                    break;
                case Linear.ICONS:
                    break;
                case Linear.MEDIA_FILES:
                    linear.setMediaFiles(parseMediaFiles(parser));
                    break;
                case Linear.TRACKING_EVENTS:
                    linear.setTrackingEvents(parseTrackingEvents(parser));
                    break;
                case Linear.VIDEO_CLICKS:
                    linear.setVideoClicks(parseVideoClicks(parser));
                    break;
                    default: skip(parser); break;

            }
        }

        return linear;
    }

    /**
     * @param parser
     */
    private VideoClicks parseVideoClicks(XmlPullParser parser) throws IOException, XmlPullParserException {
        VideoClicks videoClicks = new VideoClicks();
        //
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            //
            String tagName = parser.getName();
            //
            switch (tagName) {
                //
                case VideoClicks.CLICK_THROUGH:
                    videoClicks.setClickThrough(parseClickThrough(parser));
                    break;
                    //
                case VideoClicks.CLICK_TRACKING:
                    videoClicks.setClickTrackingList(parseClickTracking(parser));
                    break;
                    //
                case VideoClicks.CUSTOM_CLICK:
                    break;
                    default:break;
            }

        }
        return videoClicks;
    }

    /**
     * @param parser
     */
    private ClickTracking parseClickTracking(XmlPullParser parser) throws IOException, XmlPullParserException {
        ClickTracking clickTracking = new ClickTracking();
        clickTracking.setText(readText(parser));
        return clickTracking;
    }

    private ClickThrough parseClickThrough(XmlPullParser parser) throws IOException, XmlPullParserException {
        ClickThrough clickThrough = new ClickThrough();
        clickThrough.setText(readText(parser));
        return clickThrough;
    }

    private TrackingEvents parseTrackingEvents(XmlPullParser parser) throws IOException, XmlPullParserException {
        //
        TrackingEvents trackingEvent = new TrackingEvents();

        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String tagName = parser.getName();
            if(Tracking.TRACKIMG.equals(tagName)) {
                trackingEvent.setTrackingList(parseTrackingEvent(parser));
            } else {
                skip(parser);
            }
        }
        return trackingEvent;
    }

    private Tracking parseTrackingEvent(XmlPullParser parser) throws IOException, XmlPullParserException {
        //parse tracking events
        Tracking tracking = new Tracking();
        tracking.setEvent(parser.getAttributeValue(null, Tracking.EVENT));
        tracking.setText(readText(parser));
        return tracking;
    }

    private MediaFiles parseMediaFiles(XmlPullParser parser) throws IOException, XmlPullParserException {
        MediaFiles mediaFiles = new MediaFiles();
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }

            String tagName = parser.getName();
            if (MediaFiles.MEDIA_FILE.equals(tagName)) {
                mediaFiles.setMediaFileList(parseMediaFile(parser));
            }
        }
        return mediaFiles;
    }

    /**
     * @param parser this method parser the media file
     */
    private MediaFile parseMediaFile(XmlPullParser parser) throws IOException, XmlPullParserException {
        MediaFile mediaFile = new MediaFile();
        mediaFile.setText(readText(parser));
        mediaFile.setApiFramework(parser.getAttributeValue(null, MediaFile.API_FRAMEWORK));
        mediaFile.setBitrate(parseInt(parser.getAttributeValue(null, MediaFile.BITRATE)));
        mediaFile.setCodec(parser.getAttributeValue(null, MediaFile.CODEC));
        mediaFile.setDelivery(parser.getAttributeValue(null, MediaFile.DELIVERY));
        mediaFile.setHeight(parseInt(parser.getAttributeValue(null, MediaFile.HEIGHT)));
        mediaFile.setId(parser.getAttributeValue(null, MediaFile.ID));
        mediaFile.setMaintainAspectRatio(parseBoolean(parser.getAttributeValue(null, MediaFile.MAINTAIN_ASPECT_RATIO)));
        //mediaFile.setMaxBitrate(parser.getAttributeValue(null, MediaFile.MAX_BITRATE));
        //mediaFile.setMinBitrate(parser.getAttributeValue(null, MediaFile.MIN_BITRATE));
        mediaFile.setScalable(parseBoolean(parser.getAttributeValue(null, MediaFile.SCALABLE)));
        mediaFile.setType(parser.getAttributeValue(null, MediaFile.TYPE));
        mediaFile.setWidth(parseInt(parser.getAttributeValue(null, MediaFile.WIDTH)));

        return mediaFile;
    }

    private boolean parseBoolean(String value){
        try {
            return Boolean.parseBoolean(value);
        } catch (NumberFormatException ex) {

        }
        return false;
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {

        }
        return -1;
    }

    private Duration parseDuration(XmlPullParser parser) throws IOException, XmlPullParserException {
        Duration duration = new Duration();
        duration.setText(readText(parser));
        return duration;
    }

    private AdParameters parseAdParameters(XmlPullParser parser) throws IOException, XmlPullParserException {
        AdParameters adParameters = new AdParameters();
        adParameters.setText(readText(parser));
        return adParameters;
    }

    private Description parseDescription(XmlPullParser parser) throws IOException, XmlPullParserException {
        Description description = new Description();
        description.setDescription(readText(parser));
        return description;
    }

    private Error parseError(XmlPullParser parser) throws IOException, XmlPullParserException {
        Error error = new Error();
        error.setText(readText(parser));
        return error;
    }

    private Extensions parseExtensions(XmlPullParser parser) {
        Extensions extensions = new Extensions();
        return extensions;
    }

    private Impression parseImpressions(XmlPullParser parser) throws IOException, XmlPullParserException {
        Impression impression = new Impression();
        impression.setText(readText(parser));
        return impression;
    }

    private Survey parseSurvey(XmlPullParser parser) throws IOException, XmlPullParserException {
        Survey survey = new Survey();
        survey.setSurvey(readText(parser));
        return survey;
    }

    private AdTitle parseAdTitle(XmlPullParser parser) throws IOException, XmlPullParserException {
        AdTitle adTitle = new AdTitle();
        adTitle.setText(readText(parser));
        return adTitle;
    }

    private AdSystem parseAdSystem(XmlPullParser parser) throws IOException, XmlPullParserException {
        AdSystem adSystem = new AdSystem();
        //parse the attribute
        adSystem.setVersion(parser.getAttributeValue(null, "version"));
        adSystem.setSourceAdServer(readText(parser));
        return adSystem;
    }

    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
