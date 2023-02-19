package edu.bsu.css222.searchview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

public class Controller {


    public TextField userInput;

    @FXML
    public void onSearch(ActionEvent actionEvent) {
        String articleSearch = userInput.getText();
    }
}