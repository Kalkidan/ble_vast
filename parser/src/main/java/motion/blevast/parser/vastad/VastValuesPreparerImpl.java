package motion.blevast.parser.vastad;

import android.text.TextUtils;
import android.util.Log;

import java.util.List;
import motion.blevast.parser.vast.Ad;
import motion.blevast.parser.vast.AdParameters;
import motion.blevast.parser.vast.AdSystem;
import motion.blevast.parser.vast.AdTitle;
import motion.blevast.parser.vast.Creative;
import motion.blevast.parser.vast.Creatives;
import motion.blevast.parser.vast.Description;
import motion.blevast.parser.vast.Duration;
import motion.blevast.parser.vast.Error;
import motion.blevast.parser.vast.Impression;
import motion.blevast.parser.vast.InLine;
import motion.blevast.parser.vast.MediaFile;
import motion.blevast.parser.vast.MediaFiles;
import motion.blevast.parser.vast.Status;
import motion.blevast.parser.vast.Survey;
import motion.blevast.parser.vast.VASTAdTagUri;
import motion.blevast.parser.vast.Wrapper;
import motion.blevast.parser.vastad.model.VastData;

/**
 * An implementation of the contract that is
 * defined by {@link VastValuesPreparer}
 */

public class VastValuesPreparerImpl implements VastValuesPreparer{

    private static final String TAG = VastValuesPreparerImpl.class.getSimpleName();

    String version;
    List<Ad> ads;
    Status status;

    //Response Object
    VastData vastCommon;
    motion.blevast.parser.vastad.model.Linear linear;

    /**
     * @param version
     * @param status
     * @param ad
     */
    public VastValuesPreparerImpl(String version, List<Ad> ad, Status status) {
        this.version = version;
        this.ads = ad;
        this.status = status;
        this.vastCommon = new VastData();
    }

    //Parse common info
    @Override
    public void parseVast() {

        Log.d(TAG, "Parsing Supplemental info");
        for(Ad currentAd: ads){
            InLine inLine = currentAd.getInLine();
            if(inLine != null){
                AdTitle adTitle = inLine.getAdTitle();
                if(adTitle != null){
                    String text = adTitle.getText();
                    if(!TextUtils.isEmpty(text)){
                        Log.d(TAG, "<AdTitle> \t" + text);
                        vastCommon.setAdTitle(text);
                    }
                }
                AdSystem adSystem = inLine.getAdSystem();
                if(adSystem != null){
                    String text = adSystem.getSourceAdServer();
                    if(!TextUtils.isEmpty(text)){
                        Log.d(TAG, "<AdSystem> \t" + text);
                        vastCommon.setAdSystem(text);
                    }
                }
                Description description = inLine.getDescription();
                if(description != null){
                    String text = description.getText();
                    if(!TextUtils.isEmpty(text)){
                        Log.d(TAG, "<Description> \t" + text);
                        vastCommon.setDescription(text);
                    }
                }
                Survey survey = inLine.getSurvey();
                if(survey != null){
                    String text = survey.getText();
                    if(!TextUtils.isEmpty(text)){
                        Log.d(TAG, "<Survey> \t" + text);
                        vastCommon.setSurvey(text);
                    }
                }
                Error error = inLine.getError();
                if(error != null){
                    String text = error.getText();
                    if(!TextUtils.isEmpty(text)){
                        Log.d(TAG, "<Error>" + text);
                        vastCommon.setError(text);
                    }
                }
                List<Impression> impressionList = inLine.getImpressionList();
                if(!impressionList.isEmpty()){
                    for(Impression impr : impressionList){
                        String text = impr.getText();
                        Log.d(TAG, "<Impression>" + text);
                        vastCommon.setImpression(text);
                    }
                }
                //Parse creative
                parseCreatives(inLine.getCreatives());
            } else {
                Wrapper wrapper = currentAd.getWrapper();
                if(wrapper != null){
                    AdSystem adSystem = wrapper.getAdSystem();
                    if(adSystem != null){
                        String text = adSystem.getSourceAdServer();
                        if(!TextUtils.isEmpty(text)){
                            Log.d(TAG, "<AdSystem>" + text);
                            vastCommon.setAdSystem(text);
                        }
                    }
                    Error error = wrapper.getError();
                    if(error != null){
                        String text = error.getText();
                        if(!TextUtils.isEmpty(text)){
                            Log.d(TAG, "<Error>" + text);
                            vastCommon.setError(text);
                        }
                    }
                    VASTAdTagUri vastAdTagUri = wrapper.getVastAdTagUri();
                    if(vastAdTagUri != null){
                        String text = vastAdTagUri.getText();
                        Log.d(TAG, "<VASTAdTagUri>" + text);
                        vastCommon.setVASTAdTagUri(text);
                    }
                    List<Impression> impressionList = wrapper.getImpressionList();
                    if(!impressionList.isEmpty()){
                        for(Impression impr : impressionList){
                            String text = impr.getText();
                            Log.d(TAG, "<Impression>" + text);
                            vastCommon.setImpression(text);
                        }
                    }
                    parseCreatives(wrapper.getCreatives());
                }
            }
        }
    }

