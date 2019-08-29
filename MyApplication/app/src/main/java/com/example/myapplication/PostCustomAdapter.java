package com.example.myapplication;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PostCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Post> posts;

    public PostCustomAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Post getItem(int i) {
        return posts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return posts.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(view==null){
            v=  LayoutInflater.from(context).inflate(R.layout.activity_custom_adapter,null);
        }
        ImageView img=v.findViewById(R.id.custom_adapter_iv);
        TextView tx_title=v.findViewById(R.id.custom_adapter_tx_title);
        TextView tx_des=v.findViewById(R.id.custom_adapter_tx_des);
        Post p=getItem(i);
        img.setImageResource(p.getImg());
        tx_title.setText(p.getTitle());
        tx_des.setText(p.getDes());
        return v;
    }
}
