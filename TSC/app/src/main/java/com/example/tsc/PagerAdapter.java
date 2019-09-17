package com.example.tsc;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

// Note: Android FragmentPagerAdapter is used when you have a limited number of tabs that want to swipe through. If you have a dynamic tabs then you need to use Android FragmentStatePagerAdapter.

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    // constructor is use to communicate between this class and MainActivity.java.
    public PagerAdapter(@NonNull FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    // is where you will initialize the fragments for Android Tablayout. In this Android Tablayout example you will have 3 Android Fragments (Chat, Status and Calls).
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:

            case 2:

            default:
                return null;
        }
    }

    // Will return the number of tabs that will appear in Android Tablayout.
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
