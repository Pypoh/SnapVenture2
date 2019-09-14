package com.example.pypoh.snapventure.Model;

public class LevelModel {

    private String id;
    private int star;
    private int totalStar;
    private String[] riddle;
    private String[] answer;
    private int[] totalCompletedStar;
    private int stageCount;

    private boolean[] selected;

    public LevelModel(String id, int star, int totalStar, String[] riddle, String[] answer, int[] totalCompletedStar, int stageCount) {
        this.id = id;
        this.star = star;
        this.totalStar = totalStar;
        this.riddle = riddle;
        this.answer = answer;
        this.totalCompletedStar = totalCompletedStar;
        this.stageCount = stageCount;

        this.selected = new boolean[riddle.length];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getTotalStar() {
        return totalStar;
    }

    public void setTotalStar(int totalStar) {
        this.totalStar = totalStar;
    }

    public String[] getRiddle() {
        return riddle;
    }

    public void setRiddle(String[] riddle) {
        this.riddle = riddle;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public int[] getTotalCompletedStar() {
        return totalCompletedStar;
    }

    public void setTotalCompletedStar(int[] totalCompletedStar) {
        this.totalCompletedStar = totalCompletedStar;
    }

    public boolean[] getSelected() {
        return selected;
    }

    public void setSelected(int position, boolean input) {
        this.selected[position] = input;
    }

    public int getStageCount() {
        return stageCount;
    }

    public void setStageCount(int stageCount) {
        this.stageCount = stageCount;
    }
}
