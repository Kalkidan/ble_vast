package com.blevast.motion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.blevast.motion.databinding.ActivityMainBinding;

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

    @Override
    public int inflateView() {
        return 0;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Request Ad
        VastUtil.requestAd("http://demo.tremorvideo.com/proddev/vast/vast_wrapper_linear_1.xml",
                getApplicationContext(), this);
    }

    /**
     * @param vastData this is the load that comes in after parsing the
     *                 xml
     */
    @Override
    public void onVastDataProcessed(List<VastData> vastData) {

    }
}

//"https://video-tags-staging.vrvm.com/2232/shadow_vast.xml"