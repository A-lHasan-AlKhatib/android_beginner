package com.example.myapplication;

public class country {
    private String name;
    private int flag;
    private long id;

    public country(String name, int flag, long id) {
        this.name = name;
        this.flag = flag;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
