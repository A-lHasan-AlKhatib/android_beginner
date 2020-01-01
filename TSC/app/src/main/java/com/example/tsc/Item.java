package com.example.tsc;

import java.util.HashMap;
import java.util.Map;

public class Item {
    private String name;
    private String price;
    //private String desc;
    private String img;

    public Item() {
    }

    public Item(String name, String price, String desc, String img) {
        this.name = name;
        this.price = price;
      //  this.desc = desc;
        this.img = img;
    }

    public Item(String name, String price, HashMap<String,String> mp, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
        String s = "";
        for (Map.Entry<String,String> entry : mp.entrySet()){
            s += entry.getKey() + " : " + entry.getValue() + "\n";
        }
       // this.desc = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public String getDesc() {
//        return desc;
//    }
//
//    public void setDesc(String desc) {
//        this.desc = desc;
//    }
//
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}