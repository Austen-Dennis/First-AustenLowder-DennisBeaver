package edu.bsu.cs222;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Finder {

    public Finder() throws IOException {
        String articleSearch = " ";
        new ArticleInfo(Finder.URLBuilder(articleSearch));
    }
    public static URL URLBuilder(String articleSearch) throws IOException {
        String articleName = articleSearch.replace(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                            + articleName +"&rvprop=timestamp|user&rvlimit=27&redirects");

        connector(url);
        return url;
    }
    public static void connector(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (austen.lowder@bsu.edu)");
        connection.connect();
    }

}
