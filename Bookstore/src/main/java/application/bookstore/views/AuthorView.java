package application.bookstore.views;

import application.bookstore.controllers.AuthorController;
import application.bookstore.models.Author;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class AuthorView extends View{
    private final BorderPane borderPane = new BorderPane();
    private final TableView<Author> tableView = new TableView<>();
    private final HBox formPane = new HBox();
    private final TextField firstNameField = new TextField();
    private final TextField lastNameField = new TextField();
    private final Button saveBtn = new Button("Save");
    private final Label resultLabel = new Label("");

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
        new AuthorController(this);
    }
    @Override
    public Parent getView() {
        setTableView();
        setForm();
        borderPane.setCenter(tableView);
        borderPane.setBottom(formPane);
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
        formPane.getChildren().addAll(firstNameLabel, lastNameLabel, saveBtn);
    }

    private void setTableView() {
        tableView.setItems(FXCollections.observableArrayList(Author.getAuthors()));
        TableColumn<Author, String> firstNameCol = new TableColumn<>("First name");
        firstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );
        TableColumn<Author, String> lastNameCol = new TableColumn<>("Last name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );
        tableView.getColumns().addAll(firstNameCol, lastNameCol);
    }
}
