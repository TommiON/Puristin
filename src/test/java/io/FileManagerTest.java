package io;

import CustomDataStructures.BitSequence;
import HuffmanEngine.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

    /*
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

     */

    @Test
    public void testWriteAndReadBits() {
        String stringRepresentation = "111000111000111000111000111000111";
        System.out.println(stringRepresentation);
        BitSequence bitSequenceIn = new BitSequence(stringRepresentation);
        try {
            FileManager.writeBits("bit_test", bitSequenceIn);
        } catch (Exception e) {}

        try {
            BitSequence bitSequenceOut = FileManager.readBits("bit_test");
            System.out.println(bitSequenceOut.getAsString());
            assertEquals(bitSequenceIn.getBitAtIndex(0), bitSequenceOut.getBitAtIndex(0));
            assertEquals(bitSequenceIn.getBitAtIndex(7), bitSequenceIn.getBitAtIndex(7));
        } catch (Exception e) {}
    }

    @Test
    public void testWriteAndReadCodingAlphabet() {
        char[] testCharacters = {'a', 'a', 'h', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }
        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());
        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);
        CodingAlphabet alphabetIn = new CodingAlphabet();
        alphabetIn.buildWith(rootNode);
        System.out.println("Alphabet in:");
        System.out.println(alphabetIn.toString());

        try {
            FileManager.writeObject("testing_objectWrite", alphabetIn);
        } catch (Exception e) {}

        try {
            CodingAlphabet alphabetOut = (CodingAlphabet) FileManager.readObject("testing_objectWrite");
            System.out.println("Alphabet out:");
            System.out.println(alphabetOut.toString());
            assertEquals(alphabetIn.getBitsForCharacter('h'), alphabetOut.getBitsForCharacter('h'));
            assertEquals(alphabetIn.getCharacterForBits(new BitSequence("11")),
                    alphabetOut.getCharacterForBits(new BitSequence("11")));
        } catch (Exception e) {}
    }
}