package edu.bsu.cs222;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.net.URL;

public class FinderTest {


    @Test
    public void testJames() throws IOException {
        String articleSearch = "James";
        Finder jamesGunn = new Finder();
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James=timestamp|user&rvlimit=27&redirects");
    }
    @Test
    public void testJamesGunn() throws IOException {
        String articleSearch = "James Gunn";
        Finder jamesGunn = new Finder();
        String result = String.valueOf(Finder.URLBuilder(articleSearch));
        Assertions.assertEquals(result,"https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=James%20Gunn=timestamp|user&rvlimit=27&redirects");
    }

}