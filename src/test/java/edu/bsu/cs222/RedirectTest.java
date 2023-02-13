package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RedirectTest {
    @Test
    public void testRedirect() throws IOException {
        String articleSearch = "Zappa";
        String resultString = ArticleInfo.redirect(articleSearch);
        Assertions.assertEquals(resultString, "[[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}]]");
    }
    @Test
    public void testNotRedirect() throws IOException {
        String articleSearch = "Frank Zappa";
        String resultStringEmpty = ArticleInfo.redirect(articleSearch);
        Assertions.assertEquals(resultStringEmpty, "[]");
    }
}
