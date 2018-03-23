package motion.blevast.vastparser.controller;

import motion.blevast.com.executor.connection.ConnectionParameter;

/**
 * Created by kaltadesse on 3/23/18.
 */

public interface VastProcessor {
    boolean getVast(String destinationUrl, ConnectionParameter connectionParameter);
}
