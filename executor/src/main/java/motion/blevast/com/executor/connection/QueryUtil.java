package motion.blevast.com.executor.connection;

import android.net.Uri;

/**
 * Created by kaltadesse on 4/9/18.
 */

public class QueryUtil {
    /**
     *
     * @param baseUrl we need this for the registration part
     *                because we are registering device under
     *                a given application id.
     */

    public static Uri.Builder buildRegistrationUri(String baseUrl, String queryKey, String queryValue) {
        return Uri.parse(baseUrl).
                buildUpon().
                appendQueryParameter(queryKey, queryValue);

    }

    //http://localhost:8080/kal/length?input=16
}
