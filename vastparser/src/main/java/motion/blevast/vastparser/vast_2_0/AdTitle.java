package motion.blevast.vastparser.vast_2_0;


import motion.blevast.vastparser.parser.Text;

/**
 * Ad title .
 */

public class AdTitle {

    //name of the ad
    @Text
    private String text;

    public String getText() {
        return text;
    }
}
