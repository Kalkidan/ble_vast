package motion.blevast.parser.vast;

import motion.blevast.parser.parser.Attribute;
import motion.blevast.parser.parser.Text;

/**
 *
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 */
public class MediaFile {

    public static final String ID = "id";
    public static final String DELIVERY = "delivery";
    public static final String TYPE = "type";
    public static final String BITRATE = "bitrate";
    public static final String MIN_BITRATE = "minBitrate";
    public static final String MAX_BITRATE = "maxBitrate";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String SCALABLE = "scalable";
    public static final String MAINTAIN_ASPECT_RATIO = "mantainAspectRatio";
    public static final String CODEC = "codec";
    public static final String API_FRAMEWORK = "apiFramework";

    @Attribute private String id;

    /**
     * streaming, progressive
     */
    @Attribute private String delivery;

    @Attribute private String type;

    @Attribute private int bitrate;

    @Attribute private int width;

    @Attribute private int height;

    @Attribute private boolean scalable;

    @Attribute private boolean maintainAspectRatio;

    @Attribute private String apiFramework;

    @Attribute private String codec;

    @Attribute private String minBitrate;

    @Attribute private String maxBitrate;

    @Text private String text;

    public String getId() {
        return id;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getType() {
        return type;
    }

    public int getBitrate() {
        return bitrate;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isScalable() {
        return scalable;
    }

    public boolean isMaintainAspectRatio() {
        return maintainAspectRatio;
    }

    public String getApiFramework() {
        return apiFramework;
    }

    public String getMaxBitrate() {
        return maxBitrate;
    }

    public String getMinBitrate() {
        return minBitrate;
    }

    public String getText() {
        return text;
    }

    public String getCodec() {
        return codec;
    }

    public void setMaxBitrate(String maxBitrate) {
        this.maxBitrate = maxBitrate;
    }

    public void setMinBitrate(String minBitrate) {
        this.minBitrate = minBitrate;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setApiFramework(String apiFramework) {
        this.apiFramework = apiFramework;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
    }

    public void setScalable(boolean scalable) {
        this.scalable = scalable;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
