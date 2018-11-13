package com.blevast.motion.ui.fragment;

import com.blevast.motion.R;
import com.blevast.motion.databinding.PersonalDetailFragmentBinding;
import com.blevast.motion.ui.BaseFragment;
import com.blevast.motion.viewmodel.PersonalDetailViewModel;

import javax.inject.Inject;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

public class PersonalDetailPage extends BaseFragment<PersonalDetailFragmentBinding, PersonalDetailViewModel> {

    @Inject ViewModelProvider.Factory modelFactory;

    @Override
    protected int getFragmentLayout() {
        return R.layout.personal_detail_fragment;
    }

    @Override
    protected void attachObserver() {

    }

    @Override
    protected PersonalDetailViewModel getViewModel() {
        return ViewModelProviders.of(this, modelFactory).get(PersonalDetailViewModel.class);
    }
}
