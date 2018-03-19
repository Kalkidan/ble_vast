package com.blevast.motion.barcode;

import android.view.SurfaceHolder;

import java.io.IOException;

import static com.blevast.motion.util.CameraUtil.launch;

/**
 * A {@link SurfaceCallback}
 *
 * A client may implement this interface to receive information about changes to
 * the surface. When used with a SurfaceView,
 * the Surface being held is only available between calls to surfaceCreated(SurfaceHolder)
 * and surfaceDestroyed(SurfaceHolder). The Callback is set with SurfaceHolder.addCallback method.
 */

public class SurfaceCallback implements SurfaceHolder.Callback {

    CameraSourcePreview.CamParameters camParameters;


    public SurfaceCallback(CameraSourcePreview.CamParameters camParameters) {
        this.camParameters = camParameters;
    }

    /**
     * @param surfaceHolder
     */
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

        /**
         *
         * Set the avilability of the surface
         */
        camParameters.setSurfaceAvailable(true);

        /**
         *
         * Pre check the parameters to start the camera
         */
        try {
            launch(camParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param width
     * @param format
     * @param height
     * @param surfaceHolder
     *
     */
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {
        camParameters.setSurfaceAvailable(false);
    }

    /**
     * @param surfaceHolder
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {}
}
