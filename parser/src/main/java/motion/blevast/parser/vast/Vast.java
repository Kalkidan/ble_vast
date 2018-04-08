package motion.blevast.parser.vast;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;
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

    @Attribute private String version;

    @Tag("Ad") private List<Ad> ad = new ArrayList<>();

    @Tag private Status status;

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
}
