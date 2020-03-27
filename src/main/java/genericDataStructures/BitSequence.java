package genericDataStructures;

/**
 * Represents a sequence of bits, implemented as an array of booleans
 */
public class BitSequence {
    private boolean[] bits;
    private int slotsInUse;

    /**
     * Constructor, initializes with space for 100 bits (to be considered)
     */
    public BitSequence() {
        slotsInUse = 0;
        bits = new boolean[100];
    }

    /**
     * Constructor, initializes with contents of another BitSequence
     * @param anotherBitSequence
     */
    public BitSequence(BitSequence anotherBitSequence) {
        slotsInUse = anotherBitSequence.size();
        bits = new boolean[100];
        for (int i = 0; i < slotsInUse; i++) {
            bits[i] = anotherBitSequence.getBitAtIndex(i);
        }
    }

    /**
     * Pushes a new bit at the end of the sequence
     * @param bit bit to be added
     */
    public void pushLast(boolean bit) {
        if (bit == true) {
            bits[slotsInUse] = true;
        } else {
            bits[slotsInUse] = false;
        }
        slotsInUse++;
    }

    /**
     * Pushes a new bit at the beginning of the sequence, contents shifted rightwards
     * @param bit bit to be added
     */
    public void pushFirstAndShiftRight(boolean bit) {
        slotsInUse++;
        for (int i = slotsInUse; i > 0; i--) {
            bits[i] = bits[i-1];
        }
        if (bit == true) {
            bits[0] = true;
        } else {
            bits[0] = false;
        }
    }

    /**
     * Returns and removes the first bit in the sequence, contents shifted leftwards
     * @return a boolean representing the first bit
     */
    public boolean popFirstAndShiftLeft() {
        boolean firstInLine = bits[0];
        for (int i = 0; i < slotsInUse-1; i++) {
            bits[i] = bits[i+1];
        }
        slotsInUse--;
        return firstInLine;
    }

    /**
     * Returns the sequence as a String of 0's and 1's
     * @return
     */
    public String getAsString() {
        String stringRepresentation = new String();
        for (int i = 0; i < slotsInUse; i++) {
            if (bits[i] == true) {
                stringRepresentation += "1";
            } else {
                stringRepresentation += "0";
            }
        }
        return stringRepresentation;
    }

    /**
     *
     * @return number of bits in the sequence
     */
    public int size() { return slotsInUse; }

    public boolean isEmpty() { return slotsInUse == 0; }

    public boolean getBitAtIndex(int index) { return bits[index]; }

}
