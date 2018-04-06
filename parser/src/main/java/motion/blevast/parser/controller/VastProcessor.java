package motion.blevast.parser.controller;

import android.content.Context;

import motion.blevast.com.executor.connection.ConnectionParameter;

/**
 * A Vast processor contract
 */

public interface VastProcessor {
    boolean getVast(String destinationUrl, ConnectionParameter connectionParameter, Context context);
    void processVast(String vastResponse, Context context);
}
