module com.example.firstprojectad {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires json.path;
    requires json.smart;

    opens com.example.firstprojectad to javafx.fxml;
    exports com.example.firstprojectad;
}