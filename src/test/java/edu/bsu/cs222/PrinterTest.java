package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class PrinterTest {

    @Test
    public void printUserTest() throws IOException {
        String articleSearch = " ";
        Printer printed = new Printer(articleSearch);
        String testLine = "[]";
        String result = printed.getUserList(articleSearch);
        Assertions.assertEquals(testLine,result);

    }
    @Test
    public void printUserTestNegative() throws IOException {
        String articleSearch = " ";
        Printer printed = new Printer(articleSearch);
        String testLine = "[User]";
        String result = printed.getUserList(articleSearch);
        Assertions.assertEquals(testLine,result);

    }
    @Test
    public void printTimestampTest() throws IOException {
        String articleSearch = " ";
        Printer printed = new Printer(articleSearch);
        String testLine = "[]";
        String result = printed.getTimestampListList(articleSearch);
        Assertions.assertEquals(testLine,result);
    }
    @Test
    public void printRevisionsTest() throws IOException {
        String articleSearch = " ";
        Printer printed = new Printer(articleSearch);
        String testLine = "[]";
        String result = printed.getTimestampListList(articleSearch);
        Assertions.assertEquals(testLine,result);
    }

}
