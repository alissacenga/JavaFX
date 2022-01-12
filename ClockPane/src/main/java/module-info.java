module com.example.clockpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.clockpane to javafx.fxml;
    exports com.example.clockpane;
}