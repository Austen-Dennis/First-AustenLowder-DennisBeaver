package edu.bsu.cs222;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class SearchView extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        stage.setTitle("FXML Welcome");

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}