package motion.blevast.parser.vast;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;
import motion.blevast.parser.parser.Version;
import motion.blevast.parser.vastad.VastParser;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * XML document format describing an ad to be displayed in, over, or around a
 * Video Player or a Wrapper pointing to a downstream VAST document to be requested.
 *
 * <VAST version="">
 *     <Ad id="">{0,unbounded}</Ad>
 *     </VAST>
 *
 */
public class Vast {

    //TODO:: pay attention if we have to add /ERRor for VAst 3.0

    /**
     *
     * This project was done in two ways
     * 1 - Reflection + {@link org.xmlpull.v1.XmlPullParser}
     * 2 - pure {@link org.xmlpull.v1.XmlPullParser}
     */
    public static final String VAST = "VAST";
    public static final String VERSION = "version";
    public static final String AD = "Ad";

    //
    @Version.VastVersion int vastVersion;

    @Attribute private String version;

    @Tag("Ad") private List<Ad> ad = new ArrayList<>();

    @Tag private Status status;

    public void setVastVersion(int vastVersion) {
        this.vastVersion = vastVersion;
    }

    public  @Version.VastVersion int getVastVersion() {
        return vastVersion;
    }

    public String getVersion() {
        return version;
    }

    public List<Ad> getAd() {
        return ad;
    }

    public Status getStatus() {
        return status;
    }

    public VastParser.Builder getBuilder(){
        return new VastParser.Builder(version, ad, status);
    }

    public void setAd(Ad ad) {
        this.ad.add(ad);
    }
}
