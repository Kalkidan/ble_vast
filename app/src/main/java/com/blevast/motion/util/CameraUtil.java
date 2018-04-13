package com.blevast.motion.util;

import android.os.Build;

public class CameraUtil {

    public static boolean isMarshmallow(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }
}
