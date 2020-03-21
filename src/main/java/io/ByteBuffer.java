package io;

import helpers.BitSequence;

import java.util.BitSet;

/**
 * Handles the traffic to/from binary file, needed because data is managed in sub-byte resolution
 */
public class ByteBuffer {
    private static byte[] bytes;
    private static int numberOfEntries;
    private static int freeBitsInLastByte;

    /**
     * initialises an empty byte buffer when starting to encode
     */
    public ByteBuffer() {
        this.bytes = new byte[100000];
        this.numberOfEntries = 0;
        this.freeBitsInLastByte = 8;
    }

    /**
     * initialises a byte buffer from a file when decoding
     * @param filename
     */
    public ByteBuffer(String filename) {

    }

    /**
     * Pushes a sequence of bits to buffer, spanning it over multiple bytes if needed
     * @param bits
     */
    public void pushBits(BitSequence bits) {

    }

    /**
     * Returns a sequence of bits from buffer
     * @param numberOfBits
     * @return
     */
    public BitSet popBits(int numberOfBits) {
        // väliaikainen
        return new BitSet();
    }
}
