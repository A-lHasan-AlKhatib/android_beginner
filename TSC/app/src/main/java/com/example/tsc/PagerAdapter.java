package com.example.tsc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

// Note: Android FragmentPagerAdapter is used when you have a limited number of tabs that want to swipe through. If you have a dynamic tabs then you need to use Android FragmentStatePagerAdapter.

public class PagerAdapter extends FragmentPagerAdapter {
    private String[] numOfTabs;
    private Fragment[] frags;
    private int[] icons;

    // constructor is use to communicate between this class and MainActivity.java.
    public PagerAdapter(@NonNull FragmentManager fm, String[] tabs,Fragment[] frags) {
        super(fm);
        this.numOfTabs = tabs;
        this.frags=frags;
    }

    // is where you will initialize the fragments for Android Tablayout.
    @NonNull
    @Override
    public Fragment getItem(int position) {
        for (int i = 0; i <frags.length ; i++) {
            if (position == i)
                return frags[i];
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return numOfTabs[position];
    }

    // Will return the number of tabs that will appear in Android Tablayout.
    @Override
    public int getCount() {
        return numOfTabs.length;
    }
}
