package com.example.mvcdemo;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class User {
    private static final ObservableList<User> users = FXCollections.observableArrayList(
            new User("Bingus", "1234", Role.LIBRARIAN),
            new User("Cheems", "1234", Role.MANAGER),
            new User("Floppa", "123pass", Role.ADMIN)
    );
    public static ObservableList<User> getUsers() {
        return users;
    }
    private final SimpleStringProperty username;
    private final SimpleStringProperty password;
    private final SimpleObjectProperty<Role> role;
    public User(String username, String password, Role role) {
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
        this.role = new SimpleObjectProperty<>(role);
    }

    public static void deleteIndices(ObservableList<Integer> selectedIndices) {
        // this is wrong solution
        // WHY? HOW to solve it?
        for(int i: selectedIndices)
            users.remove(i);
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public Role getRole() {
        return role.get();
    }

    public void setRole(Role role) {
        this.role.set(role);
    }
    public void create() {
        users.add(this);
    }
}
