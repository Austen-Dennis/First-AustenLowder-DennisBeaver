package edu.bsu.cs222;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Finder {
    // calls an instance of the class printer to test articleSearch for errors
    private static Printer print = new Printer();
    public Finder(String articleSearch) throws IOException {
        //checks for the errors stated above.
        print.printNoPageFound(articleSearch);
        print.printNoPageRequested(articleSearch);
        //calls to an instance of articleInfo to get data.
        new ArticleInfo(Finder.URLBuilder(articleSearch));

    }
    public static URL URLBuilder(String articleSearch) throws IOException {
        //replaces all spaces in articleSearch with is ASCII equivalent.
        String articleName = articleSearch.replace(" ", "%20");
        //creates the url
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                            + articleName +"&rvprop=timestamp|user&rvlimit=27&redirects");
        //calls to connector and passes the url.
        connector(url);
        return url;
    }
    public static void connector(URL url) {
        // checks that the connection works and if it does it will print a network error.
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            print.printNetworkError();
        }
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (austen.lowder@bsu.edu)");
        try {
            connection.connect();
        } catch (IOException e) {
            print.printNetworkError();
        }
    }

}
