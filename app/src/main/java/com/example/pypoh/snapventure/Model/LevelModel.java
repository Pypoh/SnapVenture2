package com.example.pypoh.snapventure.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LevelModel implements Serializable {

    private String id;
    private String levelName;
    private int star;
    private int totalStar;
    private List<String[]> riddleEn;
    private List<String[]> riddleId;
    private List<String[]> answer;
    private List<String[]> pronounce;
    private List<boolean[]> totalCompletedStar;
    private int stageCount;
    private String place;
    private int level;
    private boolean lockStatus;
    private int stageNumber;

    private int stageLevel;

    private boolean isHeader;

    private boolean[] selected;

    public LevelModel(String id, String levelName, int stageLevel, int star, int totalStar, boolean lockStatus) {
        this.id = id;
        this.levelName = levelName;
        this.star = star;
        this.totalStar = totalStar;
        this.isHeader = true;
        this.lockStatus = lockStatus;
        this.stageLevel = stageLevel;
    }

    public int getStageLevel() {
        return stageLevel;
    }

    public void setStageLevel(int stageLevel) {
        this.stageLevel = stageLevel;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    // Newest
    public LevelModel(String id, List<String[]> riddleEn, List<String[]> riddleId, List<String[]> answer, List<String[]> pronounce, List<boolean[]> totalCompletedStar, String place, int level, int stageNumber, boolean lockStatus) {
        this.id = id;
        this.riddleEn = riddleEn;
        this.riddleId = riddleId;
        this.answer = answer;
        this.pronounce = pronounce;
        this.totalCompletedStar = totalCompletedStar;
        this.place = place;
        this.level = level;
        this.stageNumber = stageNumber;
        this.lockStatus = lockStatus;
        this.isHeader = false;
    }

    public LevelModel(String id, String levelName, int star, int totalStar, List<String[]> riddleEn, List<String[]> riddleId, List<String[]> answer, List<String[]> pronounce, List<boolean[]> totalCompletedStar, int stageCount, String place, int level, boolean lockStatus) {
        this.id = id;
        this.levelName = levelName;
        this.star = star;
        this.totalStar = totalStar;
        this.riddleEn = riddleEn;
        this.riddleId = riddleId;
        this.answer = answer;
        this.pronounce = pronounce;
        this.totalCompletedStar = totalCompletedStar;
        this.stageCount = stageCount;
        this.place = place;
        this.level = level;
        this.lockStatus = lockStatus;
        this.selected = new boolean[riddleEn.size()];
        this.isHeader = false;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
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

    public List<String[]> getRiddleEn() {
        return riddleEn;
    }

    public void setRiddleEn(List<String[]> riddleEn) {
        this.riddleEn = riddleEn;
    }

    public List<String[]> getRiddleId() {
        return riddleId;
    }

    public void setRiddleId(List<String[]> riddleId) {
        this.riddleId = riddleId;
    }

    public List<String[]> getAnswer() {
        return answer;
    }

    public void setAnswer(List<String[]> answer) {
        this.answer = answer;
    }

    public List<boolean[]> getTotalCompletedStar() {
        return totalCompletedStar;
    }

    public void setTotalCompletedStar(List<boolean[]> totalCompletedStar) {
        this.totalCompletedStar = totalCompletedStar;
    }

    public void setTotalCompletedStar(boolean[] totalCompletedStar) {
        List<boolean[]> tempData = new ArrayList<>();
        tempData.add(totalCompletedStar);
        this.totalCompletedStar = tempData;
    }

    public void setTotalCompletedStar(boolean[] totalCompletedStar, int position) {
        this.totalCompletedStar.set(position, totalCompletedStar);
    }

    public void setSelected(boolean[] selected) {
        this.selected = selected;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(boolean lockStatus) {
        this.lockStatus = lockStatus;
    }

    public List<String[]> getPronounce() {
        return pronounce;
    }

    public void setPronounce(List<String[]> pronounce) {
        this.pronounce = pronounce;
    }

}
