package com.example.demo;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class ObservablePropertyDemo {
    public static void main(String[] args) {
        DoubleProperty property = new SimpleDoubleProperty(2);
        property.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("New value is " + property.getValue());
            }
        });
        property.setValue(5.2);
    }
}
