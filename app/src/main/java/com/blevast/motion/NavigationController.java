package com.blevast.motion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.blevast.motion.callback.StartFragmentCallback;
import com.blevast.motion.ui.fragment.WeatherFragment;

import javax.inject.Inject;

import motion.blevast.parser.vast.StaticResource;

/**
 * A stand alone class that will provide
 * navigation purposes within our app.
 */
public class NavigationController {

    private int containerId;
    private FragmentManager fragmentManager;

    private StartFragmentCallback startFragmentCallback = (String fragmentName) -> {

        Fragment fragment = null;
        switch (fragmentName){
            case Constant.MENU_PAGE_FRAGMENT:
                break;
            case Constant.SETTINGS_PAGE_FRAGMENT:
                break;
            case Constant.WEATHER_FRAGMENT:
                fragment = WeatherFragment.newInstance();
                break;
            default:
                break;
        }

        if(fragment != null) {
            fragmentManager.
                    beginTransaction().
                    replace(containerId, fragment, fragmentName).
                    //TODO:: there are times we dont wanna add to bkstck
                    addToBackStack(fragmentName).commit();

        }
    };

    public StartFragmentCallback getStartFragmentCallback() {
        return startFragmentCallback;
    }
}
