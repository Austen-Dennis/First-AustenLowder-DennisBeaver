package com.example.firstprojectad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

import static edu.bsu.cs222.ArticleInfo.*;
import static edu.bsu.cs222.ArticleInfo.revisionList;
import edu.bsu.cs222.Finder;

public class Controller {
    @FXML
    public TextField searchValue;

    @FXML
    public void onSearch(ActionEvent actionEvent) throws IOException {
        String articleSearch = searchValue.getText();
        new Finder(articleSearch);
            for (int user : userList.keySet()) {
                System.out.print(user + 1 + " ");
                // formats timestamplist as it iterates and prints out a proper date
                System.out.print("Date: " + timestampList.get(user).toString().replace("T", "     Time: ").replace("Z", "") + "     ");
                System.out.print("Name: " + userList.get(user) + " ");
                System.out.println();
            }
            System.out.println();
            System.out.println("Redirected to: " + redirect(articleSearch));
            System.out.println("All revisions: " + revisionList);
            System.exit(0);

        }
}