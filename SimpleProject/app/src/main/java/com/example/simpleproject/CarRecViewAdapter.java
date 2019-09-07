package com.example.simpleproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarRecViewAdapter extends RecyclerView.Adapter<CarRecViewAdapter.CarViewHolder> {

    private ArrayList<Car> cars;
    private OnCarClickedListener listener;

    public CarRecViewAdapter(ArrayList<Car> cars, OnCarClickedListener listener) {
        this.cars = cars;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_car_layout, null, false);
        return new CarViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car c = cars.get(position);
        if (c.getImg() != null && !c.getImg().isEmpty())
            holder.iv.setImageURI(Uri.parse(c.getImg()));
        holder.color.setText(c.getColor());
        holder.dpl.setText(String.valueOf(c.getDpl()));
        holder.model.setText(c.getModel());
        holder.iv.setTag(c.getId());
        holder.color.setTextColor(Color.parseColor(String.valueOf(c.getColor())));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView model, color, dpl;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.custom_car_img);
            model = itemView.findViewById(R.id.custom_car_model);
            color = itemView.findViewById(R.id.custom_car_color);
            dpl = itemView.findViewById(R.id.custom_car_dp);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick((Integer) iv.getTag());
                }
            });
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
}
