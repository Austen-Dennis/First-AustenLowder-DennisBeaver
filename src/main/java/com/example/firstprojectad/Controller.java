package com.example.firstprojectad;

import edu.bsu.cs222.Errors;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import static edu.bsu.cs222.ArticleInfo.*;
import edu.bsu.cs222.Finder;

import javax.swing.*;


public class Controller {
    @FXML
    public TextField searchValue;
    @FXML
    public TextArea TextBox;
    @FXML
    public void onSearch() throws IOException {
        String articleSearch = searchValue.getText();
        TextBox.clear();
        JFrame Error;
        Error = new JFrame();
        //tests for those errors and then prints out this statement in the box
        if (!Errors.connectionError(Finder.URLBuilder(articleSearch))) {
            JOptionPane.showMessageDialog(Error, "Please check connection or exit system: no connection","Connection Error",JOptionPane.WARNING_MESSAGE);
        } else if (Errors.errorBlank(articleSearch)) {
            JOptionPane.showMessageDialog(Error, "Please enter another article name or exit system: no page requested","Input Error",JOptionPane.WARNING_MESSAGE);
        } else if (Errors.pageNotFound(articleSearch)) {
            TextBox.appendText("Please enter another article name or exit system: no page found");
        } else {
            new Finder(articleSearch);
            TextBox.appendText("Recent edits for \"" + articleSearch + "\":");
            TextBox.appendText("\n");

            for (int user : userList.keySet()) {
                TextBox.appendText(user + 1 + " ");
                TextBox.appendText("Date: " + timestampList.get(user).toString().replace("T", "     \tTime: ").replace("Z", "") + "     ");
                TextBox.appendText("\tName: " + userList.get(user) + " ");
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