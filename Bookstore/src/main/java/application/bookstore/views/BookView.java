package application.bookstore.views;

import application.bookstore.models.Author;
import application.bookstore.models.Book;
import application.bookstore.ui.CreateButton;
import application.bookstore.ui.DeleteButton;
import application.bookstore.ui.EditButton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class BookView extends View{
    private final BorderPane borderPane = new BorderPane();
    private final TableView<Book> tableView = new TableView<>();
    private final HBox formPane = new HBox();
    private final TextField isbnField = new TextField();
    private final TextField titleField = new TextField();
    private final TextField purchasedPriceField = new TextField();
    private final TextField sellingPrice = new TextField();
    private final ComboBox<Author> authorsComboBox = new ComboBox<>();
    private final Button saveBtn = new CreateButton();
    private final Button deleteBtn = new DeleteButton();
    private final Button editBtn = new EditButton();
    private final TableColumn<Book, String> isbnCol = new TableColumn<>("ISBN");
    private final TableColumn<Book, String> titleCol = new TableColumn<>("Title");
    private final TableColumn<Book, Float> purchasedPriceCol = new TableColumn<>("Purchased Price");
    private final TableColumn<Book, Float> sellingPriceCol = new TableColumn<>("Selling Price");
    private final Label resultLabel = new Label("");
    private final SearchView searchView = new SearchView("Search for a book");

    public TableView<Book> getTableView() {
        return tableView;
    }

    public TextField getIsbnField() {
        return isbnField;
    }

    public TextField getTitleField() {
        return titleField;
    }

    public TextField getPurchasedPriceField() {
        return purchasedPriceField;
    }

    public TextField getSellingPrice() {
        return sellingPrice;
    }

    public ComboBox<Author> getAuthorsComboBox() {
        return authorsComboBox;
    }

    public Button getSaveBtn() {
        return saveBtn;
    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public Button getEditBtn() {
        return editBtn;
    }

    public TableColumn<Book, String> getIsbnCol() {
        return isbnCol;
    }

    public TableColumn<Book, String> getTitleCol() {
        return titleCol;
    }

    public TableColumn<Book, Float> getPurchasedPriceCol() {
        return purchasedPriceCol;
    }

    public TableColumn<Book, Float> getSellingPriceCol() {
        return sellingPriceCol;
    }

    public Label getResultLabel() {
        return resultLabel;
    }

    public SearchView getSearchView() {
        return searchView;
    }

    public BookView() {
        setTableView();
        setForm();
        // inject the controller
    }

    private void setForm() {
        formPane.setPadding(new Insets(20));
        formPane.setSpacing(20);
        formPane.setAlignment(Pos.CENTER);
        Label isbnLabel = new Label("ISBN: ", isbnField);
        isbnLabel.setContentDisplay(ContentDisplay.TOP);
        Label titleLabel = new Label("Title: ", titleField);
        titleLabel.setContentDisplay(ContentDisplay.TOP);
        Label purchasedPriceLabel = new Label("Purchased price", purchasedPriceField);
        purchasedPriceLabel.setContentDisplay(ContentDisplay.TOP);
//        formPane.getChildren().addAll(firstNameLabel, lastNameLabel, saveBtn, deleteBtn, editBtn);
    }

    private void setTableView() {
    }


    @Override
    public Parent getView() {
        return null;
    }
}
