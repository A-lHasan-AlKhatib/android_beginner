package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class country_adapter_app extends AppCompatActivity {
    ArrayList<country>data;
    Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        sp=findViewById(R.id.adapter_spinner);
        data=new ArrayList<>();

        data.add(new country("France" ,R.drawable.ic_france ,1));
        data.add(new country("Germany" ,R.drawable.ic_germany ,2));
        data.add(new country("Portugal" ,R.drawable.ic_portugal ,3));
        CountryCustomAdapter adapter=new CountryCustomAdapter(this,data);
        sp.setAdapter(adapter);
    }
}
