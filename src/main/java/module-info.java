module eu.cz.aratta {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
//    requires poi.ooxml.schemas;

    opens eu.cz.aratta.controller to javafx.fxml;
    exports eu.cz.aratta;
}