package com.example.mvcdemo;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        UserView userView = new UserView();
        new UserController(userView);
        Parent root = userView.getPain();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("User MVC");
        primaryStage.show();
    }
}
