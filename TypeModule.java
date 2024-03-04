package com.example.keytyper.Modules.Typer;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.util.Objects;

public class TypeModule {
    private int i;
    private int mistakes = 0;
    public void onKeyTyped(KeyEvent keyEvent, TextFlow textFlow) {

        Text textElem;
        String charTyped;

        if (!checkForBackspace(keyEvent)){
            textElem = (Text) textFlow.getChildren().get(i);
            charTyped = keyEvent.getText();

            i++;
            if (Objects.equals(textElem.getText(), charTyped)) {
                textElem.setFill(Color.BLACK);
                textElem.setText(charTyped);
            }else{
                mistakes++;
                textElem.setFill(Color.RED);
            }
        }else{
            i--;
            Text prevTextElem = (Text) textFlow.getChildren().get(i);
            onBackspace(prevTextElem);
        }
    }

    public boolean checkForBackspace(KeyEvent keyEvent) {
        return keyEvent.getCode().equals(KeyCode.BACK_SPACE);
    }

    public void onBackspace(Text prevTextElem) {
        if (!(mistakes==0)){
            mistakes--;
        }
        prevTextElem.setFill(Color.GRAY);
    }

    public int getMistakes() {
        return mistakes;
    }
}