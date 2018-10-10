package motion.blevast.parser.parser;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import motion.blevast.com.executor.util.Constants;

/**
 * Version class that will id the
 * type 2., 3., and 4.
 */
public class Version {

    //representation in <VAST>
    //Helps us out in setting the backward compat on target
    private static final String  VAST_2_ = "2.";
    private static final String  VAST_3_ = "3.";
    private static final String  VAST_4_ = "4.";

    //representation in project
    private static final int VAST_VERSIO_2 = 2;
    private static final int VAST_VERSIO_3 = 3;
    private static final int VAST_VERSIO_4 = 4;

    //A vast version definition
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({Constants.UNKNOWN, VAST_VERSIO_2, VAST_VERSIO_3, VAST_VERSIO_4})
    public @interface VastVersion{

    }

    /**
     * Returns the <VAST></VAST> Specific versions.
     */
    public static @VastVersion int getVastVersion(String vastVersion){

        if(vastVersion.startsWith(VAST_2_)){
            return VAST_VERSIO_2;
        } else if(vastVersion.startsWith(VAST_3_)){
            return VAST_VERSIO_3;
        } else if (vastVersion.startsWith(VAST_4_)){
            return VAST_VERSIO_4;
        } else {
            return Constants.UNKNOWN;
        }
    }

}
