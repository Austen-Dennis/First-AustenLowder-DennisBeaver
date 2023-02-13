package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArticleInfo {
    private String jsonLine = " ";
    HashMap<Integer, Object> revisionList = new HashMap<Integer, Object>();
    HashMap<Integer, Object> userList = new HashMap<Integer, Object>();
    HashMap<Integer, Object> timestampList = new HashMap<Integer, Object>();

    public ArticleInfo(URL url) throws IOException {
        JSONReader(url);
        getUserList(jsonLine);
        getTimestampList(jsonLine);
        new Printer(userList,timestampList,revisionList);
    }

    public String JSONReader(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            jsonLine += sc.nextLine();
        }
        sc.close();
        return jsonLine;
    }

    public HashMap<Integer, Object> getRevisionList(String jsonLine) {

        JSONArray revision = (JSONArray) JsonPath.read(jsonLine, "$..revisions");
        for (int i = 0; i < revision.size(); i++) {
            revisionList.put(i, revision.get(i));
        }
        return revisionList;
    }
    public HashMap<Integer, Object> getUserList(String jsonLine) {

        JSONArray user = (JSONArray) JsonPath.read(jsonLine, "$..user");
        for (int i = 0; i < user.size(); i++) {
            userList.put(i , user.get(i));

        }
        return userList;
    }
    public HashMap<Integer, Object> getTimestampList(String jsonLine) {
        JSONArray timestamp = (JSONArray) JsonPath.read(jsonLine, "$..timestamp");
        for (int i = 0; i < timestampList.size(); i++) {
            timestampList.put(i, timestamp.get(i));
            System.out.println(timestampList.get(i));
        }
        return timestampList;
    }
}


