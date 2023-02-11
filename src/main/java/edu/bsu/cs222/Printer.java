package edu.bsu.cs222;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Printer {
    public Printer(String articleSearch) throws IOException {
        JSONDataFormat(Finder.connector(Finder.URLBuilder(articleSearch)));

    }
    public void JSONDataFormat(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}

