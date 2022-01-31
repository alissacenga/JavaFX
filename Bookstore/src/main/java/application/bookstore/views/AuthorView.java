package application.bookstore.views;

import application.bookstore.controllers.AuthorController;
import application.bookstore.models.Author;
import application.bookstore.ui.*;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AuthorView extends View{
    private final BorderPane borderPane = new BorderPane();
    private final TableView<Author> tableView = new TableView<>();
    private final HBox formPane = new HBox();
    private final TextField firstNameField = new TextField();
    private final TextField lastNameField = new TextField();
    private final TextField searchField = new TextField();
    private final Button searchBtn = new SearchButton();
    private final Button clearBtn = new ClearButton();
    private final Button saveBtn = new CreateButton();
    private final Button deleteBtn = new DeleteButton();
    private final Button editBtn = new EditButton();

    public Button getEditBtn() {
        return editBtn;
    }

    private final Label resultLabel = new Label("");


    public Button getClearBtn() {
        return clearBtn;
    }
    private final HBox searchPane = new HBox();



    public Button getSearchBtn() {
        return searchBtn;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Label getResultLabel() {
        return resultLabel;
    }

    public TableView<Author> getTableView() {
        return tableView;
    }

    public TextField getFirstNameField() {
        return firstNameField;
    }

    public TextField getLastNameField() {
        return lastNameField;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public AuthorView() {
        setTableView();
        setForm();
        setSearchForm();
        new AuthorController(this);
    }

    private void setSearchForm() {
        Label label = new Label("Search for a book in our bookstore", searchField);
        label.setContentDisplay(ContentDisplay.RIGHT);
        searchPane.setPadding(new Insets(20));
        searchPane.setSpacing(20);
        searchPane.setAlignment(Pos.CENTER);
        searchField.setPromptText("Type sth ...");
        searchPane.getChildren().addAll(label, searchBtn, clearBtn);
    }

    @Override
    public Parent getView() {
        borderPane.setCenter(tableView);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(5);
        vBox.getChildren().addAll(formPane, resultLabel);
        borderPane.setBottom(vBox);
        borderPane.setTop(searchPane);
        return borderPane;
    }

    private void setForm() {
        formPane.setPadding(new Insets(20));
        formPane.setSpacing(20);
        formPane.setAlignment(Pos.CENTER);
        Label firstNameLabel = new Label("First name: ", firstNameField);
        firstNameLabel.setContentDisplay(ContentDisplay.TOP);
        Label lastNameLabel = new Label("Last name: ", lastNameField);
        lastNameLabel.setContentDisplay(ContentDisplay.TOP);
        formPane.getChildren().addAll(firstNameLabel, lastNameLabel, saveBtn, deleteBtn, editBtn);
    }

    private void setTableView() {
        // select multiple records in order to delete them
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.setEditable(true);
        tableView.setItems(FXCollections.observableArrayList(Author.getAuthors()));
        TableColumn<Author, String> firstNameCol = new TableColumn<>("First name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());

        TableColumn<Author, String> lastNameCol = new TableColumn<>("Last name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableView.getColumns().addAll(firstNameCol, lastNameCol);
    }
}
