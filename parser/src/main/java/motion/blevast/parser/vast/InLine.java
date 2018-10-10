package motion.blevast.parser.vast;


import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.parser.Tag;

/**
 *
 *
 * <InLine>
 <AdSystem version="">{1,1}</AdSystem>
 <AdTitle>{1,1}</AdTitle>
 <Description>{0,1}</Description>
 <Survey>{0,1}</Survey>
 <Error>{0,1}</Error>
 <Impression id="">{1,unbounded}</Impression>
 <Creatives>{1,1}</Creatives>
 <Extensions>{0,1}</Extensions>
 </InLine>
 * Idea adopted from.
 * <a herf = https://github.com/loopme/loopme-android-vpaid-sdk></a>
 *
 * Second-level element surrounding complete ad data for a single ad
 *
 */
public class InLine extends Wrapper{

    public static final String INLINE ="InLine" ;
    public static final String ADSYSTEM ="AdSystem" ;
    public static final String ADTITLE ="AdTitle" ;
    public static final String DESCRIPTION ="Description" ;
    public static final String SURVEY ="Survey" ;
    public static final String ERROR ="Error" ;
    public static final String IMPRESSION ="Impression" ;
    public static final String CREATIVES ="Creatives" ;
    public static final String EXTENSIONS ="Extensions" ;
    public static final String VAST_AD_TAG_URI = "VASTAdTagURI";

    //@Tag private AdSystem adSystem;

    @Tag AdTitle adTitle;

    @Tag Description description;

    @Tag Survey survey;

    // @Tag private Error error;

    @Tag Impression impression;

    @Tag("Impression") private List<Impression> impressionList = new ArrayList<>();

    //@Tag private Creatives creatives;

    //@Tag private Extensions extensions;

    public AdSystem getAdSystem() {
        return adSystem;
    }

    public Error getError() {
        return error;
    }

    public Creatives getCreatives() {
        return creatives;
    }

    public List<Impression> getImpressionList() {
        return impressionList;
    }

    public AdTitle getAdTitle() {
        return adTitle;
    }

    public Description getDescription() {
        return description;
    }

    public Survey getSurvey() {
        return survey;
    }

    public Impression getImpression() {
        return impression;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    //This is tricky so we will have to make sure that
    //we add all the impression to a list as it comes one by one
    //There is no array formation in VAST Xml for <Impression> as in <Impressions><Impression/><Impression/><Impression/></Impressions>
    //So we need to parse it as it comes in.
    public void setImpression(Impression impression) {
        this.impressionList.add(impression);
    }

    public void setAdSystem(AdSystem adSystem) {
        this.adSystem = adSystem;
    }

    public void setAdTitle(AdTitle adTitle) {
        this.adTitle = adTitle;
    }

    public void setCreatives(Creatives creatives) {
        this.creatives = creatives;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public void setImpressionList(List<Impression> impressionList) {
        this.impressionList = impressionList;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
}
