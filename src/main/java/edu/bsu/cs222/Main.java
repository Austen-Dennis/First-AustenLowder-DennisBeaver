package edu.bsu.cs222;


import java.io.IOException;
import java.util.Scanner;

import static edu.bsu.cs222.ArticleInfo.*;


public class Main {


    public static void main(String[] args) throws IOException {
        // takes input then goes to finder to check for errors etc.
        Scanner search = new Scanner(System.in);
        System.out.println("Provide an article name:");
        String searchValue = search.nextLine();
        if (Errors.errorBlank(searchValue)) {
            System.out.println("System exit: no page requested");
        } else if (Errors.pageNotFound(searchValue)) {
            System.out.println("System exit: no page found");
        } else {
            new Finder(searchValue);
            // increments through both userlist and timestamplist hashmaps using keys to print the value.
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
    }
}