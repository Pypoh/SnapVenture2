package com.example.pypoh.snapventure.Model;

public class LeaderboardModel {

    private int number;
    private String name;
    private int starCount;

    public LeaderboardModel(int number, String name, int starCount) {
        this.number = number;
        this.name = name;
        this.starCount = starCount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
}
