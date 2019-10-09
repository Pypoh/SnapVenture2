package com.example.pypoh.snapventure.Model;

import android.util.Log;

public class ChatModel {

    private String key;
    private int user; // 0 = bot, 1 = user
    private String message;

    private boolean selected;

    public ChatModel(String key, int user, String message) {
        this.key = key;
        this.user = user;
        this.message = message;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int checkLayer() {
        int layerCount = 0;
        char[] stateToArray = key.toCharArray();
        for (char item : stateToArray) {
            if (item == '0' || item == '1' || item == '2') {
                layerCount++;
            }
        }
        return layerCount;
    }
}
