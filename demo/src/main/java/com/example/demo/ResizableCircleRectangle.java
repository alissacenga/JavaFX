package com.example.demo;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ResizableCircleRectangle extends Application {
    private final Circle circle = new Circle(50);
    private final Rectangle rectangle = new Rectangle(100, 100);
    private final StackPane stackPane = new StackPane();
    public ResizableCircleRectangle(){
        circle.setFill(Color.GRAY);
        circle.setStroke(Color.GRAY);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
    }
    @Override
    public void start(Stage stage) {
        stackPane.getChildren().addAll(rectangle, circle);
        Scene scene = new Scene(stackPane, 200, 200);
        stackPane.widthProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                resize();
            }
        });
        stackPane.heightProperty().addListener(observable -> resize());
        stage.setScene(scene);
        stage.setTitle("Resizable Circle Rectangle");
        stage.show();
    }

    private void resize() {
        double width = stackPane.getWidth();
        double height = stackPane.getHeight();
        double radius = Math.min(width, height) / 4;
        circle.setRadius(radius);
        rectangle.setHeight(radius*2);
        rectangle.setWidth(radius*2);
    }
}
