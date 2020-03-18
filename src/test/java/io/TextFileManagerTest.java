package io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TextFileManagerTest {

    @Test
    public void writesAndReadsOK() throws IOException {
        String textIn = "1234abcd";

        try {
            TextFileManager.writeCharactersToFile("testText.txt", textIn);
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        StringBuffer textOut = TextFileManager.readCharactersFromFile("testText.txt");

        System.out.println(textOut);
        assertEquals(textIn.length(), textOut.length());
    }

}