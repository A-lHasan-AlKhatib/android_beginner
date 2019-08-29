package com.example.myapplication;

public class Post {
    private String title;
    private String des;
    private int img;
    private long id;

    public Post(String title, String des, int img, long id) {
        this.title = title;
        this.des = des;
        this.img = img;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
