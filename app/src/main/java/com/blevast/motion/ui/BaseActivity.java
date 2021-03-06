package com.blevast.motion.ui;

import androidx.lifecycle.ViewModel;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import android.os.Bundle;
import android.widget.ImageSwitcher;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.blevast.motion.BR;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * This is a base run for all the activities in the project
 * with databinding inflating the nav drawer
 *
 */

public abstract class BaseActivity<V extends ViewDataBinding, M extends ViewModel> extends DaggerAppCompatActivity {

    //A common binding
    protected V binding;
    //
    protected abstract @LayoutRes int getActivityView();
    //
    protected abstract M getViewModel();

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getActivityView());
        binding.setVariable(BR.vm, getViewModel());
        binding.setVariable(BR.cb, this);
    }
    //
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
