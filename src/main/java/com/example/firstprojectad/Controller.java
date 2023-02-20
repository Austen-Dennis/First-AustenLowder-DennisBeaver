package com.example.firstprojectad;

import edu.bsu.cs222.Errors;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import static edu.bsu.cs222.ArticleInfo.*;
import edu.bsu.cs222.Finder;

public class Controller {
    @FXML
    public TextField searchValue;
    @FXML
    public TextArea TextBox;
    @FXML
    public void onSearch() throws IOException {
        String articleSearch = searchValue.getText();
        TextBox.clear();
        TextBox.appendText("Recent edits for \"" + articleSearch + "\":");
        TextBox.appendText("\n");
        //tests for those errors and then prints out this statement in the box
        if (Errors.errorBlank(articleSearch)) {
            TextBox.appendText("Please exit system: no page requested");
        } else if (Errors.pageNotFound(articleSearch)) {
            TextBox.appendText("Please exit system: no page found");
        } else {
            new Finder(articleSearch);

            for (int user : userList.keySet()) {
                TextBox.appendText(user + 1 + " ");
                TextBox.appendText("Date: " + timestampList.get(user).toString().replace("T", "     Time: ").replace("Z", "") + "     ");
                TextBox.appendText("Name: " + userList.get(user) + " ");
                TextBox.appendText("\n");
            }
            TextBox.appendText("\n");
            TextBox.appendText("Redirected to: " + redirect(articleSearch));
        }
    }

    public void onExit() {
        System.exit(0);
    }
}