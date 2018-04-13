package motion.blevast.com.executor.util;

import android.os.Build;

/**
 * Created by kaltadesse on 4/9/18.
 */

public class ApiUtil {

    public static boolean isAndroid_O(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }
}
