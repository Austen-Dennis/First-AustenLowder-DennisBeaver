package edu.bsu.cs222;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ArticleInfoTest {
    @Test
    public void testRedirect() throws IOException {
        String articleSearch = "Zappa";
        String resultString = ArticleInfo.redirect(articleSearch);
        Assertions.assertEquals("[[{\"from\":\"Zappa\",\"to\":\"Frank Zappa\"}]]", resultString );
    }
    @Test
    public void testNotRedirect() throws IOException {
        String articleSearch = "Frank Zappa";
        String resultStringEmpty = ArticleInfo.redirect(articleSearch);
        Assertions.assertEquals(resultStringEmpty, "[]");
    }
    @Test
    public void getUserInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(Finder.URLBuilder(articleSearch));
        String testLine = "{}";
        String result = info.getUserList(articleSearch).toString();
        Assertions.assertEquals(testLine, result);
    }
    @Test
    public void getUserInfoTestNegative() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(Finder.URLBuilder(articleSearch));
        String testLine = "[User]";
        String result = info.getUserList(articleSearch).toString();
        Assertions.assertNotEquals(testLine, result);

    }
    @Test
    public void getTimestampInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(Finder.URLBuilder(articleSearch));
        String testLine = "{}";
        String result = info.getTimestampList(articleSearch).toString();
        Assertions.assertEquals(testLine,result);
    }
    @Test
    public void getRevisionsInfoTest(){
        String articleSearch = " ";
        String testLine = "{}";
        String result = ArticleInfo.getRevisionList(articleSearch).toString();
        Assertions.assertEquals(result,testLine);
    }
}
