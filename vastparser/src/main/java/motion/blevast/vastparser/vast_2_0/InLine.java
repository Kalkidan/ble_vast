package motion.blevast.vastparser.vast_2_0;


import java.util.ArrayList;
import java.util.List;

import motion.blevast.vastparser.parser.Tag;

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
public class InLine {

    @Tag
    private AdSystem adSystem;

    @Tag AdTitle adTitle;

    @Tag Description description;

    @Tag Survey survey;

    @Tag private Error error;

    @Tag Impression impression;

    @Tag("Impression") private List<Impression> impressionList = new ArrayList<>();

    @Tag private Creatives creatives;

    @Tag private Extensions extensions;

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
}
