package edu.bsu.cs222;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class PrinterTest {
    @Test
    public void printTest() throws IOException {
        String articleSearch = "James";
        ArticleInfo info = new ArticleInfo(Finder.URLBuilder(articleSearch));
        info.JSONReader(Finder.URLBuilder(articleSearch));
    }



}
