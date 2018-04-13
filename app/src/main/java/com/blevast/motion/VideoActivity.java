package com.blevast.motion;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blevast.motion.databinding.VideoViewBinding;

/**
 * Created by kaltadesse on 4/11/18.
 *
 * This is the video activity that displat
 */

public class VideoActivity  extends BaseActivity<VideoViewBinding>{


    @Override
    public int inflateView() {
        return R.layout.video_view;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
