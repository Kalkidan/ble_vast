package motion.blevast.parser.vastad;

import java.util.List;

import motion.blevast.parser.vast.Ad;
import motion.blevast.parser.vast.Creatives;
import motion.blevast.parser.vast.Status;

/**
 * An implementation of the contract that is
 * defined by {@link VastValuesPreparer}
 */

public class VastValuesPreparerImpl implements VastValuesPreparer{

    String version;
    List<Ad> ads;
    Status status;

    /**
     * @param version
     * @param status
     * @param ad
     */
    public VastValuesPreparerImpl(String version, List<Ad> ad, Status status) {
        this.version = version;
        this.ads = ad;
        this.status = status;
    }

    @Override
    public void parseSupplementalInfo() {

    }

    @Override
    public void prepCommonLinearAttributes(Creatives creatives) {

    }

    @Override
    public void prepCommonNonLinearAttributes(Creatives creatives) {

    }

    @Override
    public void prepCommonCompanionAttributes(Creatives creatives) {

    }
}
