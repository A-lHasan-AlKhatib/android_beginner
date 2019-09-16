package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/posts", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    ArrayList<Post> posts = new ArrayList<>();
                    for (int i = 0; i<response.length();i++){
                        JSONObject obj = response.getJSONObject(i);
                        int userId = obj.getInt("userId");
                        int id = obj.getInt("id");
                        String title = obj.getString("title");
                        String body = obj.getString("body");
                        Post p = new Post(userId,id,title,body);
                        Log.d("Post "+i+" :" ,p.toString());
                        posts.add(p);
                    }
                    PostAdapter adapter = new PostAdapter(posts);
                    RecyclerView rv = findViewById(R.id.rv);
                    rv.setAdapter(adapter);
                    rv.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                    rv.setHasFixedSize(true);
                }catch (Exception ignored){}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(),"ERROR!!",Toast.LENGTH_LONG).show();
            }
        });
        queue.add(request);
    }
}
