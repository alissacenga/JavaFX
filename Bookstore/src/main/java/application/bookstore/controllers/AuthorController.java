package application.bookstore.controllers;

import application.bookstore.models.Author;
import application.bookstore.models.User;
import application.bookstore.views.AuthorView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class AuthorController {
    private AuthorView authorView;
    public AuthorController(AuthorView authorView) {
        this.authorView = authorView;
        setSaveListener();
        setDeleteListener();
        setSearchListener();
        setEditListener();
    }

    private void setEditListener() {

        authorView.getTableView().getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            System.out.println(newSelection);
        });

        authorView.getEditBtn().setOnAction(e -> {
            System.out.println(authorView.getTableView().focusModelProperty().get().getFocusedItem());
            for(Author author: authorView.getTableView().getItems())
                System.out.println(author);
        });
    }

    private void setSearchListener() {
        authorView.getClearBtn().setOnAction(e -> {
            authorView.getSearchField().setText("");
            authorView.getTableView().setItems(FXCollections.observableArrayList(Author.getAuthors()));
        });
        authorView.getSearchBtn().setOnAction(e -> {
            String searchText = authorView.getSearchField().getText();
            ArrayList<Author> searchResults = Author.getSearchResults(searchText);
            authorView.getTableView().setItems(FXCollections.observableArrayList(searchResults));
        });
    }

    private void setDeleteListener() {
        authorView.getDeleteBtn().setOnAction(e -> {
            ObservableList<Author> authorsInTable = authorView.getTableView().getItems();
            ObservableList<Integer> indices = authorView.getTableView().getSelectionModel().getSelectedIndices();
            for (int index: indices)
                authorsInTable.get(index).deleteFromFile();
            authorView.getTableView().setItems(FXCollections.observableArrayList(Author.getAuthors()));
            authorView.getResultLabel().setTextFill(Color.DARKGREEN);
            authorView.getResultLabel().setText("Authors deleted successfully!");
        });
    }

    private void setSaveListener() {
        authorView.getSaveBtn().setOnAction(e -> {
            String firstName = authorView.getFirstNameField().getText();
            String lastName = authorView.getLastNameField().getText();
            Author author = new Author(firstName, lastName);
            if (author.saveInFile()){
                authorView.getTableView().getItems().add(author);
                authorView.getResultLabel().setText("Author created successfully!");
                authorView.getResultLabel().setTextFill(Color.DARKGREEN);
                authorView.getFirstNameField().setText("");
                authorView.getLastNameField().setText("");
            }
            else {
                authorView.getResultLabel().setText("Author creation failed!");
                authorView.getResultLabel().setTextFill(Color.DARKRED);
            }

        });
    }

}
