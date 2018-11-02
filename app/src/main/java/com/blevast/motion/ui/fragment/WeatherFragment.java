package com.blevast.motion.ui.fragment;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.widget.Toast;


import com.blevast.motion.Constant;
import com.blevast.motion.R;
import com.blevast.motion.databinding.WeatherPageFragmentBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.WeatherPageViewModel;

import javax.inject.Inject;

public class WeatherFragment extends BaseFragment<WeatherPageFragmentBinding, WeatherPageViewModel> {

    @Inject WeatherPageViewModel viewModel;

    public static WeatherFragment newInstance() {
        Bundle args = new Bundle();
        WeatherFragment fragment = new WeatherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.weather_page_fragment;
    }

    @Override
    protected void attachObserver() {
        //
        viewModel.getResponse().observe(this, input -> {
            //update the viewmodel
            Toast.makeText(getActivity(), "Observed", Toast.LENGTH_LONG).show();
        });
        //
        viewModel.setApiKey(Constant.API_KEY, "London, UK");
    }

    @Override
    protected WeatherPageViewModel getViewModel() {
        return viewModel;
    }


}
