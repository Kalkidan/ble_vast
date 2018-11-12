package com.blevast.motion;

import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import motion.blevast.com.executor.v26.SchedulerHelper;

public class ExperimentalActivity extends AppCompatActivity {


    OldWayOfListeningToWifiChange br = new OldWayOfListeningToWifiChange();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Create the intent filter for it
        //TODO:: Assume that the broadcast receiver is not registered in the XML.
        IntentFilter inf = new IntentFilter();

        //Add the action we need here dynamically
        inf.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        inf.addAction("android.net.wifi.STATE_CHANGE");
        inf.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        /************OR******************/
        inf.addAction("kal.tadesse.custom.action.LOOK_FOR_KAL");

        //TODO:: one way to register it, feel free to change it
        registerReceiver(br, inf);

        //TODO:: this is one way of scheduling a job
        SchedulerHelper.scheduleJob(getApplicationContext(), BackgroundDataJobService.class, 2000, 0);

    }

    @Override
    protected void onStop() {
        super.onStop();

        //Make sure you always un register the broadcast receiver
        unregisterReceiver(br);
    }
}
