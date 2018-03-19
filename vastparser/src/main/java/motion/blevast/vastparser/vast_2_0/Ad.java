package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Attribute;
import motion.blevast.vastparser.parser.Tag;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * Top-level element, wrap search ad in the response
 *
 * <Ad id="">
 *     <InLine>{0,1}</InLine>
 *     <Wrapper>{0,1}</Wrapper>
 *     </Ad>
 */

public class Ad {

    @Attribute
    private String id;

    @Tag
    private InLine inLine;

    @Tag private Wrapper wrapper;

    public Wrapper getWrapper() {
        return wrapper;
    }

    public String getId() {
        return id;
    }

    public InLine getInLine() {
        return inLine;
    }
}
