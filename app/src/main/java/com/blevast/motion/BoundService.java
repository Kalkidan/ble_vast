package com.blevast.motion;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

/**
 * If our application defines a bound service and other
 * app can bind to it then the service is considered as a
 * foreground service.
 */

public class BoundService extends Service {


    //This is first called when it is needed
    //to be bound to
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * @param intent
     * @param flags
     * @param startId
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //This is mandatory to call this after starting so
        //the user is aware of what the service is doing in the
        //background
        //startForeground();

         //you can use stop self in combination of startId to
        return super.onStartCommand(intent, flags, startId);
    }

    //This is first called when
    //a service is first called
    //this is when it is started by a component
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
