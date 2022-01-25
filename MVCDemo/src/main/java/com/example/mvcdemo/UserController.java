package com.example.mvcdemo;

import javafx.collections.ObservableList;

public class UserController {
    public UserController(UserView userView) {
        addEventListener(userView);
    }

    private void addEventListener(UserView userView) {
        userView.getSaveBtn().setOnAction(e -> {
            String username = userView.getUsernameField().getText();
            String password = userView.getPasswordField().getText();
            Role role = userView.getRoleComboBox().getValue();
            User newUser = new User(username, password, role);
            newUser.create();
            userView.getUsernameField().clear();
            userView.getPasswordField().clear();
            userView.getRoleComboBox().setValue(Role.LIBRARIAN);
        });
        userView.getDeleteBtn().setOnAction(e -> {
            ObservableList<Integer> selectedIndices = userView.getTableView().getSelectionModel().getSelectedIndices();
            User.deleteIndices(selectedIndices);
        });
    }


}
