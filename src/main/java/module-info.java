module edu.bsu.cs222 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    uses com.jayway.jsonpath.JsonPath;
    uses net.minidev.json.JSONArray;
    requires json.path;
    requires json.smart;

    opens edu.bsu.cs222 to javafx.fxml;
    exports edu.bsu.cs222;
}