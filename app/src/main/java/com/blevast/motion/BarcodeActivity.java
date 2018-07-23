package com.blevast.motion;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.widget.Toast;

import com.blevast.motion.databinding.BarcodeActivityViewBinding;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import java.io.IOException;

/**
 * This is a barcode activity to scan a url.
 * This is a simplified source of the google's camera project
 */

public class BarcodeActivity extends AppCompatActivity{

    // permission request codes need to be < 256
    public static final int RC_HANDLE_CAMERA_PERM = 2;

    public static final String TAG = BarcodeActivity.class.getSimpleName();

    //camera activities and views
    BarcodeDetector barcodeDetector;
    CameraSource.Builder cameraSourceBuilder;
    BarcodeActivityViewBinding barcodeActivityViewBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Sets the content view
        barcodeActivityViewBinding = DataBindingUtil.setContentView(this, R.layout.barcode_activity_view);
        //Request permission
        //requestCameraPermissionOrStartQrActivity();
        prepareCameraSource();

    }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults
     * @see #requestPermissions(String[], int)
     */
   @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != RC_HANDLE_CAMERA_PERM) {
            Log.d(TAG, "Got unexpected permission result: " + requestCode);
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            prepareCameraSource();
            return;
        }

        Log.e(TAG, "Permission not granted: results len = " + grantResults.length +
                " Result code = " + (grantResults.length > 0 ? grantResults[0] : "(empty)"));

        DialogInterface.OnClickListener ok = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + getPackageName()));
                startActivity(intent);
            }
        };

        DialogInterface.OnClickListener cancel = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                recreate();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Camera Permission Not Granted!")
                .setMessage("No Camera permissions, Want to Go to Settings and manage your Permissions?")
                .setPositiveButton("OK", ok)
                .setNegativeButton("Cancel", cancel)
                .setCancelable(false)
                .show();
    }

    private void prepareCameraSource() {

        //prep the barcode detector
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE)
                .build();

        //prep the camera source
        cameraSourceBuilder = new CameraSource
                .Builder(this, barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .setRequestedFps(15.0f);

        //obtain the camera source
        final CameraSource  cameraSource = cameraSourceBuilder.build();

        //Get the camera view
        barcodeActivityViewBinding.cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(),
                        android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    //Request permission
                    ActivityCompat.requestPermissions(BarcodeActivity.this,
                            new String[]{Manifest.permission.CAMERA}, RC_HANDLE_CAMERA_PERM);
                    return;
                }
                try {
                    cameraSource.start( barcodeActivityViewBinding.cameraView.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            /**
             * @param i
             * @param i1
             * @param i2
             * @param surfaceHolder
             */
            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) { }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                cameraSource.stop();

            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrcodes = detections.getDetectedItems();
                if(qrcodes.size() != 0) {

                    //Get out the worker thread and post the result
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Captured" + qrcodes.valueAt(0).displayValue,
                                    Toast.LENGTH_LONG).show();
                            //Kill the activity after reading the text
                            finish();
                        }
                    });
                }
            }
        });
    }
}
