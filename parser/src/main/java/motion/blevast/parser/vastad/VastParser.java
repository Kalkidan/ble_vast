package motion.blevast.parser.vastad;

import java.util.List;
import motion.blevast.parser.vast.Ad;
import motion.blevast.parser.vast.Status;

/**
 * A {@link VastParser}
 */

public class VastParser {

    private Builder builder;

    public VastParser(Builder builder) {
        this.builder = builder;
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

        public VastParser build(VastParser vastParser){
            return new VastParser(this);
        }

        //Parse Ad based on Type
        public Builder parseVast(){
            vastValuesPreparer.parseVast();
            return this;
        }

        public Builder parseRequirements(){
            vastValuesPreparer.parseRequirements();
            return this;
        }
    }
}
