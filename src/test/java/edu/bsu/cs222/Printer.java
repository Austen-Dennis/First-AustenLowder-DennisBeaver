package edu.bsu.cs222;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class Printer {
    @Test
    public void JSONFormattedDataTest(){
        InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");

    }
}
