package com.example.tsc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.main_tab_layout);
        TabItem aboutItem = findViewById(R.id.tab_item_about);
        TabItem browseItem = findViewById(R.id.tab_item_browse);
        TabItem maintItem = findViewById(R.id.tab_item_maintenance);
        ViewPager viewPager = findViewById(R.id.main_view_pager);
    }
}