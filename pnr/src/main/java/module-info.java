module pnr {
    requires javafx.controls;
    requires javafx.fxml;

    opens pnr to javafx.fxml;
    exports pnr;
}
