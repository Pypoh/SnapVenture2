package com.example.pypoh.snapventure.Model;

public class ModeModel {

    private String modeName;
    private String modeDesc;
    private int mode;

    public ModeModel(String modeName, String modeDesc, int mode) {
        this.modeName = modeName;
        this.modeDesc = modeDesc;
        this.mode = mode;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getModeDesc() {
        return modeDesc;
    }

    public void setModeDesc(String modeDesc) {
        this.modeDesc = modeDesc;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
