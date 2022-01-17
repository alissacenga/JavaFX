package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LambdaDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Text text = new Text(40, 40, "Learning JavaFx");
        Pane pane = new Pane(text);
        HBox hBox = new HBox();
        hBox.setSpacing(20);
        Button leftBtn = new Button("Left");
        Button rightBtn = new Button("Right");
        Button topBtn = new Button("Top");
        Button bottomBtn = new Button("Bottom");
        leftBtn.setOnAction(e -> {
            if (text.getX() > 2)
                text.setX(text.getX() - 2);
            else
                System.out.println("Cannot go further left!");
        });
        topBtn.setOnAction(e -> {
            if (text.getY() > 6)
                text.setY(text.getY() - 2);
            else
                System.out.println("Cannot go further top!");
        });
        rightBtn.setOnAction(e -> {
            if (text.getX() < pane.getWidth() - 100)
                text.setX(text.getX() + 2);
            else
                System.out.println("Cannot go further right!");
        });
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(leftBtn, topBtn, bottomBtn, rightBtn);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(pane);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lambda Demo");
        primaryStage.show();
    }
}
