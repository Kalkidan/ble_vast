package com.blevast.motion.ui.fragment;


import android.os.Bundle;
import android.widget.Toast;
import com.blevast.motion.Constant;
import com.blevast.motion.R;
import com.blevast.motion.databinding.AdPageBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.WeatherPageViewModel;

import javax.inject.Inject;

public class AdFragment extends BaseFragment<AdPageBinding, WeatherPageViewModel> {

    @Inject WeatherPageViewModel viewModel;

    public static AdFragment newInstance() {
        Bundle args = new Bundle();
        AdFragment fragment = new AdFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.ad_page;
    }

    @Override
    protected void attachObserver() {
        //
        viewModel.getResponse().observe(this, input -> {
            //update the viewModel
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
