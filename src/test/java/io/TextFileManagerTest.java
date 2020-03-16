package io;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class TextFileManagerTest {

    @Test
    public void writeSucceedsWithCorrectParameters() throws IOException {
        try {
            TextFileManager.writeCharactersToFile("testText.txt", "1234");
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}