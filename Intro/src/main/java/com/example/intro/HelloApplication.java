package com.example.intro;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        demoPropertyBinding();
        Pane pane = new Pane();
        Circle circle = new Circle(200, 200, 100);
        circle.setStyle("-fx-stroke: black; -fx-fill: white");
        Text label = new Text(200, 200, "Circle");
        label.setRotate(180);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        pane.getChildren().addAll(circle, label);
        Scene scene = new Scene(pane, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private void demoPropertyBinding() {
        IntegerProperty prop1 = new SimpleIntegerProperty(3);
        IntegerProperty prop2 = new SimpleIntegerProperty(4);
        System.out.println("Prop1: " + prop1.getValue() + ", prop2: " + prop2.getValue());
        prop1.bind(prop2.divide(2));
        prop2.setValue(8);
        System.out.println("Prop1: " + prop1.getValue() + ", prop2: " + prop2.getValue());
    }

    public static void main(String[] args) {
        launch();
    }
}