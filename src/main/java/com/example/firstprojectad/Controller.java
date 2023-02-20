package com.example.firstprojectad;

import edu.bsu.cs222.ArticleInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import edu.bsu.cs222.Finder;

import java.io.IOException;

public class Controller {
    @FXML
    public TextField searchValue;

    @FXML
    public void onSearch(ActionEvent actionEvent) throws IOException {
        String articleSearch = searchValue.getText();
    }
}