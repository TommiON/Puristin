package CustomDataStructures;

/**
 * Represents a sequence of bits, implemented as an array of booleans
 * Initial capacity for 100000 bits, grows automatically if needed
 */
public class BitSequence {
    private boolean[] buckets;
    private int size;
    private int bucketsInUse;

    /**
     * Basic constructor
     */
    public BitSequence() {
        size = 100000;
        bucketsInUse = 0;
        buckets = new boolean[size];
    }

    /**
     * Constructor, initializes with contents of another BitSequence
     * @param anotherBitSequence
     */
    public BitSequence(BitSequence anotherBitSequence) {
        size = 100000;
        while (anotherBitSequence.size() >= size) {
            grow();
        }
        bucketsInUse = anotherBitSequence.size();
        buckets = new boolean[size];
        for (int i = 0; i < bucketsInUse; i++) {
            buckets[i] = anotherBitSequence.getBitAtIndex(i);
        }
    }

    /**
     * Constructor, initializes from a String of 0's and 1's
     * @param stringRepresentation
     */
    public BitSequence(String stringRepresentation) {
        size = 100000;
        while (stringRepresentation.length() >= size) {
            grow();
        }
        bucketsInUse = 0;
        buckets = new boolean[size];
        for (int i = 0; i < stringRepresentation.length(); i++) {
            if (stringRepresentation.charAt(i) == '0') {
                pushLast(false);
            } else if (stringRepresentation.charAt(i) == '1') {
                pushLast(true);
            } else {
                // TODO: handle non-valid input
            }
        }
    }

    /**
     * Pushes a new bit at the end of the sequence
     * @param bit bit to be added
     */
    public void pushLast(boolean bit) {
        if (bucketsInUse >= size) {
            grow();
        }
        if (bit == true) {
            buckets[bucketsInUse] = true;
        } else {
            buckets[bucketsInUse] = false;
        }
        bucketsInUse++;
    }

    /**
     * Pushes multiple bits at once at the end of the sequence
     * @param sourceBitSequence BitSequence containing the bits to be pushed
     */
    public void pushLastMultipleBits(BitSequence sourceBitSequence) {
        while ((bucketsInUse + sourceBitSequence.size) >= size) {
            grow();
        }
        for (int i = 0; i < sourceBitSequence.size(); i++) {
            this.pushLast(sourceBitSequence.getBitAtIndex(i));
        }
    }

    /**
     * Pushes a new bit at the beginning of the sequence, contents shifted rightwards
     * @param bit bit to be added
     */
    public void pushFirstAndShiftRight(boolean bit) {
        if (bucketsInUse >= size) {
            grow();
        }
        bucketsInUse++;
        for (int i = bucketsInUse; i > 0; i--) {
            buckets[i] = buckets[i-1];
        }
        if (bit == true) {
            buckets[0] = true;
        } else {
            buckets[0] = false;
        }
    }

    /**
     * Returns and removes the first bit in the sequence, contents shifted leftwards
     * @return a boolean representing the first bit
     */
    public boolean popFirstAndShiftLeft() {
        boolean firstInLine = buckets[0];
        for (int i = 0; i < bucketsInUse -1; i++) {
            buckets[i] = buckets[i+1];
        }
        bucketsInUse--;
        return firstInLine;
    }

    /**
     * Returns the sequence as a String of 0's and 1's
     * @return
     */
    public String getAsString() {
        String stringRepresentation = new String();
        for (int i = 0; i < bucketsInUse; i++) {
            if (buckets[i] == true) {
                stringRepresentation += "1";
            } else {
                stringRepresentation += "0";
            }
        }
        return stringRepresentation;
    }

    /**
     * @return number of bits in the sequence
     */
    public int size() {
        return bucketsInUse;
    }

    /**
     * @return true if BitSequence contains no bits, false otherwise
     */
    public boolean isEmpty() {
        return bucketsInUse == 0;
    }

    /**
     * Return a bit at a specified location
     * @param index index of the bit to be retrieved as int
     * @return returned bit as boolean
     */
    public boolean getBitAtIndex(int index) {
        return buckets[index];
    }

    private void grow() {
        int newSize = size + (size / 2);
        boolean[] extendedBuckets = new boolean[newSize];
        for (int i = 0; i < bucketsInUse; i++) {
            extendedBuckets[i] = buckets[i];
        }
        size = newSize;
        buckets = extendedBuckets;
    }
}
