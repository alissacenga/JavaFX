package com.example.demo;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        bindingDemo();
        Pane pane = new Pane();
        Circle circle = new Circle();
        // it won't stay in the middle if you resize the window
        // circle.setCenterX(250);
        // circle.setCenterY(250);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(100);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        //circle.setStyle("-fx-stroke: black; -fx-fill: white");
        pane.getChildren().add(circle);
        // create a label
        Label label = new Label("JavaFX");
        label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(label);
        // create a scene and put it in the stage
        Scene scene = new Scene(pane, 500, 500);
        stage.setTitle("Hello FX");
        stage.setScene(scene);
        stage.show();
        showSecondStage();
        showFlowPane();
        showLines();
        showRectangle();
        showEllipse();
        showArc();
    }

    private void showArc() {
        Stage stage = new Stage();

        Arc arc1 = new Arc(150, 100, 80, 80, 30, 35);
        arc1.setFill(Color.RED);
        arc1.setType(ArcType.ROUND);

        Arc arc2 = new Arc(150, 100, 80, 80, 30+90, 35);
        arc2.setFill(Color.WHITE);
        arc2.setType(ArcType.OPEN);
        arc2.setStroke(Color.BLACK);

        Arc arc3 = new Arc(150, 100, 80, 80, 30 +180, 35);
        arc3.setFill(Color.YELLOW);
        arc2.setType(ArcType.CHORD);
        arc3.setStroke(Color.BLACK);

        Arc arc4 = new Arc(150, 100, 80, 80, 30 + 270, 35);
        arc4.setFill(Color.GREEN);
        arc4.setType(ArcType.CHORD);
        arc4.setStroke(Color.BLACK);

        Group group = new Group();
        group.getChildren().addAll(
                new Text(210, 40, "arc1 round"),
                arc1,
                new Text(20, 40, "arc2 open"),
                arc2,
                new Text(20, 170, "arc3 chord"),
                arc3,
                new Text(210, 170, "arc4 chord"),
                arc4
        );

        Scene scene = new Scene(new BorderPane(group), 300, 200);
        stage.setTitle("Arc");
        stage.setScene(scene);
        stage.show();
    }

    private void showEllipse() {
        Stage stage = new Stage();
        Scene scene = new Scene(new MyEllipse(), 300, 200);
        stage.setTitle("Show Ellipse");
        stage.setScene(scene);
        stage.show();
    }

    private void showRectangle() {
        Stage stage = new Stage();
        Group group = new Group();
        group.getChildren().addAll(
                new Text(10, 27, "r1"),
                new Text(10, 64, "r2"),
                new Text(10, 107, "r3")
        );
        for (int i = 0; i < 4; i++) {
            Rectangle r = new Rectangle(100, 50, 100, 30);
            r.setRotate(i * 360./8);
            r.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            r.setFill(Color.WHITE);
            group.getChildren().add(r);
        }
        Scene scene = new Scene(group);
        stage.setScene(scene);
        stage.setTitle("Rectangles");
        stage.show();
    }

    private void showLines() {
        Stage stage = new Stage();
        Pane pane = new Pane();
        Line line1 = new Line(10, 10, pane.getWidth() - 10, pane.getHeight() - 10);
        line1.endXProperty().bind(pane.widthProperty().subtract(10));
        line1.endYProperty().bind(pane.heightProperty().subtract(10));
        line1.setStrokeWidth(5);
        line1.setStroke(Color.GREEN);
        pane.getChildren().add(line1);
        Line line2 = new Line(10, 10, 10, 10);
        line2.startXProperty().bind(pane.widthProperty().subtract(10));
        line2.endYProperty().bind(pane.heightProperty().subtract(10));
        line2.setStrokeWidth(5);
        line2.setStroke(Color.RED);
        pane.getChildren().add(line2);
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Show lines");
        stage.show();
    }

    public static void showFlowPane() {
        Stage stage = new Stage();
        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setVgap(10);
        pane.setHgap(10);
        pane.getChildren().addAll(
                new Label("Email"),
                new TextField(),
                new Label("Password"),
                new TextField()
        );
        Scene scene = new Scene(pane);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    public static void showSecondStage() {
        Stage stage = new Stage();
        // hbox is a pane that places all the nodes horizontally in one row
        Pane pane = new HBox(10);
        pane.setPadding(new Insets(5, 5, 5, 5));
        Image image = new Image("http://liveexample.pearsoncmg.com/book/image/us.gif");
        pane.getChildren().add(new ImageView(image));
        ImageView imageView2 = new ImageView(image);
        imageView2.setFitHeight(100);
        imageView2.setFitWidth(100);
        pane.getChildren().add(imageView2);
        ImageView imageView3 = new ImageView(image);
        imageView3.setRotate(90);
        pane.getChildren().add(imageView3);
        Scene scene = new Scene(pane);
        stage.setTitle("Show images");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void bindingDemo() {
        DoubleProperty d1 = new SimpleDoubleProperty(1);
        DoubleProperty d2 = new SimpleDoubleProperty(2);
        // unidirectional binding
        d1.bind(d2);
        System.out.println("d1="+d1.getValue()+", d2="+d2.getValue());
        System.out.println("Changing d2 into 30");
        d2.setValue(30);
        System.out.println("d1="+d1.getValue()+", d2="+d2.getValue());
    }
}

class MyEllipse extends Pane {
    private void paint() {
        getChildren().clear();
        int nr = 20;
        for (int i = 0; i < nr; i++) {
            Ellipse ellipse = new Ellipse(getWidth() / 2, getHeight() / 2, getWidth()/4 - 50, getHeight()/4 - 50);
            ellipse.setStroke(Color.color(Math.random(), Math.random(), Math.random()));
            ellipse.setFill(Color.WHITE);
            ellipse.setRotate(i * 180./nr);
            getChildren().add(ellipse);
        }
    }
    @Override
    public void setWidth(double width) {
        // override it so that every time we change to size of the Pane, ellipses get painted
        super.setWidth(width);
        paint();
    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}