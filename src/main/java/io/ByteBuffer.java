package io;

import CustomDataStructures.BitSequence;

/**
 * Handles the traffic to/from binary file, needed because data is managed in sub-byte resolution
 */
public class ByteBuffer {
    private byte[] bytes;
    private int byteLevelReadWriteHeadPosition;
    private int bitLevelReadWriteHeadPosition;

    /**
     * initialises an empty byte buffer when starting to encode
     */
    public ByteBuffer() {
        bytes = new byte[100000];
        byteLevelReadWriteHeadPosition = 0;
        bitLevelReadWriteHeadPosition = 0;
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
    public BitSequence popBits(int numberOfBits) {
        // väliaikainen
        return new BitSequence();
    }
}
