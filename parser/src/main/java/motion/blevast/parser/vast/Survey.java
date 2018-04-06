package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Text;

/**
 * Survey Tag.
 */

public class Survey {

    @Text
    private String survey;
    public String getText() {
        return survey;
    }
}
