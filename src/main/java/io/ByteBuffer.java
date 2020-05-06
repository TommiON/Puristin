package io;

import CustomDataStructures.BitSequence;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Custom buffer of bytes, needed when data is managed in sub-byte resolution, as in Huffman encoding
 * Initial capacity for 12 500 bytes (100 000 bits), grows automatically if needed
 */
public class ByteBuffer {
    private byte[] bytes;
    private int capacity;
    private int byteLevelHeadPosition;
    private int bitLevelHeadPosition;

    /**
     * initialises an empty byte buffer when starting to encode
     */
    public ByteBuffer() {
        capacity = 12500;
        bytes = new byte[capacity];
        byteLevelHeadPosition = -1;
        bitLevelHeadPosition = 0;
    }

    /**
     * initialises a byte buffer from a file when decoding
     * @param filename
     */
    /*
    public ByteBuffer(String filename) {
        try {
            bytes = FileManager.readBytes(filename);
            capacity = bytes.length;
            // TODO: miten nämä?
            byteLevelHeadPosition = (capacity - 1);
            bitLevelHeadPosition = 0;
        } catch (Exception e) {
            System.out.println("Ongelmia tiedoston lukemisessa: " + e);
        }

    }

     */

    /**
     * Pushes a sequence of bits to buffer, spanning it over multiple bytes if needed
     * @param bits
     */
    public void pushBits(BitSequence bits) {
        while (!bits.isEmpty()) {
            boolean bit = bits.popFirstAndShiftLeft();
            // TODO: ja sitten?
        }
    }

    /**
     * Cuts the unneeded empty slots from the tail of the buffer, then writes data out to a file
     * @param filename
     */
    public void writeToFile(String filename) {
        byte[] outputBytes = trim();
        try {
            BinaryFileManager.writeBytesToFile(filename, outputBytes);
        } catch (Exception e) {
            System.out.println("Ongelmia tiedostoon kirjoittamisessa: " + e);
        }
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

    public byte[] getBytes() { return trim(); }

    public int size() { return byteLevelHeadPosition + 1; }

    @Override
    public String toString() {
        String stringRepresentation = "Tavuja yhteensä: " + (byteLevelHeadPosition + 1) + "\n";
        for (int i = 0; i <= byteLevelHeadPosition; i++) {
            stringRepresentation += "" + bytes[i] + " ";
        }
        return stringRepresentation;
    }

    private void grow() {
        int newCapacity = capacity + (capacity / 2);
        byte[] newBytes = new byte[newCapacity];
        for (int i = 0; i <= byteLevelHeadPosition; i++) {
            newBytes[i] = bytes[i];
        }
        capacity = newCapacity;
        bytes = newBytes;
    }

    private byte[] trim() {
        return Arrays.copyOfRange(bytes, 0, (byteLevelHeadPosition + 1));
    }
}
