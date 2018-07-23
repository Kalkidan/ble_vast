package motion.blevast.com.barcodelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.barcode.BarcodeDetector;

/**
 * A bar code activity that will display a bar code scanner
 *
 */

public class BarcodeActivity extends AppCompatActivity {

    public static final String TAG= BarcodeActivity.class.getSimpleName();

    // permission request codes need to be < 256
    public static final int RC_HANDLE_CAMERA_PERM = 2;

    //Camera utilities
    BarcodeDetector barcodeDetector;
    CameraSource.Builder cameraSourceBuilder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
