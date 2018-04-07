package motion.blevast.parser.vastad;

import java.util.List;

import mf.org.apache.xerces.impl.xs.identity.ValueStore;
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

    public VastValuesPreparer geVastValuesPreparer(){
        return builder.vastValuesPreparer;
    }

    public static class Builder{

        //Outer level vars
        String version;
        List<Ad> ads;
        Status status;
        VastValuesPreparer vastValuesPreparer;

        /**
         * @param ad
         * @param status
         * @param version
         */
        public Builder(String version, List<Ad> ad, Status status) {
            this.version = version;
            this.ads = ad;
            this.status = status;
            this.vastValuesPreparer = new VastValuesPreparerImpl(version, ad, status);
        }

        public VastParser build(VastParser vastParser){
            return new VastParser(this);
        }
    }
}
