package motion.blevast.parser.vastad;

import java.util.List;
import motion.blevast.parser.vast.Ad;
import motion.blevast.parser.vast.Status;
import motion.blevast.parser.vastad.model.VastData;

/**
 * A {@link VastParser}
 */

public class VastParser {

    private Builder builder;

    public VastParser(Builder builder) {
        this.builder = builder;
    }

    public VastData getVastData(){
        return builder.vastValuesPreparer.getVastData();
    }

    public static class Builder{

        VastValuesPreparer vastValuesPreparer;

        /**
         * @param ad
         * @param status
         * @param version
         */
        public Builder(String version, List<Ad> ad, Status status) {
            this.vastValuesPreparer = new VastValuesPreparerImpl(version, ad, status);
        }

        public VastParser build(){
            return new VastParser(this);
        }

        //Parse Ad based on Type
        public Builder parseVast(){
            vastValuesPreparer.parseVast();
            return this;
        }

        //TODO:: expansion with xpath
        public Builder parseBasicRequirements(){
            vastValuesPreparer.parseRequirements();
            return this;
        }
    }
}
