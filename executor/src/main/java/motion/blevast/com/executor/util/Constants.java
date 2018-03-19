package motion.blevast.com.executor.util;

/**
 * A constant holder instance .
 */

public class Constants {

    public static final int POOL_SIZE = 10;

    public static final int MAX_POOL_SIZE = 15;

    public static final int TIME_OUT = 30;

    public static final int  DEFAULT_TIMEOUT_API_REQUEST_SECONDS = 30;

    public static final int NO_FLAG = 0;

    public static final String BACKUP_DEVICE_ID = "BACKUP_DEVICE_ID";
    public static final String NO_AD = "NO_AD_SPECS";
    public static final int ONE_SECOND= 1000;

    public static String VAST_MODEL = "VAST_MODEL";
    public static String STRING_XML = "STRING_XML";

    public static final String VIDEO_PLAYER_TIMER_FRORMAT = "%02d:%02d:%02d";

    public static int BARCODE_READER_CODE = 100;
    public static int URL_FROM_HISTORY_CODE = 101;
    public static String BARCODE_STRING = "BARCODE_STRING";

    //permission request codes need to be < 256
    public static final int RC_HANDLE_CAMERA_PERM = 2;


    public static final int USE_DEFAULT_TIMEOUT = -1;

    public static final String AD_SELECTOR_LOAD="AD_SELECTOR_LOAD";
    public static final String CREATIVE = "CREATIVE";

    /**
     * The 'environmentVars' object contains a reference, 'slot', to the HTML element
     * on the page in which the ad is to be rendered. The ad unit essentially gets
     * control of that element. See the following code example on how to set this value.
     * The 'environmentVars' object would contain a reference, 'videoSlot', to the
     * video element on the page where the ad video is to be rendered and a
     * boolean flag, ‘videoSlotCanAutoPlay’ indicating whether the ‘videoSlot’ is
     * capable of autoplaying. It is upto the player implementation to decide what
     * video element to pass to
     */
    public static final String ENVIRONMENT_VARS = "{ " +
            "slot: document.getElementById('verve-slot'), " +
            "videoSlot: document.getElementById('verve-videoslot'), " +
            "videoSlotCanAutoPlay: true }";

    public static CharSequence INJECT_HEAD_FOR_JS_BRIDGE = "<head>\n<script type=\"text/javascript\" " +
            "src=\"file:///android_asset/verve_vpaid_wrapper.js\"></script>\n" +
            "<script type=\"text/javascript\" " +
            "src=\"file:///android_asset/vast_parser.js\"></script>";

    public static final String HTML_SOURCE_FILE = "verve_vpaid_html_body.html";
    public static final String VPAID_CREATIVE_URL_STRING = "[VPAID_CREATIVE_URL]";
}
