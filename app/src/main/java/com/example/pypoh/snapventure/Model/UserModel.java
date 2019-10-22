package com.example.pypoh.snapventure.Model;

import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("level")
    private int level;

    public UserModel(String name, String email, int level) {
        this.name = name;
        this.email = email;
    }

    public UserModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
