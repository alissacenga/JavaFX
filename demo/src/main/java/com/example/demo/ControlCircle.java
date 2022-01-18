package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    private final CirclePane circlePane = new CirclePane();
    @Override
    public void start (Stage stage) {
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        HBox hBox = new HBox();
        Button enlargeBtn = new Button("Enlarge");
        enlargeBtn.setOnAction(new EnlargeHandler());
        Button shrinkBtn = new Button("Shrink");
        // anonymous inner class
        shrinkBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                circlePane.shrink();
            }
        });
        // on key events
        borderPane.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY)
                circlePane.enlarge();
            else if (mouseEvent.getButton() == MouseButton.SECONDARY)
                circlePane.shrink();
        });
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(enlargeBtn, shrinkBtn);
        borderPane.setBottom(hBox);
        Scene scene = new Scene(borderPane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
    // inner class
    private class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            circlePane.enlarge();
        }
    }
}

class CirclePane extends StackPane {
    private final Circle circle = new Circle();
    public CirclePane() {
        circle.setStyle("-fx-stroke: black; -fx-fill: white");
        circle.setRadius(50);
        getChildren().add(circle);
    }
    public void enlarge() {
        circle.setRadius(circle.getRadius() + 2);
    }
    public void shrink() {
        if (circle.getRadius() > 2)
            circle.setRadius(circle.getRadius() - 2);
    }
}
