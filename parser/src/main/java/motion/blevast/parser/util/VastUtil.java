package motion.blevast.parser.util;

import java.util.ArrayList;
import java.util.List;

import motion.blevast.parser.vastad.model.VastData;

public class VastUtil {

    private static List<VastData> vastDataList;
    private static int wrapperCountHit;

    static {
        vastDataList = new ArrayList<>();
        wrapperCountHit = 0;
    }

    public static void storeVastData(VastData vastData){
        vastDataList.add(wrapperCountHit++, vastData);
    }

    public static List<VastData> getVastDataList() {
        return vastDataList;
    }
}
