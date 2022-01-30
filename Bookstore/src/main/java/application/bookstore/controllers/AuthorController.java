package application.bookstore.controllers;

import application.bookstore.models.Author;
import application.bookstore.views.AuthorView;

public class AuthorController {
    private AuthorView authorView;
    public AuthorController(AuthorView authorView) {
        this.authorView = authorView;
        setListener();
    }

    private void setListener() {
        authorView.getSaveBtn().setOnAction(e -> {
            System.out.println("Save btn");
            String firstName = authorView.getFirstNameField().getText();
            String lastName = authorView.getLastNameField().getText();
            Author author = new Author(firstName, lastName);
            if (author.saveInFile()){
                authorView.getTableView().getItems().add(author);
                authorView.getResultLabel().setText("Author created successfully!");
            }
            else
                authorView.getResultLabel().setText("Author creation failed!");
        });
    }

}
