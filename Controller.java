package com.example.keytyper.Controllers;

import com.example.keytyper.Modules.Graphic.GraphicModule;
import com.example.keytyper.Modules.Graphic.PointModule;
import com.example.keytyper.Modules.Timer.TimerModule;
import com.example.keytyper.Modules.Typer.TypeModule;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Timer;

public class Controller {
    private static final String str = "Venturing beyond the bounds of known space: a monumental expedition through fifty diverse worlds, unraveling the mysteries of the multiverse and beyond" ;

    @FXML
    public javafx.scene.layout.VBox VBox;

    @FXML
    public TextFlow textFlow;

    @FXML
    public Label secs;

    private Scene scene;

    private final TypeModule typeModule = new TypeModule();

    private final GraphicModule graphicModule = new GraphicModule();

    private boolean firstType = true;

    private Timer timer;

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setupUI() {
        for (char c : str.toCharArray()) {
            Text newText = new Text(String.valueOf(c));
            newText.setFill(Color.GRAY);
            textFlow.getChildren().add(newText);
        }
        scene.addEventFilter(KeyEvent.KEY_PRESSED, this::onKeyTyped);
    }

    public void onKeyTyped(KeyEvent keyEvent) {
        typeModule.onKeyTyped(keyEvent, textFlow);
        if (firstType) {
            firstType = false;
            timer = new Timer();
            timer.schedule(new TimerModule(this), 0, 1000);
        }
    }

    public void updateTimer(int seconds) {
        graphicModule.addPointToList(new PointModule(seconds, typeModule.getMistakes()));
        secs.setText(String.valueOf(seconds));
    }

    public void onTimesUp() {
        scene.removeEventFilter(KeyEvent.KEY_PRESSED, this::onKeyTyped);
        graphicModule.createGraphic();
    }

    public void startTyping() {
        if (firstType) {
            firstType = false;
            timer = new Timer();
            timer.schedule(new TimerModule(this), 0, 1000);
        }
    }

    public void stopTyping() {
        if (timer != null) {
            timer.cancel();
            firstType = true;
        }
    }


}