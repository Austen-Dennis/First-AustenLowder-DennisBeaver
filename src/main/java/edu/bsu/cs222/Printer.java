package edu.bsu.cs222;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Printer {
    private String jsonLine = " ";
    List<String> userList = new ArrayList<String>();
    List<String> timestampList = new ArrayList<String>();
    List<String> revisionList = new ArrayList<String>();

    public Printer(String articleSearch) throws IOException {
        JSONReader(Finder.URLBuilder(articleSearch));
        getUserList(getRevisionList(getTimestampListList(jsonLine)));


    }

    public String JSONReader(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            jsonLine += sc.nextLine();
        }
        sc.close();
        return jsonLine;
    }

    public String getRevisionList(String jsonLine) {
        JSONArray revision = (JSONArray) JsonPath.read(jsonLine, "$..revisions");
        for (int i = 0; i < revision.size(); i++) {
            revisionList.add((String) revision.get(i));
        }
        return revisionList.toString();
    }
    public String getUserList(String jsonLine) {
        JSONArray user = (JSONArray) JsonPath.read(jsonLine, "$..user");
        for (int i = 0; i < user.size(); i++) {
            userList.add((String) user.get(i));
        }
        return userList.toString();
    }
    public String getTimestampListList(String jsonLine) {
        JSONArray timestamp = ((JSONArray) JsonPath.read(jsonLine, "$..timestamp"));
        for (int i = 0; i < timestamp.size(); i++) {
            timestampList.add((String) timestamp.get(i));
        }
        return timestampList.toString();
    }
}

