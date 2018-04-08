package motion.blevast.parser.vastad.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Vast common attributes
 */

public class VastData implements Parcelable {

    private String version;

    //Common Vast Attributes
    private String adTitle;
    private String adSystem;
    private String description;
    private String survey;
    private String error;
    private String VASTAdTagUri;
    private List<String> listOfImpression = new ArrayList<>();
    private Linear linear;
    private NonLinear nonLinear;
    private CompanionAd companionAd;
    private boolean isWrapper;

    public VastData(String version){
        this.version = version;
    }

    protected VastData(Parcel in) {
    }

    public static final Creator<VastData> CREATOR = new Creator<VastData>() {
        @Override
        public VastData createFromParcel(Parcel in) {
            return new VastData(in);
        }

        @Override
        public VastData[] newArray(int size) {
            return new VastData[size];
        }
    };

    public VastData() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public void setAdSystem(String adSystem) {
        this.adSystem = adSystem;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setVASTAdTagUri(String VASTAdTagUri) {
        this.VASTAdTagUri = VASTAdTagUri;
    }

    public void setImpression(String impression) {
        this.listOfImpression.add(impression);
    }

    public void setCompanionAd(CompanionAd companionAd) {
        this.companionAd = companionAd;
    }

    public void setLinear(Linear linear) {
        this.linear = linear;
    }

    public void setNonLinear(NonLinear nonLinear) {
        this.nonLinear = nonLinear;
    }

    public void setWrapper(boolean wrapper) {
        this.isWrapper = wrapper;
    }

    public boolean isWrapper() {
        return isWrapper;
    }

    public String getVASTAdTagUri() {
        return VASTAdTagUri;
    }
}
