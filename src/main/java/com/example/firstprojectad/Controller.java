package com.example.firstprojectad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import static edu.bsu.cs222.ArticleInfo.*;
import static edu.bsu.cs222.ArticleInfo.revisionList;
import edu.bsu.cs222.Finder;
import edu.bsu.cs222.Errors;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import org.w3c.dom.Text;


import javax.print.attribute.standard.Media;

public class Controller {
    @FXML
    public TextField searchValue;
    @FXML
    public TextArea TextBox;

    @FXML
    public void onSearch(ActionEvent actionEvent) throws IOException {
        String articleSearch = searchValue.getText();

        //Boolean ErrorCheck2 = Errors.pageNotFound(articleSearch);
        //Boolean ErrorCheck3 = Errors.connectionError(Finder.URLBuilder(articleSearch));
        TextBox.clear();
        if (Errors.errorBlank(articleSearch) == true) {
            TextBox.appendText("Blank Search.");
        } else if (Errors.connectionError(Finder.URLBuilder(articleSearch)) == false) {
            TextBox.appendText("Connection Error.");
        } else if (Errors.pageNotFound(articleSearch) == true) {
            TextBox.appendText("Page not found.");
        } else {
            TextBox.appendText("Recent edits for \"" + articleSearch + "\":");
            TextBox.appendText("\n");
            new Finder(articleSearch);
            for (int user : userList.keySet()) {
                TextBox.appendText(user + 1 + ". ");
                TextBox.appendText("Date: " + timestampList.get(user).toString().replace("T", "     Time: ").replace("Z", "") + "     ");
                TextBox.appendText("Name: " + userList.get(user) + " ");
                TextBox.appendText("\n");
            }
            TextBox.appendText("\n");
            TextBox.appendText("Redirected to: " + redirect(articleSearch));
        }
    }
}