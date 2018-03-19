package motion.blevast.vastparser.vast_2_0;

import motion.blevast.vastparser.parser.Text;

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
