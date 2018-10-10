package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class Tracking {

    public static final String EVENT = "event" ;
    public static final String OFF_SET = "offset" ;
    public static final String TRACKIMG = "Tracking" ;

    @Attribute private String event;

    @Attribute private String offset;

    @Text private String text;

    public String getEvent() {
        return event;
    }

    public String getOffset() {
        return offset;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
