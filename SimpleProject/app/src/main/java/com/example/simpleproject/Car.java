package com.example.simpleproject;

import android.media.Image;

public class Car {
    private int id;
    private String model;
    private int img;
    private String color;
    private double dpl;
    private String description;

    public Car(int id, String model, int img, String color, double dpl, String description) {
        this.id = id;
        this.model = model;
        this.img = img;
        this.color = color;
        this.dpl = dpl;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getDpl() {
        return dpl;
    }

    public void setDpl(double dpl) {
        this.dpl = dpl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}