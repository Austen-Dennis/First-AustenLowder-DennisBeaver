package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArticleInfo {
    private String jsonLine = " ";
    private List<String> userList = new ArrayList<String>();
    private List<String> timestampList = new ArrayList<String>();
    private List<String> revisionList = new ArrayList<String>();

    public ArticleInfo(String articleSearch) throws IOException {
        JSONReader(Finder.URLBuilder(articleSearch));
        getUserList(jsonLine);
        getRevisionList(jsonLine);
        getTimestampListList(jsonLine);
        new Printer();


    }

    public String JSONReader(URL url) throws IOException {
        Scanner sc = new Scanner(url.openStream());
        while (sc.hasNext()) {
            jsonLine += sc.nextLine();
        }
        sc.close();
        return jsonLine;
    }

    public List getRevisionList(String jsonLine) {
        JSONArray revision = (JSONArray) JsonPath.read(jsonLine, "$..revisions");
        for (int i = 0; i < revision.size(); i++) {
            revisionList.add((String) revision.get(i));
        }
        return revisionList;
    }
    public List getUserList(String jsonLine) {
        JSONArray user = (JSONArray) JsonPath.read(jsonLine, "$..user");
        for (int i = 0; i < user.size(); i++) {
            userList.add((String) user.get(i));
        }
        return userList;
    }
    public List getTimestampListList(String jsonLine) {
        JSONArray timestamp = ((JSONArray) JsonPath.read(jsonLine, "$..timestamp"));
        for (int i = 0; i < timestamp.size(); i++) {
            timestampList.add((String) timestamp.get(i));
        }
        return timestampList;
    }
}


