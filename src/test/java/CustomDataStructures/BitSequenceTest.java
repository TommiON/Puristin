package CustomDataStructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitSequenceTest {

    @Test
    public void pushesCorrectly() {
        BitSequence bitSequence = new BitSequence();

        bitSequence.pushLast(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushLast(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushLast(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));
    }

    @Test
    public void pushesAndShiftsCorrectly() {
        BitSequence bitSequence = new BitSequence();

        bitSequence.pushFirstAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushFirstAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushFirstAndShiftRight(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("1", bitSequence.getAsString().substring(0,1));

        bitSequence.pushFirstAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushFirstAndShiftRight(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("1", bitSequence.getAsString().substring(0,1));
    }

    @Test
    public void handlesEmptySequenceCorrectly() {
        BitSequence bitSequence = new BitSequence();
        System.out.println(bitSequence.getAsString());
    }

    @Test
    public void initializesCorrectlyFromString() {
        String input = "001100";
        BitSequence bitSequence = new BitSequence(input);
        System.out.println(bitSequence.getAsString());
    }

    @Test
    public void growsCorrectly() {
        BitSequence bitSequence1 = new BitSequence();
        assertEquals(0, bitSequence1.size());
        for (int i = 0; i < 150000; i++) {
            bitSequence1.pushLast(true);
        }
        assertEquals(150000, bitSequence1.size());

        BitSequence bitSequence2 = new BitSequence(bitSequence1);
        assertEquals(150000, bitSequence2.size());

        String stringRepresentation = "";
        for (int i = 0; i < 150001; i++) {
            stringRepresentation = stringRepresentation + "1";
        }
        BitSequence bitSequence3 = new BitSequence(stringRepresentation);
        assertEquals(150001, bitSequence3.size());
    }

}