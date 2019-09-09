package com.example.tabslay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Fragment;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDb db = new MyDb(this);
        Catrgoy c1 = new Catrgoy(0,"Mains","Enjoy our meals");
        Catrgoy c2 = new Catrgoy(1,"Sides","Enjoy our salads");
        Catrgoy c3 = new Catrgoy(3,"Drinks","Enjoy our Drinks");
        db.insertCatrgoy(c1);
        db.insertCatrgoy(c2);
        db.insertCatrgoy(c3);
        ViewPager pager = findViewById(R.id.main_view_pager);
       MyFragAdapter adapter = new MyFragAdapter(this,getSupportFragmentManager());
       pager.setAdapter(adapter);
       TabLayout tab = findViewById(R.id.main_tab_layout);
       tab.setupWithViewPager(pager);

    }
}