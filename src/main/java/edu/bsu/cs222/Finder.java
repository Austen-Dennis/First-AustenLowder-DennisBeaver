package edu.bsu.cs222;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Finder {

    public Finder() throws IOException {
        URL url = new URL("https://en.wikipedia.org");
        URLConnection connection = url.openConnection();
        connection.setRequestProperty("User-Agent","Revision Reporter/0.1 (me@bsu.edu)");
        InputStream inputStream = connection.getInputStream();
    }
}
