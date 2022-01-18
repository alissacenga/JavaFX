package com.example.demo;

import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FadeTransitionDemo extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Ellipse ellipse = new Ellipse();
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.centerYProperty().bind(pane.heightProperty().divide(2));
        ellipse.radiusXProperty().bind(pane.widthProperty().multiply(0.4));
        ellipse.radiusYProperty().bind(pane.heightProperty().multiply(0.4));
        pane.getChildren().add(ellipse);

        FadeTransition ft = new FadeTransition();
        ft.setDuration(Duration.millis(3000));
        ft.setNode(ellipse);
        ft.setFromValue(1.);
        ft.setToValue(.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();
        Scene scene = new Scene(pane, 200, 150);
        stage.setScene(scene);
        stage.setTitle("Fade transition demo");
        stage.show();
    }
}
