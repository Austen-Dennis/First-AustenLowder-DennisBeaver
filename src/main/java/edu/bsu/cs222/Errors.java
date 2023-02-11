package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;

import static edu.bsu.cs222.Finder.URLBuilder;

public class Errors {
    public static Boolean errorBlank(String articleSearch) {
        if (articleSearch.equals("")) {
            return false;
        } else return true;
    }

    public static void pageNotFound(String articleSearch) throws IOException {
        InputStream inputStream = Finder.connector(URLBuilder(articleSearch));
        //Printer.JSONDataFormat(URLBuilder(articleSearch));
    }
}
