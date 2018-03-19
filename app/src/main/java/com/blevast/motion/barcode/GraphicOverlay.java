package com.blevast.motion.barcode;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 *
 *
 * Adopted from Google workshop codes.
 */

public class GraphicOverlay<T extends GraphicOverlay.Graphic> extends View {

    final Object lock = new Object();
    int previewWidth;
    float widthScaleFactor = 1.0f;
    int previewHeight;
    float heightScaleFactor = 1.0f;
    int facing = CameraSource.CAMERA_FACING_BACK;
    Set<T> graphics = new HashSet<>();

    /**
     * A base run class for all the graphics we will be holding
     * and interacting with
     */
    public static abstract class Graphic {
        private GraphicOverlay mOverlay;

        public Graphic(GraphicOverlay overlay) {
            mOverlay = overlay;
        }

        /**
         * Draw the graphic on the supplied canvas.  Drawing should use the following methods to
         * convert to view coordinates for the graphics that are drawn:
         * <ol>
         * <li>{@link Graphic#scaleX(float)} and {@link Graphic#scaleY(float)} adjust the size of
         * the supplied value from the preview scale to the view scale.</li>
         * <li>{@link Graphic#translateX(float)} and {@link Graphic#translateY(float)} adjust the
         * coordinate from the preview's coordinate system to the view coordinate system.</li>
         * </ol>
         *
         * @param canvas drawing canvas
         */
        public abstract void draw(Canvas canvas);

        /**
         * Adjusts a horizontal value of the supplied value from the preview scale to the view
         * scale.
         */
        public float scaleX(float horizontal) {
            return horizontal * mOverlay.widthScaleFactor;
        }

        /**
         * Adjusts a vertical value of the supplied value from the preview scale to the view scale.
         */
        public float scaleY(float vertical) {
            return vertical * mOverlay.heightScaleFactor;
        }

        /**
         * Adjusts the x coordinate from the preview's coordinate system to the view coordinate
         * system.
         */
        public float translateX(float x) {
            if (mOverlay.facing == CameraSource.CAMERA_FACING_FRONT) {
                return mOverlay.getWidth() - scaleX(x);
            } else {
                return scaleX(x);
            }
        }

        /**
         * Adjusts the y coordinate from the preview's coordinate system to the view coordinate
         * system.
         */
        public float translateY(float y) {
            return scaleY(y);
        }

        public void postInvalidate() {
            mOverlay.postInvalidate();
        }
    }

    /**
     * @param attrs
     * @param context
     *
     */
    public GraphicOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Removes all graphics from the overlay.
     */
    public void clear() {
        synchronized (lock) {
            graphics.clear();
        }
        postInvalidate();
    }

    /**
     * Adds a graphic to the overlay.
     *
     * @param graphic
     */
    public void add(T graphic) {
        synchronized (lock) {
            graphics.add(graphic);
        }
        postInvalidate();
    }

    /**
     * Removes a graphic from the overlay.
     *
     * @param graphic
     */
    public void remove(T graphic) {
        synchronized (lock) {
            graphics.remove(graphic);
        }
        postInvalidate();
    }

    /**
     * Returns a copy (as a list) of the set of all active graphics.
     *
     * @return list of all active graphics.
     */
    public List<T> getGraphics() {
        synchronized (lock) {
            return new Vector(graphics);
        }
    }

    /**
     * Returns the horizontal scale factor.
     */
    public float getWidthScaleFactor() {
        return widthScaleFactor;
    }

    /**
     * Returns the vertical scale factor.
     */
    public float getHeightScaleFactor() {
        return heightScaleFactor;
    }

    /**
     *
     * @param facing
     * @param previewHeight
     * @param previewWidth
     *
     * Sets the camera attributes for size and facing direction, which informs how to transform
     * image coordinates later.
     */
    public void setCameraInfo(int previewWidth, int previewHeight, int facing) {
        synchronized (lock) {
            this.previewWidth = previewWidth;
            this.previewHeight = previewHeight;
            this.facing = facing;
        }
        postInvalidate();
    }

    /**
     *
     * @param canvas
     * Draws the overlay with its associated graphic objects.
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        synchronized (lock) {
            if ((previewWidth != 0) && (previewHeight != 0)) {
                widthScaleFactor = (float) canvas.getWidth() / (float) previewWidth;
                heightScaleFactor = (float) canvas.getHeight() / (float) previewHeight;
            }

            for (Graphic graphic : graphics) {
                graphic.draw(canvas);
            }
        }
    }
}
