package edu.bsu.cs222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class Printer {
    public Printer() throws IOException {

    }
    public void JSONDataFormat(URLConnection connection) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine + "\n" );
        in.close();
    }
}

