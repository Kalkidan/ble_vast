package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * Data to be passed into the companion ads
 */

public class AdParameters {

    @Text
    private String text;

    public String getText() {
        return text;
    }

}
