package com.blevast.motion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.blevast.motion.ui.StartFragmentCallback;
import com.blevast.motion.ui.activity.landing.HighLightActivity;
import com.blevast.motion.ui.fragment.AdFragment;

import javax.inject.Inject;

/**
 * A stand alone class that will provide
 * navigation purposes within our app.
 */
public class NavigationController {

    private int containerId;
    private FragmentManager fragmentManager;

    private StartFragmentCallback startFragmentCallback = (fragmentName) -> {

        Fragment fragment = null;
        switch (fragmentName){
            case Constant.MENU_PAGE_FRAGMENT:
                break;
            case Constant.SETTINGS_PAGE_FRAGMENT:
                break;
            case Constant.WEATHER_FRAGMENT:
                fragment = AdFragment.newInstance();
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

    @Inject public NavigationController(HighLightActivity landingActivity){
        this.containerId = R.id.fragment_container;
        this.fragmentManager = landingActivity.getSupportFragmentManager();
    }

    public StartFragmentCallback getStartFragmentCallback() {
        return startFragmentCallback;
    }
}
