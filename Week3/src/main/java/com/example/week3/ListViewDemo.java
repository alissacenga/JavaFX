package com.example.week3;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {
    private final ListView<State> stateListView = new ListView<>();
    public ListViewDemo() {
        State[] states = new State[]{
                new State("Ukraine", "ukraine.jpeg", "Ukraine description"),
                new State("Germany", "germany.png", "Germany description"),
                new State("Albania", "albania.png", "Albania description"),
                new State("Belarus", "belarus.png", "Belarus description"),
        };
        stateListView.setItems(FXCollections.observableArrayList(states));
        // in order to select multiple options in the list view
        stateListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        stateListView.setPrefSize(200, 400);
    }
    @Override
    public void start (Stage stage) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(10));
        FlowPane imagePane = new FlowPane();
        imagePane.setAlignment(Pos.CENTER);
        imagePane.setPadding(new Insets(10));
        imagePane.setOrientation(Orientation.VERTICAL);
        Label label = new Label("Select Countries", stateListView);
        label.setContentDisplay(ContentDisplay.BOTTOM);
        hBox.getChildren().addAll(label, imagePane);
        // observable property
        stateListView.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                imagePane.getChildren().clear();
                for (State state: stateListView.getSelectionModel().getSelectedItems())
                    imagePane.getChildren().add(state.getFlag());
            }
        });
        Scene scene =  new Scene(hBox, 400, 500);
        stage.setScene(scene);
        stage.setTitle("List view demo");
        stage.show();
    }
}
