package io;

import CustomDataStructures.BitSequence;

import java.io.*;

/**
 * File I/O functionality for reading and writing short integers, text, and bit sequences
 */
public class FileManager {

    /**
     * Writes short integers to a file, creates the file if needed, overwrites otherwise
     * @param filename as String
     * @param data as an array of shorts
     * @throws IOException
     */
    public static void writeShorts(String filename, short[] data) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(new File(filename)));
        for (int i = 0; i < data.length; i++) {
            dataOut.writeShort(data[i]);
        }
        dataOut.close();
    }

    /**
     * Reads short integers from a file
     * @param filename as String
     * @return an array of shorts
     * @throws IOException
     */
    public static short[] readShorts(String filename) throws IOException {
        DataInputStream dataIn = new DataInputStream(new FileInputStream(new File(filename)));
        short[] data = new short[dataIn.available() / 2];
        int i = 0;
        while(dataIn.available() > 0) {
            data[i] = dataIn.readShort();
            i++;
        }
        dataIn.close();
        return data;
    }

    /**
     * Writes text data (String) to a file, creates the file if needed, overwrites otherwise
     * @param filename as String
     * @param data as String
     * @throws IOException
     */
    public static void writeText(String filename, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
        writer.write(data);
        writer.close();
    }

    /**
     * Reads text data (String) from a file
     * @param filename as String
     * @return String
     * @throws IOException
     */
    public static String readText(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
        String data = "";
        String currentLine = "";
        while ((currentLine = reader.readLine()) != null) {
            data = data + currentLine;
        }
        reader.close();
        return data;
    }

    /*
    public static void writeBytes(String filename, byte[] data) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(filename));
        outputStream.write(data);
        outputStream.close();
    }

    public static byte[] readBytes(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filename));
        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return data;
    }

     */

    /**
     * Writes a sequence of bits to file, making byte-size chucks of it for file i/o, creates the file if needed, overwrites otherwise
     * @param filename as String
     * @param bits input as BitSequence
     * @throws IOException
     */
    public static void writeBits(String filename, BitSequence bits) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(new File(filename));
        byte[] buffer = new byte[(bits.size() / 8) + Math.min(1, (bits.size() % 8))];
        int bufferPosition = 0;
        int bitPosition = 7;
        int currentlyProcessing = (int)0b00000000;

        while (!bits.isEmpty()) {
            boolean bit = bits.popFirstAndShiftLeft();
            if (bit == true) {
                currentlyProcessing = currentlyProcessing | (1 << bitPosition);
            }
            bitPosition--;
            if (bitPosition < 0 || bits.isEmpty()) {
                buffer[bufferPosition] = (byte)currentlyProcessing;
                bufferPosition++;
                bitPosition = 7;
                currentlyProcessing = (int)0b00000000;
            }
        }

        outputStream.write(buffer);
        outputStream.close();
    }

    /**
     * Reads a sequence of bits from a file, one byte at a time, and returns a BitSequence constructed from them
     * @param filename as String
     * @return BitSequence containing the bits
     * @throws IOException
     */
    public static BitSequence readBits(String filename) throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(filename));
        BitSequence bits = new BitSequence();

        while (inputStream.available() > 0) {
            int b = inputStream.read();
            for (int bitPosition = 7; bitPosition >= 0; bitPosition--) {
                if (((b >> bitPosition) & 1) == 0) {
                    bits.pushLast(false);
                } else if (((b >> bitPosition) & 1) == 1) {
                    bits.pushLast(true);
                }
            }
        }

        return bits;
    }
}
