package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;

public class FinderTest {


    @Test
    public void testJames() throws IOException {
        String articleSearch = "James";
        Finder jamesGunn = new Finder();
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James&rvprop=timestamp|user&rvlimit=27&redirects");
    }
    @Test
    public void testJamesGunn() throws IOException {
        String articleSearch = "James Gunn";
        Finder jamesGunn = new Finder();
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James%20Gunn&rvprop=timestamp|user&rvlimit=27&redirects");
    }
    @Test
    public void testJSON() throws IOException {
        Finder parser = new Finder();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
        String timestamp = parser.parse(testDataStream);
        Assertions.assertEquals("2023-01-28T10:41:39Z", timestamp);
    }

}