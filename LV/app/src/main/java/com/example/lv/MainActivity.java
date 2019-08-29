package com.example.lv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posts = new ArrayList<>();
        posts.add(new Post(2,"I'm Groot"));
        posts.add(new Post(1,"I'm Iron man"));
        posts.add(new Post(0,"This is Sparta"));

        MyAdapter adp = new MyAdapter(MainActivity.this,posts);
        ListView ls = findViewById(R.id.ls);
        ls.setAdapter(adp);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "# " + i,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
