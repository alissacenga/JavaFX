package com.example.demo;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathTransitionDemo extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Rectangle rectangle = new Rectangle(0, 0, 25, 50);
        rectangle.setFill(Color.ORANGE);

        Circle circle = new Circle(100, 100, 50);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        pane.getChildren().addAll(circle, rectangle);

        // create a path transition
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(1000));
        pathTransition.setPath(circle);
        pathTransition.setNode(rectangle);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();

        // event listeners
        pane.setOnMousePressed(mouseEvent -> pathTransition.play());
        pane.setOnMouseReleased(mouseEvent -> pathTransition.stop());

        // create scene
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.setTitle("Transition path");
        stage.show();
        flagRaisingAnimation();
    }

    private void flagRaisingAnimation() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Image image = new Image("/inter.jpeg");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        pane.getChildren().add(imageView);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(1000));
        pt.setPath(new Line(100, 200, 100, 0));
        pt.setNode(imageView);
        pt.setCycleCount(5);
        pt.play();
        Scene scene = new Scene(pane, 250, 250);
        stage.setScene(scene);
        stage.setTitle("Raising flag");
        stage.show();
    }
}
