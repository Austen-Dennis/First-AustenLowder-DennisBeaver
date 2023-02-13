package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class ArticleInfo {
    private String jsonLine = " ";

    HashMap<Integer, Object> revisionList = new HashMap<>();
    HashMap<Integer, Object> userList = new HashMap<>();
    HashMap<Integer, Object> timestampList = new HashMap<>();

    public ArticleInfo(URL url) throws IOException {
        JSONReader(url);
        getUserList(jsonLine);
        getTimestampList(jsonLine);
        new Printer(userList,timestampList);
    }

    public void JSONReader(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            jsonLine += sc.nextLine();
        }
        sc.close();
    }

    public HashMap<Integer, Object> getRevisionList(String jsonLine) {

        JSONArray revision = JsonPath.read(jsonLine, "$..revisions");
        for (int i = 0; i < revision.size(); i++) {
            revisionList.put(i, revision.get(i));
        }
        return revisionList;
    }
    public HashMap<Integer, Object> getUserList(String jsonLine) {

        JSONArray user = JsonPath.read(jsonLine, "$..user");
        for (int i = 0; i < user.size(); i++) {
            userList.put(i , user.get(i));

        }
        return userList;
    }
    public HashMap<Integer, Object> getTimestampList(String jsonLine) {
        JSONArray timestamp = JsonPath.read(jsonLine, "$..timestamp");
        for (int i = 0; i < timestamp.size(); i++) {
            timestampList.put(i, timestamp.get(i));
        }
        return timestampList;
    }
}


