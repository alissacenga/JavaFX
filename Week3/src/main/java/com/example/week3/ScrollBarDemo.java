package com.example.week3;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ScrollBarDemo extends Application {
    @Override
    public void start (Stage stage) {
        Text text = new Text(10, 10, "By convention bitter");
        Pane textPane = new Pane(text);
        textPane.setPadding(new Insets(20));
        ScrollBar vScrollBar = new ScrollBar();
        vScrollBar.setOrientation(Orientation.VERTICAL);
        ScrollBar hScrollBar = new ScrollBar();

        BorderPane pane = new BorderPane();
        pane.setCenter(textPane);
        pane.setBottom(hScrollBar);
        pane.setRight(vScrollBar);
        pane.setPadding(new Insets(10));

        hScrollBar.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                text.setX(hScrollBar.getValue()/hScrollBar.getMax() * textPane.getWidth());
            }
        });
        vScrollBar.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                text.setY(vScrollBar.getValue()/vScrollBar.getMax() * textPane.getHeight());
            }
        });

        Scene scene = new Scene(pane, 400, 100);
        stage.setScene(scene);
        stage.setTitle("Scroll bar demo");
        stage.show();
    }
}
