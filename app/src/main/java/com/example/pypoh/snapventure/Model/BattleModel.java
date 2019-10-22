package com.example.pypoh.snapventure.Model;

public class BattleModel {
    private int status; // 0 = win, 1 = lose, 3 = draw
    private String image;
    private String name;
    private String score;
    private String result;

    public BattleModel(int status, String image, String name, String score, String result) {
        this.status = status;
        this.image = image;
        this.name = name;
        this.score = score;
        this.result = result;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
