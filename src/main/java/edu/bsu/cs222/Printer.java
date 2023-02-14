package edu.bsu.cs222;
import java.io.IOException;
import java.util.HashMap;

public class Printer {

    public Printer() {

    }

    public void printAll(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList, String redirect){
        // increments through both userlist and timestamplist hashmaps using keys to print the value.
        for (int user : userList.keySet()) {
            System.out.print(user + 1 + " ");
            // formats timestamplist as it iterates and prints out a proper date
            System.out.print("Date: " + timestampList.get(user).toString().replace("T", "     Time: ").replace("Z", "") + "     ");
            System.out.print("Name: " + userList.get(user) + " ");
            System.out.println();
        }
        //prints out the redirect and the revision list hashmap.
        System.out.println();
        System.out.println("Redirected to: " + redirect);
        System.out.println("All revisions: " + revisionList);
        System.exit(0);
        }
        public void printNoPageFound(String articleSearch) throws IOException {
            // checks for the error status by calling to errors and then prints out the statement if the error is found.
            boolean errorStatus = Errors.pageNotFound(articleSearch);
            if (errorStatus) {
                System.out.print("Page not found: exiting program");
                System.exit(0);
            }
        }
        public void printNetworkError(){
            //prints out this statement if the contention errors out.
            System.out.println("Could not connect to server: exiting program");
            System.exit(0);
        }
        public void printNoPageRequested(String articleSearch){
        //checks if it errors out then returns the statement if it does.
            boolean errorStatus = Errors.errorBlank(articleSearch);
            if (errorStatus) {
                System.out.println("No page requested: exiting program");
                System.exit(0);
            }
        }
}






