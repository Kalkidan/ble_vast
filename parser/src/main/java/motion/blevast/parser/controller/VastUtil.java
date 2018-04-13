package motion.blevast.parser.controller;

import android.content.Context;

import motion.blevast.com.executor.connection.RequestType;
import motion.blevast.parser.VastResultListener;


/**
 * Created by kaltadesse on 4/11/18.
 */

public class VastUtil {


    public static void requestAd(String url, Context context, final VastResultListener vastResultListener){

        new VastProcessorImpl().getVast(url,
                    new motion.blevast.com.executor.connection.ConnectionParameter(RequestType.GET), context, vastResultListener);

    }
}
