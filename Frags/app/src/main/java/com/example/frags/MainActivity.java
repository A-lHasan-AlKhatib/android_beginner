package com.example.frags;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = findViewById(R.id.btn_1);
        Button btn2 = findViewById(R.id.btn_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mg = getSupportFragmentManager();
                FragmentTransaction ft = mg.beginTransaction();
                Fragment f = new MyFragment1();
                ft.replace(R.id.frame_lay,f);
                ft.commit();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager mg = getSupportFragmentManager();
                FragmentTransaction ft = mg.beginTransaction();
                Fragment f = new MyFragment2();
                ft.replace(R.id.frame_lay,f);
                ft.commit();
            }
        });
    }
}