    /**
     * @param creatives
     */
    private void parseCreatives(Creatives creatives) {

        Log.d(TAG, "Parsing creatives");
        List<motion.blevast.parser.vast.Creative> creativeList = creatives.getCreativeList();
        if(!creativeList.isEmpty()){
            for(motion.blevast.parser.vast.Creative creative : creativeList){
                parseCompanionAds(creative);
                parseLinearAd(creative);
                parseNonlinearAd(creative);
                parseSequence(creative);
            }
        }
    }

    private void parseSequence(Creative creative) {
        //TODO:: expansion
    }

    private void parseNonlinearAd(Creative creative) {
        //TODO:: expansion
    }

    private void parseCompanionAds(Creative creative) {
        //TODO:: expansion
    }

    private void parseLinearAd(Creative creative){
        motion.blevast.parser.vast.Linear linear = creative.getLinear();
        if(linear != null){
            AdParameters adParameters = linear.getAdParameters();
            if(adParameters != null){
                String adParameterText = adParameters.getText();
                Log.d(TAG, "<AdParameters> : \t" + adParameterText);
                this.linear.setAdParameters(adParameterText);
            }
            Duration duration = linear.getDuration();
            if(duration != null){
                String durationText = duration.getText();
                Log.d(TAG, "<Duration> :" + durationText);
                this.linear.setDuration(durationText);
            }
            MediaFiles mediaFiles = linear.getMediaFiles();
            if(mediaFiles != null && !mediaFiles.getMediaFileList().isEmpty()){
                for(MediaFile mediaFile : mediaFiles.getMediaFileList()){
                    //\\Bitrate
                    Log.d(TAG, "<Bitrate> :" + mediaFile.getBitrate());
                    this.linear.setBitrate(mediaFile.getBitrate());
                    //ApiFramework
                    Log.d(TAG, "<ApiFramework> :" + mediaFile.getApiFramework());
                    this.linear.setApiFramework(mediaFile.getApiFramework());
                    //Delivery
                    Log.d(TAG, "<Delivery> :" + mediaFile.getDelivery());
                    this.linear.setDelivery(mediaFile.getDelivery());
                    //Height
                    Log.d(TAG, "<Height> :" + mediaFile.getHeight());
                    this.linear.setHeight(mediaFile.getHeight());
                    //Id
                    Log.d(TAG, "<Id> :" + mediaFile.getId());
                    this.linear.setId(mediaFile.getId());
                    //Url
                    Log.d(TAG, "<URL> :" + mediaFile.getText());
                    this.linear.setMediaUrl(mediaFile.getText());
                    //Width
                    Log.d(TAG, "<Width> :" + mediaFile.getWidth());
                    this.linear.setWidth(mediaFile.getWidth());
                    //Type
                    Log.d(TAG, "<Type> :" + mediaFile.getType());
                    this.linear.setType(mediaFile.getType());
                    //Aspect ratio
                    Log.d(TAG, "<MaintainAspectRation> :" + mediaFile.isMaintainAspectRatio());
                    this.linear.isMaintainAspectRation(mediaFile.isMaintainAspectRatio());
                    //Scalability
                    Log.d(TAG, "<Scalable> :" + mediaFile.isScalable());
                    this.linear.isScalable(mediaFile.isScalable());
                }
            }
        }
    }
}
