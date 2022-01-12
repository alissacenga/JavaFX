module fx.basics.fxbasics {
    requires javafx.controls;
    requires javafx.fxml;


    opens fx.basics.fxbasics to javafx.fxml;
    exports fx.basics.fxbasics;
}