package fx.basics.fxbasics;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

public class Taichi extends Pane {
    private double centerX;
    private double centerY;
    private double radius;
    public Taichi(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        paint();
    }

    private void paint() {
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setStyle("-fx-fill: white; -fx-stroke: black");
        getChildren().add(circle);
        double startAngle = 30;
        for (int i = 0; i < 4; i++) {
            Arc arc = new Arc(centerX, centerY, radius - 10, radius - 10, startAngle + i*90, radius/2);
            arc.setStyle("-fx-fill: black; -fx-stroke: black");
            arc.setType(ArcType.ROUND);
            getChildren().add(arc);
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        paint();
    }

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
        paint();
    }

    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
        paint();
    }
}
