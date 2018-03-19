package com.blevast.motion.barcode;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.google.android.gms.vision.barcode.Barcode;

/**
 * Graphic instance for rendering barcode position, size, and ID within an associated graphic
 * overlay view.
 */

public class BarcodeGraphic extends GraphicOverlay.Graphic{

    private int mId;

    private static final int COLOR_CHOICES[] = {
            Color.BLUE,
            Color.CYAN,
            Color.GREEN
    };


    private static int mCurrentColorIndex = 0;

    private Paint mRectPaint;
    private Paint mTextPaint;
    private volatile Barcode mBarcode;

    BarcodeRaw barcodeRaw;
    int scanCount;

    BarcodeGraphic(GraphicOverlay overlay) {
        super(overlay);

        /**
         *
         * TODO see if this static context can be changed to member variables
         */
        mCurrentColorIndex = (mCurrentColorIndex + 1) % COLOR_CHOICES.length;
        final int selectedColor = COLOR_CHOICES[mCurrentColorIndex];

        mRectPaint = new Paint();
        mRectPaint.setColor(selectedColor);
        mRectPaint.setStyle(Paint.Style.STROKE);
        mRectPaint.setStrokeWidth(4.0f);

        mTextPaint = new Paint();
        mTextPaint.setColor(selectedColor);
        mTextPaint.setTextSize(36.0f);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public Barcode getBarcode() {
        return mBarcode;
    }

    /**
     * Updates the barcode instance from the detection of the most recent frame.  Invalidates the
     * relevant portions of the overlay to trigger a redraw.
     */
    void updateItem(Barcode barcode) {
        mBarcode = barcode;
        postInvalidate();
    }

    /**
     * Draws the barcode annotations for position, size, and raw value on the supplied canvas.
     */
    @Override
    public void draw(Canvas canvas) {
        Barcode barcode = mBarcode;
        if (barcode == null) {
            return;

        } else {

            if(barcodeRaw != null && scanCount < 1) {
                barcodeRaw.onRawValueObtained(barcode.rawValue);
                ++scanCount;
            } else{
                return;
            }

        }
    }

    public void setBarcodeRaw(BarcodeRaw barcodeRaw) {
        this.barcodeRaw = barcodeRaw;
    }
}
