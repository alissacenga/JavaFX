package application.bookstore.views;

import application.bookstore.models.Role;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MainView extends View {

    @Override
    public Parent getView() {
        BorderPane borderPane = new BorderPane();
        TabPane tabPane = new TabPane();
        Tab adminTab = new Tab("Admin");
        adminTab.setContent(new AuthorView().getView());
        Tab librarianTab = new Tab("Librarian");
        librarianTab.setContent(new StackPane(new Rectangle(200, 200)));
        Tab managerTab = new Tab("Manager");
        managerTab.setContent(new StackPane(new Ellipse(200, 100)));
        Role currentRole = (getCurrentUser() != null ? getCurrentUser().getRole() : null);
        if (currentRole != null) {
            if (currentRole == Role.ADMIN)
                tabPane.getTabs().add(adminTab);
            if (currentRole == Role.MANAGER || currentRole == Role.ADMIN)
                tabPane.getTabs().add(managerTab);
            tabPane.getTabs().add(librarianTab);
        }
        borderPane.setTop(tabPane);
        borderPane.setCenter(new StackPane(new Text(getCurrentUser().getUsername() + ", welcome to our bookstore")));
        return borderPane;
    }
}
