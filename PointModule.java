package com.example.keytyper.Modules.Graphic;

public class PointModule {
    int mistTime;
    int mistakes;

    public PointModule(int mistTime, int mistakes) {
        this.mistTime = mistTime;
        this.mistakes = mistakes;
    }

    public int getMistTime() {
        return mistTime;
    }

    public int getMistakes() {
        return mistakes;
    }
}