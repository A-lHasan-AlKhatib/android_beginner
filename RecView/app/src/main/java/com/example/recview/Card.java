package com.example.recview;

public class Card {
    private String name;
    private String txt,following,post,followers;
    private int imge;

    public Card(String name, String descreption, String following, String post, String followers, int imge) {
        this.name = name;
        this.txt = descreption;
        this.following = following;
        this.post = post;
        this.followers = followers;
        this.imge = imge;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getImge() {
        return imge;
    }

    public void setImge(int imge) {
        this.imge = imge;
    }
}