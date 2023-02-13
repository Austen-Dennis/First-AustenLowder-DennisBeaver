package edu.bsu.cs222;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ErrorsTest {
    @Test
    public void testBlank(){
        String articleSearch = " ";
        Boolean resultBool = Errors.errorBlank(articleSearch);
        Assertions.assertFalse(resultBool);
    }

    @Test
    public void testNotBlank(){
        String articleSearch = "D";
        Boolean resultBool = Errors.errorBlank(articleSearch);
        Assertions.assertTrue(resultBool);
    }

    @Test
    public void testPageNotFound() throws IOException {
        String articleSearch = "OogityBoogityBoodlesITookYourNoodles";
        Boolean resultBool = Errors.pageNotFound(articleSearch);
        Assertions.assertTrue(resultBool);
    }

    @Test
    public void testPageFound() throws IOException {
        String articleSearch = "James";
        Boolean resultBool = Errors.pageNotFound(articleSearch);
        Assertions.assertFalse(resultBool);
    }
}
