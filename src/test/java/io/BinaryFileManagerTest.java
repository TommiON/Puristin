package io;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryFileManagerTest {

    @Test
    public void writesAndReadsOK() {
        byte[] bytesIn = {0,1,-128,127,1,2,3,4};
        try {
            BinaryFileManager.writeBytesToFile("testBinary", bytesIn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] bytesOut = new byte[bytesIn.length];
        try {
            bytesOut = BinaryFileManager.readBytesFromFile("testBinary");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(byte b : bytesOut) {
            System.out.print((int) b + ", ");
        }

        assertEquals(bytesIn[0], bytesOut[0]);
    }

}