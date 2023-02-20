package edu.bsu.cs222;
import java.io.IOException;


public class Printer {
    public Printer() {

    }

        public boolean printNoPageFound(String articleSearch) throws IOException {
            boolean errorStatus = Errors.pageNotFound(articleSearch);
            if (errorStatus) {
                System.out.print("Page not found: exiting program");
                System.exit(0);
            }
            return true;
        }
        public void printNetworkError(){
            System.out.println("Could not connect to server: exiting program");
            System.exit(0);

        }
        public boolean printNoPageRequested(String articleSearch){
            boolean errorStatus = Errors.errorBlank(articleSearch);
            if (errorStatus) {
                System.out.println("No page requested: exiting program");
                System.exit(0);
            }
            return true;
        }
}






