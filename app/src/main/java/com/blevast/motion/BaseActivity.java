package com.blevast.motion;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.blevast.motion.callback.StartFragmentCallback;
import com.blevast.motion.viewmodel.DefaultViewModel;

import dagger.android.support.DaggerAppCompatActivity;

/**
 * A common base activity run for
 * all {@link android.app.Activity}
 */

abstract class BaseActivity<VIEWBINDING extends ViewDataBinding, VIEW_MODEL extends ViewModel> extends DaggerAppCompatActivity {

    //Inflates the view in child classes
    public abstract @LayoutRes int inflateView();

    //Get the view model
    public abstract VIEW_MODEL getViewModel();

    //When we need a common view binding
    private VIEWBINDING viewbinding;

    protected StartFragmentCallback start = (String fragmentName) -> {

        switch (fragmentName) {
            case Constant.MENU_PAGE_FRAGMENT:
                break;
            case Constant.SETTINGS_PAGE_FRAGMENT:
                break;
            default:
                break;
        }
    };

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //
        super.onCreate(savedInstanceState);
        //Inflate each activity's view
        viewbinding = DataBindingUtil.setContentView(this, inflateView());
        //
        //viewbinding.setVariable(BR.vm, getViewModel() != null ? getViewModel() : defaultViewModel());
    }


    //Just default it and load the default
    //This will come handy if we have to retry
    //loading
    private   DefaultViewModel defaultViewModel(){
        return ViewModelProviders.of(this).get(DefaultViewModel.class);
    }
    //
    public VIEWBINDING getViewbinding() {
        return viewbinding;
    }
}
