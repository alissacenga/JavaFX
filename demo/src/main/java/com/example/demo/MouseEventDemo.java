package com.example.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MouseEventDemo extends Application {

    @Override
    public void start(Stage stage)  {
        Pane pane = new Pane();
        Text text = new Text(20, 20, "JavaFX");
        pane.getChildren().add(text);
//        text.setOnMouseDragged(mouseEvent -> {
//            text.setX(mouseEvent.getX());
//            text.setY(mouseEvent.getY());
//            text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
//        });
        Scene scene = new Scene(pane, 400, 400);
        scene.setOnMouseMoved(mouseEvent -> {
            text.setX(mouseEvent.getX());
            text.setY(mouseEvent.getY());
            text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        });
        stage.setScene(scene);
        stage.setTitle("On Mouse dragged");
        stage.show();
    }
}
