package com.blevast.motion;

import android.content.Context;
import android.databinding.BindingMethod;
import android.databinding.BindingMethods;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.util.AttributeSet;

@BindingMethods(value =
        @BindingMethod(type = NavigationView.class, attribute = "onNavigationItemSelected", method = "setNavigationItemSelectedListener"))
public class CustomNavView extends NavigationView {
    public CustomNavView(Context context) {
        super(context);
    }

    public CustomNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomNavView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener listener) {
        super.setNavigationItemSelectedListener(listener);
    }
}
