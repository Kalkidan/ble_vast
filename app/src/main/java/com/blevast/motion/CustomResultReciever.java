package com.blevast.motion;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

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
     */
    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        //Take care of your results here
    }
}
