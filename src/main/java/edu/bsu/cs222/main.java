package edu.bsu.cs222;


import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner search = new Scanner(System.in);
        System.out.println("Provide an article name:");
        String searchValue = search.nextLine();

        if(searchValue.equals("")) {
            Printer.printNoPageRequested();
        }
            else{
            new Finder(searchValue);

        }
    }
}
