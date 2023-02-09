package edu.bsu.cs222;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Finder {

    public Finder() throws IOException {
        String articleSearch = " ";
        URLBuilder(articleSearch);

    }


    public static URL URLBuilder(String articleSearch) throws IOException {
        String articleName = articleSearch.replace(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" + articleName +"=timestamp|user&rvlimit=27&redirects");
        conncector(url);
        return url;
    }
    public static void conncector(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (austen.lowder@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
    }


}
