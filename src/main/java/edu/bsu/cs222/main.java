package edu.bsu.cs222;


import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("What article would you like to search for?");
        String articleSearch = input.nextLine();
        Finder.URLBuilder(articleSearch);
    }
}
