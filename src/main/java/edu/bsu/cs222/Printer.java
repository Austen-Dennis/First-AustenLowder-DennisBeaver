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
    public void JSONDataFormat(URL url) throws IOException {
        String inline = "";
        Scanner sc = new Scanner(url.openStream());
        while(sc.hasNext())
        {
            inline+=sc.nextLine();
        }
        JSONArray user = (JSONArray) JsonPath.read(inline, "$..user");
        System.out.println(user);
        JSONArray timestamp = (JSONArray) JsonPath.read(inline, "$..timestamp");
        System.out.println(timestamp);
        JSONArray revision = (JSONArray) JsonPath.read(inline, "$..revisions");
        System.out.println(revision);

        sc.close();
    }
}

