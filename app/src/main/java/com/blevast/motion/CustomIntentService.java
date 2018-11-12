package com.blevast.motion;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.util.Log;

import androidx.annotation.Nullable;

public class CustomIntentService extends IntentService {

    private static final String TAG = CustomIntentService.class.getSimpleName();

    public CustomIntentService() {
        super("Custom Intent Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Log.d(TAG, "started the intent service ");

        ResultReceiver rec = intent.getParcelableExtra("receiver");
        String val = intent.getStringExtra("have this");
        Bundle bundle = new Bundle();
        bundle.putString("Value", val);
        rec.send(Activity.RESULT_OK, bundle);
    }
}
