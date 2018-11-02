package com.blevast.motion.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.blevast.motion.ui.BaseFragment;

import dagger.android.support.DaggerFragment;

public class WeatherFragment extends BaseFragment {

    public static WeatherFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
