package com.example.clockpane;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock extends Pane {
    private int second;
    private int minute;
    private int hour;

    public Clock() {
        setCurrentTime();
    }

    public Clock(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    private void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
        paintClock();
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
        paintClock();
    }

    private void paintClock() {
        // clock parameters
        double clockRadius = Math.min(getWidth(), getHeight() * 0.8 * 0.5);
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        // circle
        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        // line to show seconds
        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength * Math.sin(getSecond() * (2 * Math.PI / 60));
        double secondY = centerY - sLength * Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.GREEN);

        // line to show minutes
        double mLength = clockRadius * 0.65;
        double minuteX = centerX + mLength * Math.sin(getMinute() * (2 * Math.PI / 60));
        double minuteY = centerY - mLength * Math.cos(getMinute() * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, minuteX, minuteY);
        mLine.setStroke(Color.RED);

        // line to show hours
        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength * Math.sin((hour % 12 + minute / 60.) * (2*Math.PI/12));
        double hourY = centerY - hLength * Math.cos((hour%12 + minute / 60.) * (2*Math.PI/12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.BLUE);

        getChildren().clear();
        getChildren().addAll(
                circle,
                t1, t2, t3, t4,
                sLine, mLine, hLine
        );
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
        paintClock();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
        paintClock();
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paintClock();
    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paintClock();
    }
}
