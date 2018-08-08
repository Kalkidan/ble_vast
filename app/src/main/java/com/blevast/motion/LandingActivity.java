package com.blevast.motion;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.blevast.motion.databinding.ActivityMainBinding;

import java.io.Serializable;
import java.util.List;

import motion.blevast.parser.VastResultListener;
import motion.blevast.parser.controller.VastUtil;
import motion.blevast.parser.vastad.model.VastData;


/**
 * A landing page for vast parser.
 *
 * This can be a UI-less object jst to start
 * another activity.
 *
 * We will use this as a transitional {@link android.app.Activity}
 */

public class LandingActivity extends BaseActivity<ActivityMainBinding> implements VastResultListener {


    public static final String TAG = LandingActivity.class.getSimpleName();
    public  static final String EXTRA_VAST_LOAD = "Extra_Vast_Load";

    @Override
    public int inflateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Making a Network Call to get VAST Response");
       /* VastUtil.requestAd("http://demo.tremorvideo.com/proddev/vast/vast_wrapper_linear_1.xml",
                getApplicationContext(), this);*/
    }

    /**
     * @param vastData this is the load that comes in after parsing the
     *                 xml
     */
    @Override
    public void onVastDataProcessed(List<VastData> vastData) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(EXTRA_VAST_LOAD, (Serializable) vastData);
        this.startActivity(intent);
    }
}

//"https://video-tags-staging.vrvm.com/2232/shadow_vast.xml"