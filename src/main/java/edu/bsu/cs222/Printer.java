package edu.bsu.cs222;
import java.io.IOException;
import java.util.HashMap;

public class Printer {

    public Printer() {

    }

    public void printAll(HashMap<Integer, Object> userList, HashMap<Integer, Object> timestampList, HashMap<Integer, Object> revisionList, String redirect){
        for (int user : userList.keySet()) {
            System.out.print(user + 1 + " ");
            System.out.print(userList.get(user) + " ");
            System.out.print(timestampList.get(user) + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Redirected to: " + redirect);
        System.out.println("All revisions: " + revisionList);
        }
        public static void printNoPageFound(String articleSearch) throws IOException {
            boolean errorNote = Errors.pageNotFound(articleSearch);
            if (errorNote == true) {
                System.out.print("Page not found: exiting program");
                System.exit(0);
            }
        }
        public void printNetworkError() throws IOException {
                System.out.println("Could not connect to server: exiting program");
                System.exit(0);
            }

        public static void printNoPageRequested(String articleSearch) throws IOException {
            boolean errorNote = Errors.errorBlank(articleSearch);
            if (errorNote == true) {
                System.out.println("No page requested: exiting program");
                System.exit(0);
            }
        }
}






