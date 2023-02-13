package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ArticleInfoTest {
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
    public void getRevisionsInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(Finder.URLBuilder(articleSearch));
        String testLine = "{}";
        String result = info.getRevisionList(articleSearch).toString();
        Assertions.assertEquals(result,testLine);
    }
    @Test
    public void testRedirect() throws IOException {
        String articleSearch = "Zappa";
        String resultString = ArticleInfo.redirect();
        Assertions.assertEquals();
    }
    @Test
    public void testNotRedirect() throws IOException {
        String articleSearch = "Frank Zappa";
        Boolean resultBool = Boolean.valueOf(ArticleInfo.redirect(articleSearch));
        Assertions.assertFalse(resultBool);
    }
}
