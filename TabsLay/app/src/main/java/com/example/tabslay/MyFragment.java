package com.example.tabslay;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private Catrgoy catrgoy;

    public Catrgoy getCatrgoy() {
        return catrgoy;
    }

    public void setCatrgoy(Catrgoy catrgoy) {
        this.catrgoy = catrgoy;
    }

    public MyFragment() {
        // Required empty public constructor
    }

    public MyFragment(Catrgoy catrgoy) {
        this.catrgoy = catrgoy;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        TextView t = v.findViewById(R.id.frag_text);
        if (catrgoy != null)
            t.setText(catrgoy.getDesc());
        else
            t.setText("No description found!!");
        return v;
    }

    @Override
    public void setArguments(@Nullable Bundle args) {
        super.setArguments(args);
    }
}
