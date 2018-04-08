package motion.blevast.parser.vastad.model;

import android.os.Parcel;

public class Linear extends Creative{

    private String adParameters;
    private String duration;
    private int bitrate;
    private String apiFramework;
    private String delivery;
    private int height;
    private String mediaUrl;
    private int width;
    private String type;
    private boolean maintainAspectRatio;
    private boolean scalable;

    public Linear(){
        super();
    }
    protected Linear(Parcel in) {
        super(in);
    }

    public void setAdParameters(String adParameters) {
        this.adParameters = adParameters;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setBitrate(int bitrate) {
        this.bitrate = bitrate;
    }

    public void setApiFramework(String apiFramework) {
        this.apiFramework = apiFramework;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void isMaintainAspectRation(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
    }

    public void isScalable(boolean scalable) {
        this.scalable = scalable;
    }
}
