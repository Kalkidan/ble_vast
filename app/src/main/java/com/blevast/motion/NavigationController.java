package com.blevast.motion;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.blevast.motion.ui.StartFragmentCallback;
import com.blevast.motion.ui.activity.landing.HighLightActivity;
import com.blevast.motion.ui.fragment.HighLightFragment;

import javax.inject.Inject;

/**
 * A stand alone class that will provide
 * navigation purposes within our app.
 */
public class NavigationController {

    private int containerId;
    private FragmentManager fragmentManager;

    private StartFragmentCallback startFragmentCallback = fragmentName -> {

        Fragment fragment = null;
        switch (fragmentName){
            case Constant.MENU_PAGE_FRAGMENT:
                break;
            case Constant.SETTINGS_PAGE_FRAGMENT:
                break;
            case Constant.WEATHER_FRAGMENT:
                fragment = HighLightFragment.newInstance();
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

    @Inject public NavigationController(HighLightActivity landingActivity){
        this.containerId = R.id.fragment_container;
        this.fragmentManager = landingActivity.getSupportFragmentManager();
    }

    public StartFragmentCallback getStartFragmentCallback() {
        return startFragmentCallback;
    }
}
