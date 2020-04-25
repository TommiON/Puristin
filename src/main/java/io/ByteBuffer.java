package io;

import CustomDataStructures.BitSequence;

/**
 * Custom buffer of bytes, needed when data is managed in sub-byte resolution, as in Huffman encoding
 * Initial capacity for 12 500 bytes (100 000 bits), grows automatically if needed
 */
public class ByteBuffer {
    private byte[] bytes;
    private int size;
    private int byteLevelHeadPosition;
    private int bitLevelHeadPosition;

    /**
     * initialises an empty byte buffer when starting to encode
     */
    public ByteBuffer() {
        size = 12500;
        bytes = new byte[size];
        byteLevelHeadPosition = 0;
        bitLevelHeadPosition = 0;
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

    private void grow() {

    }
}
