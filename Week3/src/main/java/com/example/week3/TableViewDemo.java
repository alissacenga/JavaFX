package com.example.week3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        ObservableList<User> users = FXCollections.observableArrayList(
          new User("Bingus", "1234", Role.LIBRARIAN),
          new User("Cheems", "1234", Role.MANAGER),
          new User("Floppa", "123pass", Role.ADMIN)
        );
        TableView<User> tableView = new TableView<>();
        tableView.setItems(users);

        TableColumn usernameColumn = new TableColumn("Username");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("username")
        );

        TableColumn passwordColumn = new TableColumn("Password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("password")
        );

        TableColumn roleColumn = new TableColumn("Role");
        roleColumn.setMinWidth(100);
        roleColumn.setCellValueFactory(
                new PropertyValueFactory<User, String>("role")
        );

        tableView.getColumns().addAll(usernameColumn, passwordColumn, roleColumn);

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(15);

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        ComboBox<Role> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll(Role.ADMIN, Role.MANAGER, Role.LIBRARIAN);
        // default role
        roleComboBox.setValue(Role.LIBRARIAN);
        Button saveBtn = new Button("Save", new ImageView("icon.png"));
        Label usernameLabel = new Label("Username", usernameField);
        Label passwordLabel = new Label("Password", passwordField);
        Label roleLabel = new Label("Role", roleComboBox);
        hBox.getChildren().addAll(usernameLabel, passwordLabel, roleLabel, saveBtn);
        
        saveBtn.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            Role role = roleComboBox.getValue();
            User newUser = new User(username, password, role);
            users.add(newUser);
            usernameField.clear();
            passwordField.clear();
            roleComboBox.setValue(Role.LIBRARIAN);
        });

        pane.setCenter(tableView);
        pane.setBottom(hBox);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Table demo");
        stage.show();
    }
}
