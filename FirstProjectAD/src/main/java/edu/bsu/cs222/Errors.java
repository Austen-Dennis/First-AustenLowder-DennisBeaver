package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Errors {
    public static Boolean errorBlank(String articleSearch) {
        if(articleSearch.equals("")){
            return true;

        }else if(articleSearch.equals(" ")){
            return true;
        }
        return false;
    }

    public static boolean pageNotFound(String articleSearch) throws IOException {
        StringBuilder jsonLine = new StringBuilder();
        Scanner findMissing = new Scanner(Finder.URLBuilder(articleSearch).openStream());
        while(findMissing.hasNext())
        {
            jsonLine.append(findMissing.nextLine());
        }
        JSONArray missing = JsonPath.read(jsonLine.toString(), "$..missing");
        return !missing.isEmpty();
    }
    public static boolean connectionError(URL url) {
        boolean connectionStatus;
        try {
            URLConnection connection = url.openConnection();
            connection.connect();
            connectionStatus = true;
        } catch (IOException e) {
            connectionStatus = false;
        }
        return connectionStatus;
    }
    }

