package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class Parser {
    public Parser(){

    }
    public String timestampParse(InputStream testDataStream) throws IOException {
        JSONArray result =  JsonPath.read(testDataStream, "$..timestamp");
        return result.get(0).toString();
    }

    public String userParse(InputStream testDataStream) throws IOException {
        JSONArray result =  JsonPath.read(testDataStream, "$..user");
        return result.get(0).toString();
    }
}
