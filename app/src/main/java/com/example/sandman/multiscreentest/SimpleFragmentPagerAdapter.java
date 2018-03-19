package com.example.sandman.multiscreentest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sandman on 2/4/2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[] { "Numbers", "Family", "Colors","Prases" };

    public SimpleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new NumbersFragment();
        }else if (position == 1){
            return new FamilyFragment();
        }else if (position == 2){
            return new ColorsFragment();
        }else {
            return new PrasesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
