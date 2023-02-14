package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class ArticleInfo {
    private static String jsonLine = " ";

    static HashMap<Integer, Object> revisionList = new HashMap<>();
    private HashMap<Integer, Object> userList = new HashMap<>();
    private HashMap<Integer, Object> timestampList = new HashMap<>();

    public ArticleInfo(URL url) throws IOException {
        JSONReader(url);
        getUserList(jsonLine);
        getTimestampList(jsonLine);
        getRevisionList(jsonLine);
        Printer printer = new Printer();
        printer.printAll(userList,timestampList, revisionList,redirect(jsonLine));
    }

    public static void JSONReader(URL url) throws IOException {
        // loops through the JSON data and grabs all lines.
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            jsonLine += sc.nextLine();
        }
        sc.close();
    }

    public static HashMap<Integer, Object> getRevisionList(String jsonLine) {
        //Specifically grabs the revisions data from the JSON data and puts it in a hashmap
        JSONArray revision = JsonPath.read(jsonLine, "$..revisions");
        for (int i = 0; i < revision.size(); i++) {
            revisionList.put(i, revision.get(i));
        }
        return revisionList;
    }
    public HashMap<Integer, Object> getUserList(String jsonLine) {
        //Specifically grabs the userList data from the JSON data and puts it in a hashmap
        JSONArray user = JsonPath.read(jsonLine, "$..user");
        for (int i = 0; i < user.size(); i++) {
            userList.put(i , user.get(i));

        }
        return userList;
    }
    public HashMap<Integer, Object> getTimestampList(String jsonLine) {
        //Specifically grabs the timestamp data from the JSON data and puts it in a hashmap
        JSONArray timestamp = JsonPath.read(jsonLine, "$..timestamp");
        for (int i = 0; i < timestamp.size(); i++) {
            timestampList.put(i, timestamp.get(i));

        }
        return timestampList;
    }
    public static String redirect(String articleSearch) throws IOException {
        //finds the redirect line within the JSON data and returns it as string.
        Scanner findRedirect = new Scanner(Finder.URLBuilder(articleSearch).openStream());
        while(findRedirect.hasNext())
        {
            jsonLine+=findRedirect.nextLine();
        }
        JSONArray redirects = JsonPath.read(jsonLine, "$..redirects");
        jsonLine = " ";
        return redirects.toString();


    }
}


