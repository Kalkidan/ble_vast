package com.blevast.motion.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class WeatherFragment extends Fragment {

    public static WeatherFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
