module eu.cz.aratta {
    requires javafx.controls;
    requires javafx.fxml;

    opens eu.cz.aratta to javafx.fxml;
    exports eu.cz.aratta;
}