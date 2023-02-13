package edu.bsu.cs222;
import java.util.HashMap;

public class Printer {

    public Printer(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList) {
        printALl(userList,timestampList);
    }
    public void printALl(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList){
        for (int user : userList.keySet()) {
            System.out.print(user + " ");
            System.out.print(userList.get(user) + " ");
            System.out.print(timestampList.get(user) + " ");
            System.out.println();
        }
        }
    }






