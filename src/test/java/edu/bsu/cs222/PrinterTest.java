package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;

public class PrinterTest {
    @Test
    public void JSONFormattedDataTest() throws IOException {
        InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jsonFormattedPrint.json");
        Printer printTest = new Printer();
        Assertions.assertEquals(dataStream, printTest);
    }
}
