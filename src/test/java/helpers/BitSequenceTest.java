package helpers;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitSequenceTest {

    @Test
    public void pushesAndShiftsCorrectly() {
        BitSequence bitSequence = new BitSequence();

        bitSequence.pushAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushAndShiftRight(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("1", bitSequence.getAsString().substring(0,1));

        bitSequence.pushAndShiftRight(false);
        System.out.println(bitSequence.getAsString());
        assertEquals("0", bitSequence.getAsString().substring(0,1));

        bitSequence.pushAndShiftRight(true);
        System.out.println(bitSequence.getAsString());
        assertEquals("1", bitSequence.getAsString().substring(0,1));
    }
}