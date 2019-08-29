package com.example.lv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Post> posts;

    public MyAdapter(Context context, ArrayList<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        if(v != null){
            v = LayoutInflater.from(context).inflate(R.layout.lay,null);
        }

        TextView num = null;
        if (v != null) {
            num = v.findViewById(R.id.num);
        }
        TextView text = null;
        if (v != null) {
            text = v.findViewById(R.id.te);
        }
        Post p = posts.get(i);

        if (text != null) {
            text.setText(p.getText());
        }
        if (num != null) {
            num.setText(String.valueOf(p.getNum()));
        }

        return v;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
}
