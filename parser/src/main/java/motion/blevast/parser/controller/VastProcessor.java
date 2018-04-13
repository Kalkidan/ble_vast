package motion.blevast.parser.controller;

import android.content.Context;

import motion.blevast.com.executor.connection.ConnectionParameter;
import motion.blevast.parser.VastResultListener;

/**
 * A Vast processor contract
 */

public interface VastProcessor {
    boolean getVast(String destinationUrl, ConnectionParameter connectionParameter, Context context, VastResultListener vastResultListener);
    void processVast(String vastResponse, Context context, VastResultListener vastResultListener);
}
