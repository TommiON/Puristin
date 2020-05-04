package io;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ByteBufferTest {

    static ArrayList testInts;
    static ByteBuffer testBuffer1, testBuffer2;

    @Before
    public void init() {
        testInts = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            testInts.add(i);
        }
        testBuffer1 = new ByteBuffer();
        testBuffer2 = new ByteBuffer();
    }

    /*
    @Test
    public void pushesIntsCorrectly() {
        testBuffer1.pushIntegers(testInts);
        System.out.println( testBuffer1.toString());
        //Todo: assertit
    }

    @Test
    public void getsIntsCorrectly() {
        testBuffer1.pushIntegers(testInts);
        System.out.println(testBuffer1.toString());
        ArrayList<Integer> output = testBuffer1.getBytesAsIntegers();
        System.out.println(output.toString());
        assertEquals(testBuffer1.getBytes().length, output.size());
    }

    @Test
    public void writesIntsToFileCorrectly() {
        testBuffer1.pushIntegers(testInts);
        testBuffer1.writeToFile("test_ints.lwz");
    }

    @Test
    public void initsFromFileCorrectly() {
        testBuffer1.pushIntegers(testInts);
        testBuffer1.writeToFile("test_ints.lwz");

        testBuffer2 = new ByteBuffer("test_ints.lwz");
        System.out.println(testBuffer2);
    }
    */


}