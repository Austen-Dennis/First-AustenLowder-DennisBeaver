package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.util.Scanner;

public class Errors {
    public static Boolean errorBlank(String articleSearch) {
        return !articleSearch.equals(" ");
    }

    public static boolean pageNotFound(String articleSearch) throws IOException {
        String jsonLine = "";
        Scanner findMissing = new Scanner(Finder.URLBuilder(articleSearch).openStream());
        while(findMissing.hasNext())
        {
            jsonLine+=findMissing.nextLine();
        }
        JSONArray missing = JsonPath.read(jsonLine, "$..missing");
        System.out.println(missing);
        return !missing.isEmpty();
    }
    }

