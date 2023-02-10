package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Errors {
    public static Boolean errorBlank(String articleSearch) {
        if (articleSearch.equals("")) {
            return false;
        } else return true;
    }

    public static boolean pageNotFound(String articleSearch) throws IOException {
        URL url = Finder.URLBuilder(articleSearch);
        InputStream inputStream = Finder.connector(url);
        InputStream finalInput = Printer.JSONDataFormat(inputStream);
        if (String.valueOf(finalInput).equals("{\"batchcomplete\":\"\",\"query\":{\"pages\":{\"-1\":{\"ns\":0,\"title\":\"" + articleSearch + "\",\"missing\":\"\"}}}}")) {
            return true;
        }

        return false;
    }
    }