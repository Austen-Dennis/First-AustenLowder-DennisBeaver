package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Finder {

    public Finder() throws IOException {
        String articleSearch = " ";
        new Printer(articleSearch);
    }
    public static URL URLBuilder(String articleSearch) throws IOException {
        String articleName = articleSearch.replace(" ", "%20");
        URL url = new URL("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles="
                            + articleName +"&rvprop=timestamp|user&rvlimit=27&redirects");
        connector(url);
        return url;
    }
    public static InputStream connector(URL url) throws IOException {
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent", "Revision Reporter/0.1 (austen.lowder@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
        return inputStream;
    }
    public String parse(InputStream testDataStream) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream, "$..timestamp");
        return result.get(0).toString();
    }
}
