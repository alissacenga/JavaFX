package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class KeyEventDemo extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "A");
        pane.getChildren().add(text);
        Scene scene = new Scene(pane, 200, 200);
        text.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP:
                    if (text.getY() > 10)
                        text.setY(text.getY() - 5);
                    break;
                case DOWN:
                    if (text.getY() < 190)
                        text.setY(text.getY() + 5);
                    break;
                case LEFT:
                    if (text.getX() > 10)
                        text.setX(text.getX() - 5);
                    break;
                case RIGHT:
                    if (text.getX() < 190)
                        text.setX(text.getX() + 5);
                    break;
                default:
                    if (keyEvent.getText().length() > 0)
                        text.setText(keyEvent.getText().toUpperCase());
                    break;
            }
        });

        stage.setScene(scene);
        stage.setTitle("Key Event Demo");
        stage.show();
        // only a focused node can receive key input
        text.requestFocus();
    }
}
