package motion.blevast.parser.vast;


import motion.blevast.parser.parser.Text;

/**
 * Ad title .
 */

public class AdTitle {

    //name of the ad
    @Text private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
