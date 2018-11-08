package com.blevast.motion;

import android.content.Context;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.annotation.Nullable;
import com.google.android.material.navigation.NavigationView;
import android.util.AttributeSet;

@BindingMethods(value =
        @BindingMethod(
                type = NavigationView.class,
                attribute = "onNavigationItemSelected",
                method = "setNavigationItemSelectedListener"
        )
)
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
