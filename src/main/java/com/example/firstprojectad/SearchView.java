package com.example.firstprojectad;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class SearchView extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        // creates the scene and sets it size
        FXMLLoader fxmlLoader = new FXMLLoader(SearchView.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("FXML Loader");
        stage.setScene(scene);
        stage.show();
    }
}





