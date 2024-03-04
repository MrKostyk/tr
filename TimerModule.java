package com.example.keytyper.Modules.Timer;

import com.example.keytyper.Controllers.Controller;
import javafx.application.Platform;

import java.util.TimerTask;

public class TimerModule extends TimerTask {
    private int seconds = 30;
    private final Controller controller;

    public TimerModule(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        if (seconds>0){
            seconds--;
            Platform.runLater(()->controller.updateTimer(seconds));
        }else{
            Platform.runLater(()->controller.onTimesUp());
            cancel();
        }
    }
}