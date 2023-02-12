package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ArticleInfoTest {
    @Test
    public void getUserInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(articleSearch);
        String testLine = "[]";
        String result = info.getUserList(articleSearch);
        Assertions.assertEquals(testLine,result);

    }
    @Test
    public void getUserInfoTestNegative() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(articleSearch);
        String testLine = "[User]";
        String result = info.getUserList(articleSearch);
        Assertions.assertEquals(testLine,result);

    }
    @Test
    public void getTimestampInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(articleSearch);
        String testLine = "[]";
        String result = info.getTimestampListList(articleSearch);
        Assertions.assertEquals(testLine,result);
    }
    @Test
    public void getRevisionsInfoTest() throws IOException {
        String articleSearch = " ";
        ArticleInfo info = new ArticleInfo(articleSearch);
        String testLine = "[]";
        String result = info.getTimestampListList(articleSearch);
        Assertions.assertEquals(testLine,result);
    }
}
