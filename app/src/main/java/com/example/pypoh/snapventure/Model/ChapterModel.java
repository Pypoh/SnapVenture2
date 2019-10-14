package com.example.pypoh.snapventure.Model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ChapterModel implements Serializable {

    private int chapterNumber;
    private int lockStatus;
//    private List<String> stateData;
//    private HashMap<String, ChatModel> conversationData;

    public ChapterModel(int chapterNumber, int lockStatus) {
        this.chapterNumber = chapterNumber;
        this.lockStatus = lockStatus;
//        this.stateData = stateData;
//        this.conversationData = conversationData;
    }

    public int getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(int chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

//    public List<String> getStateData() {
//        return stateData;
//    }
//
//    public void setStateData(List<String> stateData) {
//        this.stateData = stateData;
//    }
//
//    public HashMap<String, ChatModel> getConversationData() {
//        return conversationData;
//    }
//
//    public void setConversationData(HashMap<String, ChatModel> conversationData) {
//        this.conversationData = conversationData;
//    }

    public int getLockStatus() {
        return lockStatus;
    }

    public void setLockStatus(int lockStatus) {
        this.lockStatus = lockStatus;
    }
}
