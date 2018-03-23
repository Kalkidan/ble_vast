package com.blevast.motion;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * A common base activity run for
 * all {@link android.app.Activity}
 */

abstract class BaseActivity<VIEWBINDING extends ViewDataBinding> extends AppCompatActivity{

    //Inflates the view in child classes
    public abstract @LayoutRes int inflateView();

    //When we need a common view binding
    private VIEWBINDING viewbinding;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Inflate each view
        viewbinding = DataBindingUtil.setContentView(this, inflateView());
    }
}
