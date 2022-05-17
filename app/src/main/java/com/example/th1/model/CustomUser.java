package com.example.th1.model;

public class CustomUser {
    private String id;
    private String userAvatar;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomUser(String id, String userAvatar, String name) {
        this.id = id;
        this.userAvatar = userAvatar;
        this.name = name;
    }

    public CustomUser() {
    }
}
