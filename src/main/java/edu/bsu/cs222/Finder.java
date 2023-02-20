package edu.bsu.cs222;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


public class Finder {
    // calls an instance of the class printer to test articleSearch for errors
    //private static final Printer print = new Printer();
    public Finder(String articleSearch) throws IOException {
        new ArticleInfo(Finder.URLBuilder(articleSearch));
    }
    public static URL URLBuilder(String articleSearch) throws IOException {
        //encodes the url to avoid issues with special characters.
        String articleName = URLEncoder.encode(articleSearch, StandardCharsets.UTF_8);
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                            + articleName +"&rvprop=timestamp|user&rvlimit=27&redirects");
        return url;
    }
    public static void connector(URL url) {
        // checks that the connection works and if it does it will print a network error.
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection)url.openConnection();
        } catch (IOException e) {
            //print.printNetworkError();
        }
        assert connection != null;
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (austen.lowder@bsu.edu)");
        try {
            connection.connect();
        } catch (IOException e) {
            //print.printNetworkError();
        }
    }


}
