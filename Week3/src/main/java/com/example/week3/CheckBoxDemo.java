package com.example.week3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CheckBoxDemo extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));

        String fontFamily = "Times New Roman";
        int fontSize = 25;
        Font defaultFont = Font.font(fontFamily, FontWeight.NORMAL, FontPosture.REGULAR, fontSize);

        Label label = new Label("This just a random text");
        label.setFont(defaultFont);

        VBox vBox = new VBox();
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10));
        CheckBox checkBoxItalic = new CheckBox("Italic");
        CheckBox checkBoxBold = new CheckBox("Bold");
        vBox.getChildren().addAll(checkBoxBold, checkBoxItalic);
        vBox.setStyle("-fx-border-color: red; -fx-border-width: 4px");
        vBox.setAlignment(Pos.CENTER);

        VBox colorsPane = new VBox();
        colorsPane.setAlignment(Pos.CENTER_LEFT);
        colorsPane.setSpacing(5);
        colorsPane.setPadding(new Insets(10));
        colorsPane.setStyle("-fx-border-color: red; -fx-border-width: 4px");
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton redButton = new RadioButton("Red");
        RadioButton blueButton = new RadioButton("Blue");
        RadioButton greenButton = new RadioButton("Green");
        redButton.setToggleGroup(toggleGroup);
        blueButton.setToggleGroup(toggleGroup);
        greenButton.setToggleGroup(toggleGroup);
        colorsPane.getChildren().addAll(redButton, blueButton, greenButton);

        Label inputLabel = new Label("Enter text: ");
        TextField textField = new TextField();
        textField.setPromptText("Type sth ...");
        inputLabel.setGraphic(textField);
        inputLabel.setContentDisplay(ContentDisplay.RIGHT);
        StackPane stackPane = new StackPane(inputLabel);

        pane.setCenter(label);
        pane.setRight(vBox);
        pane.setLeft(colorsPane);
        pane.setTop(stackPane);

        // lambda expression saved in a variable
        EventHandler<ActionEvent> handler = event -> {
            if (checkBoxBold.isSelected() && checkBoxItalic.isSelected())
                label.setFont(Font.font(fontFamily, FontWeight.BOLD, FontPosture.ITALIC, fontSize));
            else if (checkBoxBold.isSelected())
                label.setFont(Font.font(fontFamily, FontWeight.BOLD, FontPosture.REGULAR, fontSize));
            else if (checkBoxItalic.isSelected())
                label.setFont(Font.font(fontFamily, FontWeight.NORMAL, FontPosture.ITALIC, fontSize));
            else
                label.setFont(defaultFont);
        };

        checkBoxBold.setOnAction(handler);
        checkBoxItalic.setOnAction(handler);
        redButton.setOnAction(e -> label.setTextFill(Color.RED));
        blueButton.setOnAction(e -> label.setTextFill(Color.BLUE));
        greenButton.setOnAction(e -> label.setTextFill(Color.GREEN));
        textField.setOnAction(e -> label.setText(textField.getText()));


        Scene scene = new Scene(pane, 600, 200);
        stage.setScene(scene);
        stage.setTitle("Checkbox demo");
        stage.show();
    }
}
