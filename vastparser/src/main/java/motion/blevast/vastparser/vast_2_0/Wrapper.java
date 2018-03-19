package motion.blevast.vastparser.vast_2_0;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.vastparser.parser.Tag;

/**
 *
 *
 <Wrapper>
 <AdSystem version="">{1,1}</AdSystem>
 <VASTAdTagURI>{1,1}</VASTAdTagURI>
 <Error>{0,1}</Error>
 <Impression>{1,unbounded}</Impression>
 <Creatives>{1,1}</Creatives>
 <Extensions>{0,1}</Extensions>
 </Wrapper>
 *
 * A redirect to the secondary Ad Server.
 */

public class Wrapper {

    @Tag
    AdSystem adSystem;

    @Tag VASTAdTagUri vastAdTagUri;

    @Tag Error error;

    @Tag Extensions extensions;

    @Tag private Creatives creatives;

    @Tag("Impression") private List<Impression> impressionList = new ArrayList<>();

    public Creatives getCreatives() {
        return creatives;
    }

    public Extensions getExtensions() {
        return extensions;
    }


    public List<Impression> getImpressionList() {
        return impressionList;
    }

    public Error getError() {
        return error;
    }

    public AdSystem getAdSystem() {
        return adSystem;
    }

    public VASTAdTagUri getVastAdTagUri() {
        return vastAdTagUri;
    }
}
