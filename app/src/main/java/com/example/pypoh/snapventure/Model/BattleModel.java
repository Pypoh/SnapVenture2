package com.example.pypoh.snapventure.Model;

public class BattleModel {
    private int status; // 1 = win, 2 = lose, 3 = draw
    private String image;
    private String name;
    private int score1;
    private int score2;
    private String result;

    public BattleModel(int status, String image, String name, int score1, int score2, String result) {
        this.status = status;
        this.image = image;
        this.name = name;
        this.score1 = score1;
        this.score2 = score2;
        this.result = result;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
