package edu.bsu.cs222;

import com.jayway.jsonpath.DocumentContext;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.ByteArrayInputStream;


public class SearchView extends Application {
    public static void main(String[] args){ launch(args); }

    private final Button searchButton = new Button("Search");
    private final Label searchLabel = new Label("Enter your search:");
    private final Label outputLabel = new Label("Revisions:");
    private final TextField searchField = new TextField();
    private final TextArea outputField = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        configureInterface(primaryStage);
    }

    private void configureInterface(Stage stage){
        stage.setTitle("Wikipedia Revision Parser");
        stage.setScene(new Scene(userInterface()));
        stage.show();
    }

    private Pane userInterface() {
        VBox interfaceVBox = new VBox();
        interfaceVBox.setPrefSize(400,500);

        configureLabelStyle();
        configureOutputField();

        interfaceVBox.getChildren().addAll(
                searchLabel, searchField, searchButton,
                outputLabel, outputField);

        return interfaceVBox;
    }

    private void configureLabelStyle(){
        searchLabel.setFont(Font.font("Calibri", 15));
        outputLabel.setFont(Font.font("Calibri", 15));
    }

    private void configureOutputField(){
        outputField.setPrefSize(400, 400);
        outputField.setEditable(false);
        outputField.setWrapText(true);
    }

    protected String noLineFoundCheck(){
        if (searchField.getText().isEmpty()){
            throw new Error("User did not provide an input");
        } return searchField.getText();
    }


    }


