package com.blevast.motion.adapter;

import android.content.Context;

import com.blevast.motion.Constant;
import com.blevast.motion.R;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public CustomFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return context.getResources().getString(R.string.personal_detail_page);
            case 1:
                return context.getResources().getString(R.string.repo_page);
                default:
                    return super.getPageTitle(position);
        }

    }
}
