package fx.basics.fxbasics;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the exercise number you want to run: ");
        int exerciseNr = scanner.nextInt();
        switch (exerciseNr) {
            case 4:
                colorAndFont(stage);
                break;
            case 5:
                charactersAroundCircle(stage);
                break;
            case 6:
                displayCheckerboard(stage);
                break;
            case 7:
                random0Or1(stage);
                break;
            case 9:
                displayTaichi(stage);
                break;
            case 18:
                displayCubeFunction(stage);
                break;
            default:
                System.out.println("Exercise not available, feel free to help!");
                System.exit(0);
        }
        stage.show();
    }

    private void displayCubeFunction(Stage stage) {
        
    }

    private void displayTaichi(Stage stage) {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 4; i++) {
            Taichi taichi = new Taichi(100, 100, 80);
            gridPane.add(taichi, i%2, i/2);
        }
        gridPane.setPadding(new Insets(15, 15, 15, 15));
        gridPane.setHgap(20);
        gridPane.setVgap(20);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.setTitle("Taichi");
    }

    private void random0Or1(Stage stage) {
        GridPane pane = new GridPane();
        for (int i = 0; i < 100; i++) {
            TextField textField = new TextField();
            textField.setPrefSize(25, 25);
            textField.setText(Math.random() > 0.5 ? "1" : "0");
            textField.setAlignment(Pos.CENTER);
            pane.add(textField, i%10, i/10);
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Random 0 or 1 in Text Field");
    }

    private void displayCheckerboard(Stage stage) {
        GridPane pane = new GridPane();
        boolean isWhite = true;
        for (int i = 0; i < 64; i++) {
            Rectangle rectangle = new Rectangle(50, 50);
            if (isWhite)
                rectangle.setStyle("-fx-fill: white");
            else
                rectangle.setStyle("-fx-fill: black");
            if (i%8 != 7)
                isWhite = !isWhite;
            pane.add(rectangle,i%8, i/8);
        }
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Checkerboard");
    }

    private void charactersAroundCircle(Stage stage) {
        Pane pane = new Pane();
        String str = "JavaFX Learning ";
        Font font = Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 20);
        double angle = 0;
        double angleStep = 360. / str.length();
        double rotation = 10;
        double x, y;
        double radius = 75;
        for (int i = 0; i < str.length(); i++) {
            x = 225 + radius * Math.sin(Math.toRadians(angle)); // or degrees × π/180 either way is the same
            y = 225 - radius * Math.cos(Math.toRadians(angle));
            Text text = new Text(x, y, String.valueOf(str.charAt(i)));
            text.setFont(font);
            // you might skip rotation if you wish
            text.setRotate(rotation);
            pane.getChildren().add(text);
            angle += angleStep;
        }
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Characters around circle");
    }

    private void colorAndFont(Stage stage) {
        HBox hBox = new HBox();
        String str = "JavaFX";
        for (int i = 0; i < 5; i++) {
            Text text = new Text(str);
            Font font = Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 24.);
            text.setFont(font);
            text.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            text.setRotate(90);
            hBox.getChildren().add(text);
        }
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(20);
        Scene scene = new Scene(hBox, 500, 200);
        stage.setScene(scene);
        stage.setTitle("Color and Font exercise");
    }

    public static void main(String[] args) {
        launch();
    }
}