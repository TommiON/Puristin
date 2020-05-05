package io;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileManagerTest {
    private static short[] testShorts;
    private static String testText;
    private static byte[] testBytes;

    @Before
    public void init() {
        testShorts = new short[3];
        testShorts[0] = 9;
        testShorts[1] = 600;
        testShorts[2] = 1234;

        testText = "Testitekstiä. \n Useammalla rivillä";

        testBytes = new byte[5];
        testBytes[0] = (byte)1;
        testBytes[1] = (byte)250;
        testBytes[2] = (byte)110;
        testBytes[3] = (byte)64;
        testBytes[4] = (byte)99;
    }

    @Test
    public void testWriteAndReadShorts() {
        try {
            FileManager.writeShorts("test_shorts", testShorts);
        } catch (Exception e) {}

        try {
            short[] data = FileManager.readShorts("test_shorts");
            for (short s : data) {
                System.out.println(s);
            }
        } catch (Exception e) {}
    }

    @Test
    public void testWriteAndReadText() {
        try {
            FileManager.writeText("test_text.txt", testText);
        } catch (Exception e) {}

        try {
            String output = FileManager.readText("test_text.txt");
            System.out.println(testText);
        } catch (Exception e) {}
    }

    @Test
    public void testWriteAndReadBytes() {
        try {
            FileManager.writeBytes("test_bytes", testBytes);
        } catch (Exception e) {}

        try {
            byte[] output = FileManager.readBytes("test_bytes");
            for (byte b: output) {
                System.out.println(b);
            }
        } catch (Exception e) {}
    }
}