package com.example.pypoh.snapventure.Model;

public class LessonModel {

    private String image;
    private int lessonNumber;
    private float progress;

    public LessonModel(String image, int lessonNumber, float progress) {
        this.image = image;
        this.lessonNumber = lessonNumber;
        this.progress = progress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}
