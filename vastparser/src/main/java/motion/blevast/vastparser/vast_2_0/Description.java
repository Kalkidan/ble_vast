package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Text;

/**
 *
 *
 * Descritption tag.
 */

public class Description {

    //extensive description of the ad
    @Text
    private String description;

    public String getText() {
        return description;
    }
}
