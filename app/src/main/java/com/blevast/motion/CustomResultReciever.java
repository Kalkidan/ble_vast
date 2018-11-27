package com.blevast.motion;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * {@link ResultReceiver} is a simple wrapping implementation
 * around the {@link android.os.Binder} class that facilitates the
 * Inter Process Communication.
 */
public class CustomResultReciever extends ResultReceiver {


    private Receiver receiver;

    /**
     * Create a new ResultReceive to receive results.  Your
     * {@link #onReceiveResult} method will be called from the thread running
     * <var>handler</var> if given, or from an arbitrary thread if null.
     *
     * @param handler
     */
    public CustomResultReciever(Handler handler) {
        super(handler);
    }

    /**
     * @param receiver
     */
    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    /**
     * Communication interface back to the UI layer
     */
    public interface Receiver {
        /**
         * @param resultCode
         * @param resultData
         */
        void onReceiveResult(int resultCode, Bundle resultData);
    }

    /**
     * @param resultCode
     * @param resultData
     *
     * This is the callback for IPC. Using handlers.
     */
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        //Take care of your results here
        if(receiver != null){
            //This will be called out to the service
            //creating component
            //A component must run to let know the process
            //to keep running the system and be alive...or
            //if the process is gone the whole thing is gone.
            receiver.onReceiveResult(resultCode, resultData);
        }
    }
}
