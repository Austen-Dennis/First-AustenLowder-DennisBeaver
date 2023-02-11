package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Printer {
    private String jsonLine = "";
    public Printer(String articleSearch) throws IOException {
        JSONReader(Finder.URLBuilder(articleSearch));
        JSONDataFormat(jsonLine);

    }
    public String JSONReader(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        while(sc.hasNext())
        {
            jsonLine+=sc.nextLine();
        }
        sc.close();
        return jsonLine;
    }
    public static void JSONDataFormat(String jsonLine) throws IOException {

        JSONArray user = (JSONArray) JsonPath.read(jsonLine, "$..user");
        System.out.println(user);
        JSONArray timestamp = (JSONArray) JsonPath.read(jsonLine, "$..timestamp");
        System.out.println(timestamp);
        JSONArray revision = (JSONArray) JsonPath.read(jsonLine, "$..revisions");
        System.out.println(revision);
    }
}

