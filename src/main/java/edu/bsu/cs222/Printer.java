package edu.bsu.cs222;


import java.util.HashMap;
import java.util.Map;

public class Printer {
    public Printer(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList) {
        printALl(userList,timestampList,revisionList);
    }
    public void printALl(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList){
        for( Map.Entry<Integer, Object> entry : userList.entrySet()){
            for(Map.Entry<Integer, Object> entry1 : timestampList.entrySet()){

            }
        }
    }
}







