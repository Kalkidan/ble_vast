package motion.blevast.parser.vastad.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Linear extends Creative{

    private String adParameters;
    private String duration;
    private List<Integer> bitrateList = new ArrayList<>();
    private List<String> apiFrameworkList = new ArrayList<>();
    private List<String> deliveryList = new ArrayList<>();
    private List<Integer> heightList = new ArrayList<>();
    private List<String> mediaUrlList = new ArrayList<>();
    private List<Integer> widthList = new ArrayList<>();
    private List<String> typeList = new ArrayList<>();
    private List<Boolean> maintainAspectRatioList = new ArrayList<>();
    private List<Boolean> scalableList = new ArrayList<>();

    public Linear(){
        super();
    }


    protected Linear(Parcel in) {
        adParameters = in.readString();
        duration = in.readString();
        apiFrameworkList = in.createStringArrayList();
        deliveryList = in.createStringArrayList();
        mediaUrlList = in.createStringArrayList();
        typeList = in.createStringArrayList();
        maintainAspectRatioList = (List<Boolean>) in.readSerializable();
        scalableList = (List<Boolean>) in.readSerializable();
    }

    public static final Creator<Linear> CREATOR = new Creator<Linear>() {
        @Override
        public Linear createFromParcel(Parcel in) {
            return new Linear(in);
        }

        @Override
        public Linear[] newArray(int size) {
            return new Linear[size];
        }
    };

    public void setAdParameters(String adParameters) {
        this.adParameters = adParameters;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setBitrate(int bitrate) {
        this.bitrateList.add(bitrate);
    }

    public void setApiFramework(String apiFramework) {
        this.apiFrameworkList.add(apiFramework);
    }

    public void setDelivery(String delivery) {
        this.deliveryList.add(delivery);
    }

    public void setHeight(int height) {
        this.heightList.add(height);
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrlList.add(mediaUrl);
    }

    public void setWidth(int width) {
        this.widthList.add(width);
    }

    public void setType(String type) {
        this.typeList.add(type);
    }

    public void isMaintainAspectRation(boolean maintainAspectRatio) {
        this.maintainAspectRatioList.add(maintainAspectRatio);
    }

    public void isScalable(boolean scalable) {
        this.scalableList.add(scalable);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(adParameters);
        parcel.writeString(duration);
        parcel.writeStringList(apiFrameworkList);
        parcel.writeStringList(deliveryList);
        parcel.writeStringList(mediaUrlList);
        parcel.writeStringList(typeList);
        parcel.writeSerializable((Serializable) maintainAspectRatioList);
        parcel.writeSerializable((Serializable) scalableList);
    }
}
