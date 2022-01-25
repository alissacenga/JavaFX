package com.example.week3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {
    private final ComboBox<State> stateComboBox = new ComboBox<>();
    private final TextArea descriptionField = new TextArea();
    private final ImageView flagImage = new ImageView();
    public ComboBoxDemo() {
        State[] states = new State[]{
                new State("Ukraine", "ukraine.jpeg", "Ukraine description"),
                new State("Germany", "germany.png", "Germany description"),
                new State("Albania", "albania.png", "Albania description"),
                new State("Belarus", "belarus.png", "Belarus description"),
        };
        stateComboBox.getItems().addAll(states);
        stateComboBox.setValue(states[0]);
        descriptionField.setText(states[0].getDescription());
        flagImage.setImage(states[0].getFlag().getImage());
        flagImage.setFitWidth(320);
        flagImage.setFitHeight(140);
    }
    @Override
    public void start (Stage stage) {
        BorderPane pane = new BorderPane();
        Label selectLabel = new Label("Select a country", stateComboBox);
        selectLabel.setContentDisplay(ContentDisplay.RIGHT);
        HBox hBox = new HBox(selectLabel);
        hBox.setAlignment(Pos.CENTER);
        pane.setTop(hBox);


        Label descriptionLabel = new Label("Description", descriptionField);
        descriptionLabel.setContentDisplay(ContentDisplay.BOTTOM);
        Button saveBtn = new Button("Save");
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10));
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(descriptionLabel, saveBtn);
        pane.setLeft(vBox);


        Label flagLabel = new Label("Flag", flagImage);
        flagLabel.setContentDisplay(ContentDisplay.BOTTOM);
        StackPane stackPane = new StackPane(flagLabel);
        pane.setRight(stackPane);

        stateComboBox.setOnAction(e -> changeValues());
        saveBtn.setOnAction(e -> stateComboBox.getValue().setDescription(descriptionField.getText()));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Combo box demo");
        stage.show();
    }

    private void changeValues() {
        State selectedState = stateComboBox.getValue();
        descriptionField.setText(selectedState.getDescription());
        flagImage.setImage(selectedState.getFlag().getImage());
    }
}

class State {
    private String name;
    private ImageView flag;
    private String description;
    public State(String name, String flagPath, String description) {
        this.name = name;
        this.description = description;
        this.setFlag(flagPath);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getFlag() {
        return flag;
    }

    public void setFlag(String flagPath) {
        Image image = new Image(flagPath);
        flag = new ImageView(image);
        flag.setFitWidth(160);
        flag.setFitHeight(70);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
