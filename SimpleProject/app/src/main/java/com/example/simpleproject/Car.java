package com.example.simpleproject;

public class Car {
    private int id;
    private String model;
    private String color;
    private double dpl;
    private String img;
    private String description;

    public Car(int id) {
        this.id = id;
    }

    public Car(int id, String model, String color, double dpl, String img, String description) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.dpl = dpl;
        this.img = img;
        this.description = description;
    }

    public Car(String model, String color, double dpl, String img, String description) {
        this.model = model;
        this.color = color;
        this.dpl = dpl;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
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