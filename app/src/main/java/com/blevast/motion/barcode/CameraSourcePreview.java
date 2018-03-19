package com.blevast.motion.barcode;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.ViewGroup;

import com.blevast.motion.util.CameraUtil;
import com.google.android.gms.common.images.Size;
import java.io.IOException;

import static com.blevast.motion.util.CameraUtil.launch;

/**
 * A camera source preview.
 *
 * Adopted from google resource codes
 */

public class CameraSourcePreview extends ViewGroup {

    private static final String TAG = CameraSourcePreview.class.getSimpleName();

    CamParameters camParameters;
    /**
     *
     * @param attrs
     * @param context
     */
    public CameraSourcePreview(Context context, AttributeSet attrs) {
        super(context, attrs);

        /**
         *
         * @see #initiateView(Context)
         */
        initiateView(context);
    }

    /**
     *
     * @param context
     *
     * This block will initiate the view
     */
    private void initiateView(Context context) {

        camParameters = CamParameters.build();
        camParameters.setSurfaceAvailable(false).
                setStartRequested(false).
                setContext(context).
                setSurfaceView(new SurfaceView(context)).
                setSurfaceCallback();

        addView(camParameters.surfaceView);

    }

    /**
     *
     * This block will start with the {@link CameraSource}
     */
    public void start(CameraSource cameraSource){

        if(camParameters.cameraSource  == null){
            stop();
        }

        camParameters.setCameraSource(cameraSource);

        if (camParameters.cameraSource != null) {
            camParameters.setStartRequested(true);

            try {
                launch(camParameters);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param cameraSource
     * @param overlay a
     *
     */
    public void start(CameraSource cameraSource, GraphicOverlay overlay) throws IOException, SecurityException {

        /**
         *
         * Sets the graphic overlay
         */
        camParameters.setGraphicOverlay(overlay);
        start(cameraSource);
    }

    /**
     * Release the resources
     */
    public void release() {
        if (camParameters.cameraSource  != null) {
            camParameters.cameraSource .release();
            camParameters.setCameraSource(null);
        }
    }

    /**
     *
     * Stops the camera source
     */
    public void stop() {
        if (camParameters.cameraSource != null) {
            camParameters.cameraSource .stop();
        }
    }

    /**
     * @param layoutChanged
     * @param bottom
     * @param left
     * @param right
     * @param top
     *
     *
     */
    @Override
    protected void onLayout(boolean layoutChanged, int left, int top, int right, int bottom) {

        int width = 320;
        int height = 240;

        if (camParameters.cameraSource != null) {
            Size size = camParameters.cameraSource.getPreviewSize();
            if (size != null) {
                width = size.getWidth();
                height = size.getHeight();
            }
        }

        // Swap width and height sizes when in portrait, since it will be rotated 90 degrees
        if (CameraUtil.isPortraitMode(camParameters.context)) {
            int tmp = width;
            //noinspection SuspiciousNameCombination
            width = height;
            height = tmp;
        }

        final int layoutWidth = right - left;
        final int layoutHeight = bottom - top;

        // Computes height and width for potentially doing fit width.
        int childWidth = layoutWidth;
        int childHeight = (int)(((float) layoutWidth / (float) width) * height);

        // If height is too tall using fit width, does fit height instead.
        if (childHeight > layoutHeight) {
            childHeight = layoutHeight;
            childWidth = (int)(((float) layoutHeight / (float) height) * width);
        }

        for (int i = 0; i < getChildCount(); ++i) {
            getChildAt(i).layout(0, 0, childWidth, childHeight);
        }

        try {
            launch(camParameters);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static final class CamParameters{

        Context context;
        SurfaceView surfaceView;
        boolean startRequested;
        boolean surfaceAvailable;
        CameraSource cameraSource;
        GraphicOverlay graphicOverlay;
        SurfaceCallback surfaceCallback;


        public static CamParameters build(){
            return new CamParameters();
        }

        /**
         *
         * @param startRequested
         */
        public CamParameters setStartRequested(boolean startRequested) {
            this.startRequested = startRequested;
            return this;
        }

        /**
         *
         * @param surfaceAvailable
         */
        CamParameters setSurfaceAvailable(boolean surfaceAvailable) {
            this.surfaceAvailable = surfaceAvailable;
            return this;
        }

        /**
         *
         * @param cameraSource
         */
        CamParameters setCameraSource(CameraSource cameraSource) {
            this.cameraSource = cameraSource;
            return this;
        }

        /**
         *
         * @param context
         */
        CamParameters setContext(Context context) {
            this.context = context;
            return this;
        }

        /**
         *
         * @param graphicOverlay
         */
        CamParameters setGraphicOverlay(GraphicOverlay graphicOverlay) {
            this.graphicOverlay = graphicOverlay;
            return this;
        }

        /**
         *
         * @param surfaceView
         */
        CamParameters setSurfaceView(SurfaceView surfaceView) {
            this.surfaceView = surfaceView;
            return this;
        }

        CamParameters setSurfaceCallback() {
            surfaceView.getHolder().addCallback(new SurfaceCallback(this));
            return this;
        }

        public GraphicOverlay getGraphicOverlay() {
            return graphicOverlay;
        }

        public Context getCamContext() {
            return context;
        }

        public CameraSource getCameraSource() {
            return cameraSource;
        }

        public SurfaceView getSurfaceView() {
            return surfaceView;
        }

        public SurfaceCallback getSurfaceCallback() {
            return surfaceCallback;
        }

        public boolean isStartRequested() {
            return startRequested;
        }

        public boolean isSurfaceAvailable() {
            return surfaceAvailable;
        }
    }
}
