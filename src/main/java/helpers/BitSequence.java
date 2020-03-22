package helpers;

public class BitSequence {
    private boolean[] bits;
    private int slotsInUse;

    public BitSequence() {
        slotsInUse = 0;
        bits = new boolean[100];
    }

    public BitSequence(BitSequence anotherBitSequence) {
        slotsInUse = anotherBitSequence.size();
        bits = new boolean[100];
        for (int i = 0; i < slotsInUse; i++) {
            bits[i] = anotherBitSequence.getBitAtIndex(i);
        }
    }

    public void pushLast(boolean bit) {
        if (bit == true) {
            bits[slotsInUse] = true;
        } else {
            bits[slotsInUse] = false;
        }
        slotsInUse++;
    }

    public void pushFirstAndShift(boolean bit) {
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

    public int size() { return slotsInUse; }

    public boolean getBitAtIndex(int index) { return bits[index]; }

}
