package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class PrinterTest {

    @Test
    public void printUserTest() throws IOException {
        String testLine = "[\"SidP\",\"Leschnei\",\"AndreaStar\",\"DavidJHowe\",\"DavidJHowe\",\"Bkonrad\",\"Giulia Picchiotti\",\"Giulia Picchiotti\",\"Giulia Picchiotti\",\"Bovineboy2008\",\"MSG17\",\"Tkanus\",\"Helpfuleditor101\",\"Luokehao\",\"Davidgoodheart\",\"Davidgoodheart\",\"Bkonrad\",\"SebastionArtCal\",\"Llammakey\",\"Tassedethe\",\"Bkonrad\",\"Danno uk\",\"Geo Swan\",\"Jamacfarlane\",\"MusikBot II\",\"Materialscientist\",\"Materialscientist\"]";
        String jsonLine = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json").toString();
        Printer print = new Printer(jsonLine);
        Assertions.assertEquals(jsonLine, testLine);

    }

}
