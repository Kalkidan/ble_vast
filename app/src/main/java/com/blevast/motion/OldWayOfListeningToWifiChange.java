package com.blevast.motion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.util.Log;

public class OldWayOfListeningToWifiChange extends BroadcastReceiver {

    private static final String TAG = OldWayOfListeningToWifiChange.class.getSimpleName();

    /**
     * @param context
     * @param intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = null;
        if (intent != null)
            action = intent.getAction();

        if (!TextUtils.isEmpty(action) && action.equals(ConnectivityManager.CONNECTIVITY_ACTION)) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = cm.getActiveNetworkInfo();

            if (info != null && info.getType() == ConnectivityManager.TYPE_WIFI && info.isConnected()) {
                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                String ssid = wifiInfo.getSSID();
                String name = wifiInfo.getMacAddress();

                Log.d(TAG, ssid);
            }
        } else if (intent.getAction().equalsIgnoreCase(WifiManager.WIFI_STATE_CHANGED_ACTION)) {
            int wifiState = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            if (wifiState == WifiManager.WIFI_STATE_DISABLED) {
                Log.e(TAG, "OPPPs...Wifi Gone!!!");
            }

        }
    }
}
