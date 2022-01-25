package com.example.week3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class TabPaneDemo extends Application {
    @Override
    public void start (Stage stage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Tab 1");
        tab1.setClosable(false);
        tab1.setContent(new StackPane(new Circle(20)));
        Tab tab2 = new Tab("Tab 2");
        tab2.setContent(new StackPane(new Rectangle(40, 40)));
        tabPane.getTabs().addAll(tab1, tab2);
        Scene scene = new Scene(tabPane, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Tab demo");
        stage.show();
    }
}
