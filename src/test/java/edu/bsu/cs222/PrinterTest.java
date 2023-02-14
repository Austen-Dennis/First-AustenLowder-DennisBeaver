package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrinterTest {

    @Test
    public void printTest(){
        String testLine = "Redirected to: []\n" + "All revisions: {}";
        Printer printTest = new Printer();
        Assertions.assertEquals(testLine, printTest);
    }



}
