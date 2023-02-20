package edu.bsu.cs222;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Printer {
private int secondsToSleep = 10;
    public Printer() {

    }

        public boolean printNoPageFound(String articleSearch) throws IOException {
            // checks for the error status by calling to errors and then prints out the statement if the error is found.
            boolean errorStatus = Errors.pageNotFound(articleSearch);
            if (errorStatus) {
                System.out.print("Page not found: exiting program");
                try {
                    TimeUnit.SECONDS.sleep(secondsToSleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.exit(0);
            }
            return true;
        }
        public boolean printNetworkError(){
            //prints out this statement if the contention errors out.
            System.out.println("Could not connect to server: exiting program");
            try {
                TimeUnit.SECONDS.sleep(secondsToSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.exit(0);

            return true;
        }
        public boolean printNoPageRequested(String articleSearch){
        //checks if it errors out then returns the statement if it does.
            boolean errorStatus = Errors.errorBlank(articleSearch);
            if (errorStatus) {
                System.out.println("No page requested: exiting program");
                try {
                    TimeUnit.SECONDS.sleep(secondsToSleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.exit(0);
            }
            return true;
        }
}






