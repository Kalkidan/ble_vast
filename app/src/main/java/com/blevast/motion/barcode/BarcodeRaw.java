package com.blevast.motion.barcode;

/**
 * A contract that will define a raw value for bar code.
 */

public interface BarcodeRaw {
    void onRawValueObtained(String rawValue);
}
