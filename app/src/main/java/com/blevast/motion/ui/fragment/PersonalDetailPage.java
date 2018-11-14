package com.blevast.motion.ui.fragment;

import com.blevast.motion.R;
import com.blevast.motion.databinding.PersonalDetailFragmentBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.HomePageViewModel;
import javax.inject.Inject;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class PersonalDetailPage extends BaseFragment<PersonalDetailFragmentBinding, HomePageViewModel> {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.personal_detail_fragment;
    }

    @Override
    protected void attachObserver() {
        getViewModel().getUserDataResponse().observe(this, user -> {
            getViewModel().setUserObservableData(user.getBody());
        });

    }

    @Override
    protected HomePageViewModel getViewModel() {
        return ViewModelProviders.of(getActivity(), modelFactory).get(HomePageViewModel.class);
    }

    @Override
    protected void createViewModle() {
    }

}
