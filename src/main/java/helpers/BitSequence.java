package helpers;

public class BitSequence {
    private boolean[] bits;
    private int slotsInUse;

    public BitSequence() {
        bits = new boolean[100];
        slotsInUse = 0;
    }

    public void pushAndShiftRight(boolean bit) {
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
}
