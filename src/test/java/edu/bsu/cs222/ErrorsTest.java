package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ErrorsTest {
    @Test
    public void testBlank() throws IOException {
        String articleSearch = "";
        ErrorsTest blank = new ErrorsTest();
        Boolean resultBool = Boolean.valueOf(Errors.errorBlank(articleSearch));
        Assertions.assertFalse(resultBool);
    }

    @Test
    public void testNotBlank() throws IOException {
        String articleSearch = "D";
        ErrorsTest blank = new ErrorsTest();
        Boolean resultBool = Boolean.valueOf(Errors.errorBlank(articleSearch));
        Assertions.assertTrue(resultBool);
    }

    @Test
    public void testPageNotFound() throws IOException {
        String articleSearch = "OogityBoogityBoodlesITookYourNoodles";
        ErrorsTest notFound = new ErrorsTest();
        Boolean resultBool = Boolean.valueOf(Errors.pageNotFound(articleSearch));
        Assertions.assertTrue(resultBool);
    }

    @Test
    public void testPageFound() throws IOException {
        String articleSearch = "James";
        ErrorsTest notFound = new ErrorsTest();
        Boolean resultBool = Boolean.valueOf(Errors.pageNotFound(articleSearch));
        Assertions.assertFalse(resultBool);
    }
}
