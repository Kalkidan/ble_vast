package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Tag;

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
