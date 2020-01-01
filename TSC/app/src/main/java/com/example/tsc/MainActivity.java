package com.example.tsc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CALL = 22;
    public static final int REQ_CALL_2 = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout tabLayout = findViewById(R.id.main_tab_layout);
        ViewPager viewPager = findViewById(R.id.main_view_pager);
        Fragment[] frags ={new AboutFragment(),new BrowseFragment(),new Add_frag()};
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), new String[]{"About", "Browse", "Add"},frags);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.drawable.about);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.drawable.search);
        Objects.requireNonNull(tabLayout.getTabAt(2)).setIcon(R.drawable.maint);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                ActivityCompat.requestPermissions(getParent(), new String[]{Manifest.permission.CALL_PHONE}, MainActivity.REQ_CALL);
            else {
                if (requestCode == MainActivity.REQ_CALL) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0599417048")));
                } else if (requestCode == MainActivity.REQ_CALL_2) {
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:082834978")));
                }
            }
        }
    }
}