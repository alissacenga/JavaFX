package com.example.mvcdemo;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class UserView {
    private final BorderPane pane = new BorderPane();
    private final TableView<User> tableView = new TableView<>();
    private final TextField usernameField = new TextField();
    private final PasswordField passwordField = new PasswordField();
    private final ComboBox<Role> roleComboBox = new ComboBox<>();
    private final Button saveBtn = new Button("Save");
    private final Button deleteBtn = new Button("Delete");

    public TableView<User> getTableView() {
        return tableView;
    }

    public Button getDeleteBtn(){
        return deleteBtn;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public ComboBox<Role> getRoleComboBox() {
        return roleComboBox;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public UserView() {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setItems(User.getUsers());
        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setMinWidth(100);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn<User, String> passwordColumn = new TableColumn<>("Password");
        passwordColumn.setMinWidth(100);
        passwordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        TableColumn<User, Role> roleColumn = new TableColumn<>("Role");
        roleColumn.setMinWidth(100);
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
        tableView.getColumns().addAll(usernameColumn, passwordColumn, roleColumn);
        setPain();
    }

    private void setPain() {
        HBox hBox = getHBoxPane();
        pane.setCenter(tableView);
        pane.setBottom(hBox);
    }
    public BorderPane getPain() {
        return pane;
    }

    private HBox getHBoxPane() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(15));
        hBox.setSpacing(15);

        roleComboBox.getItems().addAll(Role.ADMIN, Role.MANAGER, Role.LIBRARIAN);
        // default role
        roleComboBox.setValue(Role.LIBRARIAN);

        Label usernameLabel = new Label("Username", usernameField);
        Label passwordLabel = new Label("Password", passwordField);
        Label roleLabel = new Label("Role", roleComboBox);
        hBox.getChildren().addAll(usernameLabel, passwordLabel, roleLabel, saveBtn, deleteBtn);
        return hBox;
    }
}
