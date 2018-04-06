package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Text;

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
