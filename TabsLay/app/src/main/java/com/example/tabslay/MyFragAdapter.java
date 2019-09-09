package com.example.tabslay;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragAdapter extends FragmentPagerAdapter {

    private Context context;

    public MyFragAdapter(Context context, @NonNull FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // determines the fragment for each Tab
        MyDb db = new MyDb(context);
        ArrayList<Catrgoy> catrgoys = db.getAllCats();
        return new MyFragment(catrgoys.get(position));
    }

    @Override
    public int getCount() {
        //determine the number of tabs
        MyDb db = new MyDb(context);
        return (int) db.getCarsCount();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        MyDb db = new MyDb(context);
        ArrayList<Catrgoy> cats =db.getAllCats();
        return cats.get(position).getName();
    }

}
