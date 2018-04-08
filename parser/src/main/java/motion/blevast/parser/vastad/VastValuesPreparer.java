package motion.blevast.parser.vastad;


import motion.blevast.parser.vastad.model.VastData;

/**
 * A VAST values preparer contract
 */

public interface VastValuesPreparer {


    //Parses the supplemental info
    void parseVast();

    void parseRequirements();

    VastData getVastData();
}
