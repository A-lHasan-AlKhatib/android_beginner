package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class custom_adapter extends AppCompatActivity {
    ArrayList<Post> data;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        lv=findViewById(R.id.test_lv);
        data=new ArrayList<>();
        for (int i = 0; i <10 ; i++) {
            data.add(new Post("Item # "+i ,"Description...."+i ,R.drawable.man,i));
        }
        PostCustomAdapter adapter=new PostCustomAdapter(this,data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(custom_adapter.this, "ID "+l, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
