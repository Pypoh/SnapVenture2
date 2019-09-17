package com.example.pypoh.snapventure.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LevelModel implements Serializable {

    private String id;
    private int star;
    private int totalStar;
    private List<String[]> riddle;
    private List<String[]> answer;
    private List<Boolean[]> totalCompletedStar;
    private int stageCount;

    private boolean[] selected;

    public LevelModel(String id, int star, int totalStar, List<String[]> riddle, List<String[]> answer, List<Boolean[]> totalCompletedStar, int stageCount) {
        this.id = id;
        this.star = star;
        this.totalStar = totalStar;
        this.riddle = riddle;
        this.answer = answer;
        this.totalCompletedStar = totalCompletedStar;
        this.stageCount = stageCount;


        this.selected = new boolean[riddle.size()];
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

    public List<String[]> getRiddle() {
        return riddle;
    }

    public void setRiddle(List<String[]> riddle) {
        this.riddle = riddle;
    }

    public List<String[]> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String[]> answer) {
        this.answer = answer;
    }

    public List<Boolean[]> getTotalCompletedStar() {
        return totalCompletedStar;
    }

    public void setTotalCompletedStar(List<Boolean[]> totalCompletedStar) {
        this.totalCompletedStar = totalCompletedStar;
    }

    public void setSelected(boolean[] selected) {
        this.selected = selected;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeInt(this.star);
        dest.writeInt(this.totalStar);
        dest.writeList(this.riddle);
        dest.writeList(this.answer);
        dest.writeList(this.totalCompletedStar);
        dest.writeInt(this.stageCount);
        dest.writeBooleanArray(this.selected);
    }
    */

}
