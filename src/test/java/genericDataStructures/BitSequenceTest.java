package genericDataStructures;

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

}