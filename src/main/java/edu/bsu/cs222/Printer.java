package edu.bsu.cs222;
import java.util.HashMap;

public class Printer {

    public Printer(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList) {
        printALl(userList,timestampList,revisionList);
    }
    public void printALl(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList){
        for (int user : userList.keySet()) {
            System.out.print(user + " ");
            System.out.print(userList.get(user) + " ");
            System.out.print(timestampList.get(user) + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("All revisions: " + revisionList);
        }
    }






