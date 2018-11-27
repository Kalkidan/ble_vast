package com.blevast.motion;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.blevast.motion.ui.StartFragmentCallback;
import com.blevast.motion.ui.activity.landing.LandingActivity;

import javax.inject.Inject;

/**
 * A stand alone class that will provide
 * navigation purposes within our app.
 */
public class NavigationController {

    private int containerId;
    private FragmentManager fragmentManager;

    @Inject NavigationController(LandingActivity landingActivity){
        this.fragmentManager = landingActivity.getSupportFragmentManager();
    }

    private StartFragmentCallback startFragmentCallback = fragmentName -> {

        Fragment fragment = null;
        switch (fragmentName){
            case Constant.MENU_PAGE_FRAGMENT:
                break;
            case Constant.SETTINGS_PAGE_FRAGMENT:
                break;
            case Constant.WEATHER_FRAGMENT:
                break;
            default:
                break;
        }

        FragmentTransaction transaction = null;
        if(fragment != null) {
            transaction = fragmentManager.
                    beginTransaction().
                    replace(containerId, fragment, fragmentName);

        }

        if(fragmentManager.findFragmentByTag(fragmentName) == null){
            transaction.addToBackStack(fragmentName).commit();
        } else {
            transaction.commit();
        }

        return 0;
    };

    public StartFragmentCallback getStartFragmentCallback() {
        return startFragmentCallback;
    }
}
