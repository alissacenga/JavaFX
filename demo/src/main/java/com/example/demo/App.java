package com.example.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Button okBtn = new Button("Ok");
        Button cancelBtn = new Button("Cancel");
        hBox.getChildren().addAll(okBtn, cancelBtn);
        OkHandler okHandler = new OkHandler();
        CancelHandler cancelHandler = new CancelHandler();
        okBtn.setOnAction(okHandler);
        cancelBtn.setOnAction(cancelHandler);
        Scene scene = new Scene(hBox);
        stage.setScene(scene);
        stage.show();
    }
}

class OkHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle (ActionEvent e) {
        System.out.println(e.getTarget());
        System.out.println("Ok button clicked");
    }
}

class CancelHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle (ActionEvent e){
        System.out.println(e.getTarget());
        System.out.println("Cancel button clicked");
    }
}
