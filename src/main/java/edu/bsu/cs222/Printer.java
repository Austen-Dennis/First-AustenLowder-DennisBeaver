package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Printer {
    public Printer(String articleSearch) throws IOException {
        JSONDataFormat(Finder.URLBuilder(articleSearch));

    }
    public static void JSONDataFormat(URL url) throws IOException {
        String jsonLine = "";
        Scanner sc = new Scanner(url.openStream());
        while(sc.hasNext())
        {
            jsonLine+=sc.nextLine();
        }
        JSONArray user = (JSONArray) JsonPath.read(jsonLine, "$..user");
        System.out.println(user);
        JSONArray timestamp = (JSONArray) JsonPath.read(jsonLine, "$..timestamp");
        System.out.println(timestamp);
        JSONArray revision = (JSONArray) JsonPath.read(jsonLine, "$..revisions");
        System.out.println(revision);

        sc.close();
    }
}

