package motion.blevast.parser.vastad.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Vast common attributes
 */

public class VastData implements Parcelable {

    //Version
    private String version;

    //Common Vast Attributes
    private String adTitle;
    private String adSystem;
    private String description;
    private String survey;
    private String error;
    private String VASTAdTagUri;

    //Impressions
    private List<String> listOfImpression = new ArrayList<>();
    private Linear linear;
    private NonLinear nonLinear;
    private CompanionAd companionAd;
    private boolean isWrapper;
    private HashMap<String, Map<String,String>> trackingEventMap;
    private String report;

    //Wrapper hit count
    int wrapperHitCount;

    public VastData(String version){
        this.version = version;
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
    public void writeToParcel(Parcel parcel, int flags) {
        //
        parcel.writeString(this.version);
        parcel.writeString(this.adSystem);
        parcel.writeString(this.adTitle);
        parcel.writeString(this.description);
        parcel.writeString(this.error);
        parcel.writeString(this.report);
        parcel.writeString(this.survey);
        parcel.writeString(this.VASTAdTagUri);
        parcel.writeStringList(this.listOfImpression);
        parcel.writeByte((byte) (this.isWrapper ? 1 : 0));
        parcel.writeParcelable(this.linear, flags);
        parcel.writeParcelable(this.nonLinear, flags);
        parcel.writeParcelable(this.companionAd, flags);
        parcel.writeInt(this.wrapperHitCount);
        parcel.writeSerializable(trackingEventMap);
    }

    protected VastData(Parcel parcel) {
        //
        this.version = parcel.readString();
        this.adSystem = parcel.readString();
        this.adTitle = parcel.readString();
        this.description = parcel.readString();
        this.error = parcel.readString();
        this.report = parcel.readString();
        this.survey = parcel.readString();
        this.VASTAdTagUri = parcel.readString();
        this.listOfImpression = parcel.createStringArrayList();
        this.isWrapper = parcel.readByte()!= 0;
        this.linear = parcel.readParcelable(Linear.class.getClassLoader());
        this.nonLinear = parcel.readParcelable(NonLinear.class.getClassLoader());
        this.companionAd = parcel.readParcelable(CompanionAd.class.getClassLoader());
        this.wrapperHitCount = parcel.readInt();
        this.trackingEventMap = (HashMap<String, Map<String, String>>) parcel.readSerializable();
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

    public void setTrackingEventMap(HashMap<String,Map<String,String>> trackingEventMap) {
        this.trackingEventMap = trackingEventMap;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setWrapperHitCount(int wrapperHitCount) {
        this.wrapperHitCount = wrapperHitCount;
    }

    public Map<String, Map<String, String>> getTrackingEventMap() {
        return trackingEventMap;
    }

    public String getReport() {
        return report;
    }

    public CompanionAd getCompanionAd() {
        return companionAd;
    }

    public int getWrapperHitCount() {
        return wrapperHitCount;
    }

    public Linear getLinear() {
        return linear;
    }

    public List<String> getListOfImpression() {
        return listOfImpression;
    }

    public NonLinear getNonLinear() {
        return nonLinear;
    }

    public String getAdSystem() {
        return adSystem;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public String getDescription() {
        return description;
    }

    public String getError() {
        return error;
    }

    public String getSurvey() {
        return survey;
    }

    public String getVersion() {
        return version;
    }
}
