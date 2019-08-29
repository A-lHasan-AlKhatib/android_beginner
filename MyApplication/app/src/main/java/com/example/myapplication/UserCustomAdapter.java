package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class UserCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<User> users;

    public UserCustomAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(view==null){
            v=  LayoutInflater.from(context).inflate(R.layout.user_profile,null);
        }
        ImageView img=v.findViewById(R.id.profile_img);
        TextView tx_name=v.findViewById(R.id.profile_tx_name);
        TextView tx_desc=v.findViewById(R.id.profile_tx_desc);
        TextView tx_follwoing=v.findViewById(R.id.profile_tx_follwoing);
        TextView tx_follwoers=v.findViewById(R.id.profile_tx_follwoers);
        TextView tx_post=v.findViewById(R.id.profile_tx_post);
        User u=getItem(i);
        img.setImageResource(u.getImge());
        tx_desc.setText(u.getDescreption());
        tx_name.setText(u.getName());
        tx_follwoing.setText(u.getFollowing());
        tx_follwoers.setText(u.getFollowers());
        tx_post.setText(u.getPost());
        return v;
    }
}
