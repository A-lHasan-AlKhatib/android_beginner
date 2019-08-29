package com.example.myapplication;

public class User {
    private String name;
    private String descreption;
    private String following,post,followers;
    private int imge;

    public User(String name, String descreption, String following, String post, String followers, int imge) {
        this.name = name;
        this.descreption = descreption;
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

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public int getImge() {
        return imge;
    }

    public void setImge(int imge) {
        this.imge = imge;
    }
}
