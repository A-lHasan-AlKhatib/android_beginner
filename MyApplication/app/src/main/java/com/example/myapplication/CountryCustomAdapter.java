package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<country> countrys;

    public CountryCustomAdapter(Context context, ArrayList<country> countrys) {
        this.context = context;
        this.countrys = countrys;
    }

    @Override
    public int getCount() {
        return countrys.size();
    }

    @Override
    public country getItem(int i) {
        return countrys.get(i);
    }

    @Override
    public long getItemId(int i) {
        return countrys.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v=view;
        if(view==null){
            v=  LayoutInflater.from(context).inflate(R.layout.country,null);
        }
        ImageView iv_flag=v.findViewById(R.id.country_img);
        TextView tx_name=v.findViewById(R.id.country_tx);
        country c=getItem(i);
        iv_flag.setImageResource(c.getFlag());
        tx_name.setText(c.getName());
        return v;
    }
}
