package com.blevast.motion;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blevast.motion.databinding.ActivityMainBinding;

import motion.blevast.com.executor.connection.RequestType;
import motion.blevast.parser.controller.VastProcessorImpl;

/**
 * A landing page for vast parser.
 *
 *
 */

public class LandingActivity extends BaseActivity<ActivityMainBinding>{

    @Override
    public int inflateView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new VastProcessorImpl().getVast("http://demo.tremorvideo.com/proddev/vast/vast_wrapper_linear_1.xml",
                new motion.blevast.com.executor.connection.ConnectionParameter(RequestType.GET), this);
    }
}


        //"https://video-tags-staging.vrvm.com/2232/shadow_vast.xml"