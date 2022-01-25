package com.example.week3;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SinFunction extends Application {
    private final Pane pane = new Pane();
    private final Polyline polyline = new Polyline();
    @Override
    public void start(Stage stage) {
        paintGraph();
        InvalidationListener resizeHandler = e -> paintGraph();
        pane.widthProperty().addListener(resizeHandler);
        pane.heightProperty().addListener(resizeHandler);
        Scene scene = new Scene(pane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Sin function");
        stage.show();
    }

    private void paintGraph() {
        pane.getChildren().clear();
        polyline.getPoints().clear();
        double centerX = pane.getWidth()/2;
        double centerY = pane.getHeight()/2;
        double rescaleFactor = 100;
        for (int i = -180; i <= 180 ; i++) {
            polyline.getPoints().add(centerX + i);
            polyline.getPoints().add(centerY - rescaleFactor*Math.sin(Math.toRadians(i)));
        }
        pane.getChildren().add(polyline);
        Line line1 = new Line(0, centerY, pane.getWidth(), centerY); // The X-Axis
        pane.getChildren().add(line1);
        Line line2 = new Line(centerX, 0, centerX, pane.getHeight()); // The Y-Axis
        pane.getChildren().add(line2);
        Text text1 = new Text(pane.getWidth() - 20, centerY - 10, "x");
        Text text2 = new Text(centerX + 10, 20, "y");
        pane.getChildren().addAll(text1, text2);
    }
}
