package com.blevast.motion.util;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.DimenRes;
import android.support.v4.app.ActivityCompat;

import com.blevast.motion.barcode.CameraSourcePreview;

import java.io.IOException;



/**
 * A camera helper class.
 */

public class CameraUtil {

    public final static String TAG  = CameraUtil.class.getSimpleName();

    /**
     *
     * @param camParameters
     *
     */
    public static void launch(final CameraSourcePreview.CamParameters camParameters) throws IOException {
        if (camParameters.isStartRequested() & camParameters.isSurfaceAvailable()) {
            if (ActivityCompat.checkSelfPermission(camParameters.getCamContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //   ActivityCompat#requestPermissions
                //   here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            camParameters.getCameraSource().start(camParameters.getSurfaceView().getHolder());

            if (camParameters.getGraphicOverlay() != null) {
                com.google.android.gms.common.images.Size size = camParameters.getCameraSource().getPreviewSize();
                int min = Math.min(size.getWidth(), size.getHeight());
                int max = Math.max(size.getWidth(), size.getHeight());

                if (isPortraitMode(camParameters.getCamContext())) {
                    // Swap width and height sizes when in portrait, since it will be rotated by
                    // 90 degrees
                    camParameters.getGraphicOverlay().setCameraInfo(min, max, camParameters.getCameraSource().getCameraFacing());
                } else {
                    camParameters.getGraphicOverlay().setCameraInfo(max, min, camParameters.getCameraSource().getCameraFacing());
                }

                camParameters.getGraphicOverlay().clear();
            }

            camParameters.setStartRequested(false);
        }
    }

    /**
     *
     * @param context
     */
    public static boolean isPortraitMode(Context context) {

        int orientation = context.getResources().getConfiguration().orientation;

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return false;
        }
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            return true;
        }
        return false;
    }

    public static boolean isMarshmallow(){
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    public static  int dimen(@DimenRes int resId, Context context) {
        return  (int) context.getResources().getDimension(resId);
    }
}
