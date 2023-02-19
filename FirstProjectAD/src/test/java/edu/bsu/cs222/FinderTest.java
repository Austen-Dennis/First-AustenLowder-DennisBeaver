package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class FinderTest {


    @Test
    public void testJames() throws IOException {
        String articleSearch = "James";
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James&rvprop=timestamp|user&rvlimit=27&redirects");
    }
    @Test
    public void testJamesGunn() throws IOException {
        String articleSearch = "James Gunn";
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James+Gunn&rvprop=timestamp|user&rvlimit=27&redirects");
    }
}