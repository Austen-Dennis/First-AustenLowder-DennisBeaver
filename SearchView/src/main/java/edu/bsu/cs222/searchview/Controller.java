package edu.bsu.cs222.searchview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    public TextField searchValue;


    @FXML
    public void onSearch(ActionEvent actionEvent) {
        String articleSearch = searchValue.getText();
        System.out.println(articleSearch);
    }
}