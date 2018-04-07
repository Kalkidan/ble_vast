package motion.blevast.parser.vastad;

import motion.blevast.parser.vast.Creatives;

/**
 * A VAST values preparer contract
 */

public interface VastValuesPreparer {


    //Parses the supplemental info
    void parseSupplementalInfo();

    /**
     * Prepare the common linear attributes
     * @param creatives
     */
    void prepCommonLinearAttributes(Creatives creatives);

    /**
     * Prepare the common non linear attributes
     * @param creatives
     */
    void prepCommonNonLinearAttributes(Creatives creatives);

    /**
     * Prepare the common companion attributes
     * @param creatives
     */
    void prepCommonCompanionAttributes(Creatives creatives);
}
