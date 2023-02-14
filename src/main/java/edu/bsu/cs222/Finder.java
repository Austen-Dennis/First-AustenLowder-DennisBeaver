package edu.bsu.cs222;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Finder {
    private static Printer print = new Printer();
    public Finder(String articleSearch) throws IOException {
        new ArticleInfo(Finder.URLBuilder(articleSearch));
    }
    public static URL URLBuilder(String articleSearch) throws IOException {
        String articleName = articleSearch.replace(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                            + articleName +"&rvprop=timestamp|user&rvlimit=27&redirects");
        connector(url);
        return url;
    }
    public static void connector(URL url) {
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
