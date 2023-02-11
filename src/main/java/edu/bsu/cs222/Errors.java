package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Errors {
    public static Boolean errorBlank(String articleSearch) {
        if (articleSearch.equals("")) {
            return false;
        } else return true;
    }

    public static boolean pageNotFound(String articleSearch) throws IOException {
        String jsonLine = "";
        Scanner findMissing = new Scanner(Finder.URLBuilder(articleSearch).openStream());
        while(findMissing.hasNext())
        {
            jsonLine+=findMissing.nextLine();
        }
        JSONArray missing = (JSONArray) JsonPath.read(jsonLine, "$..missing");
        System.out.println(missing);
        if (missing.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    }

