package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;


public class PrinterTest {

    @Test
    public void printNoPageFoundTest() throws IOException {
        Printer print = new Printer();
        String articleSearch = " ";
        boolean result = print.printNoPageFound(articleSearch);
        Assertions.assertTrue(result);

    }
    @Test
    public void printNoPageRequestedTest() {
        Printer print = new Printer();
        String articleSearch = " ";
        boolean result = print.printNoPageRequested(articleSearch);
        Assertions.assertTrue(result);

    }

}
