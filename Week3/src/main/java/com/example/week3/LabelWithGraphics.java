package com.example.week3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LabelWithGraphics extends Application {
    @Override
    public void start (Stage stage) {
        ImageView imageView = new ImageView(new Image("plato.jpeg"));
        imageView.setFitHeight(256);
        imageView.setFitWidth(256);
        Label label1 = new Label("Plato", imageView);
        label1.setContentDisplay(ContentDisplay.TOP);
        label1.setStyle("-fx-border-color: red; -fx-border-radius: 15px; -fx-border-width: 3px");
        label1.setPadding(new Insets(5, 5, 5, 5));
        label1.setTextFill(Color.BLUE);

        Label label2 = new Label("Circle", new Circle(50, 50, 50));
        label2.setStyle("-fx-border-color: black; -fx-border-width: 3px;");
        label2.setContentDisplay(ContentDisplay.LEFT);

        Label label3 = new Label("Ellipse", new Ellipse(50, 50, 50, 25));
        label3.setStyle("-fx-border-color: orange; -fx-border-width: 3px;");
        label3.setContentDisplay(ContentDisplay.RIGHT);

        Label label4 = new Label("Label for \n stack pane");
        StackPane stackPane = new StackPane();
        Rectangle rectangle = new Rectangle(50, 50, 50, 50);
        rectangle.setFill(Color.YELLOW);
        stackPane.getChildren().addAll(rectangle, new Label("Square"));
        label4.setGraphic(stackPane);
        label4.setStyle("-fx-border-color: blue; -fx-border-width: 3px;");
        label4.setContentDisplay(ContentDisplay.RIGHT);

        Label label5 = new Label("Button with an icon");
        ImageView icon = new ImageView(new Image("icon.png"));
        icon.setFitWidth(24);
        icon.setFitHeight(24);
        Button button = new Button("Add to basket", icon);
        label5.setStyle("-fx-border-color: green; -fx-border-width: 3px");
        label5.setPadding(new Insets(10, 10, 10, 10));
        label5.setContentDisplay(ContentDisplay.BOTTOM);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        double padding = 20;
        hBox.setPadding(new Insets(padding));
        hBox.setSpacing(25);
        hBox.getChildren().addAll(label1, label2, label3, label4, label5);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.setTitle("Label with graphics");
        stage.show();
    }
    public static void main (String[] args) {
        launch();
    }
}
