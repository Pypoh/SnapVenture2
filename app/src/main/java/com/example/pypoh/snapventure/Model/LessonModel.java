package com.example.pypoh.snapventure.Model;

public class LessonModel {

    private int image;
    private int lessonNumber;
    private String lessonNames;
    private int progress;
    private String lessonDesc;

    public LessonModel(int image, int lessonNumber, String lessonNames, int progress) {
        this.image = image;
        this.lessonNumber = lessonNumber;
        this.lessonNames = lessonNames;
        this.progress = progress;
    }


    public LessonModel(int image, int lessonNumber, String lessonNames, int progress, String lessonDesc) {
        this.image = image;
        this.lessonNumber = lessonNumber;
        this.lessonNames = lessonNames;
        this.progress = progress;
        this.lessonDesc = lessonDesc;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
    }

    public String getLessonNames() {
        return lessonNames;
    }

    public void setLessonNames(String lessonNames) {
        this.lessonNames = lessonNames;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
