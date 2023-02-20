package com.example.firstprojectad;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

import static edu.bsu.cs222.ArticleInfo.*;

public class SearchView extends Application {
    public static void main(String[]args){
        launch();
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchView.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("FXML Loader");
        stage.setScene(scene);
        stage.show();
        Button btn = new Button();
        btn.setText("Search Article");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                for (int user : userList.keySet()) {
                    System.out.print(user + 1 + " ");
                    // formats timestamplist as it iterates and prints out a proper date
                    System.out.print("Date: " + timestampList.get(user).toString().replace("T", "     Time: ").replace("Z", "") + "     ");
                    System.out.print("Name: " + userList.get(user) + " ");
                    System.out.println();
                }
                System.out.println();
                System.out.println("Redirected to: " + redirect(searchValue));
                System.out.println("All revisions: " + revisionList);
                System.exit(0);

            }
        });
    }
}





