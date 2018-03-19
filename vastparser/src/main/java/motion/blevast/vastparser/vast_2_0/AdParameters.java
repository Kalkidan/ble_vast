package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Text;

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
