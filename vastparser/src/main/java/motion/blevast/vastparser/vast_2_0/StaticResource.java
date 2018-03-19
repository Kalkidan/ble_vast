package motion.blevast.vastparser.vast_2_0;


import motion.blevast.vastparser.parser.Attribute;
import motion.blevast.vastparser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class StaticResource {

    @Attribute
    private String creativeType;

    @Text
    private String text;

    public String getText() {
        return text;
    }

    public String getCreativeType() {
        return creativeType;
    }
}
