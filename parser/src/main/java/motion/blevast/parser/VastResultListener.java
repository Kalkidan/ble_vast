package motion.blevast.parser;


import java.util.List;

import motion.blevast.parser.vastad.model.VastData;

public interface VastResultListener {

    void onVastDataProcessed(List<VastData> vastData);
}
