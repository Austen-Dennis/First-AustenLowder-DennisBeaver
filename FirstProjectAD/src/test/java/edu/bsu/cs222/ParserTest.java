package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ParserTest {
    @Test
    public void testTimestampJSON() throws IOException {
        Parser parser = new Parser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.timestampParse(testDataStream);
        Assertions.assertEquals("2023-01-28T10:41:39Z", timestamp);
    }

    @Test
    public void testUserJSON() throws IOException {
        Parser parser = new Parser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String user = parser.userParse(testDataStream);
        Assertions.assertEquals("Materialscientist", user);
    }

}
