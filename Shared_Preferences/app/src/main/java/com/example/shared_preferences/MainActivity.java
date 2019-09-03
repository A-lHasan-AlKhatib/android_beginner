package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("name","Al-Hasan");
                edit.apply();
            }
        });

        Button restore = findViewById(R.id.restore);
        restore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                TextView views = findViewById(R.id.textView);
                views.setText(preferences.getString("name","No name found"));

            }
        });

        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor edit = preferences.edit();
                edit.remove("name");
                edit.apply();
            }
        });
    }
}
