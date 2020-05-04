package io;

import java.io.*;

/**
 * File I/O functionality for reading and writing short integers, strings, and raw bytes
 */
public class FileManager {

    public static void writeShorts(String filename, short[] data) throws IOException {
        DataOutputStream dataOut = new DataOutputStream(new FileOutputStream(new File(filename)));
        for (int i = 0; i < data.length; i++) {
            dataOut.writeShort(data[i]);
        }
        dataOut.close();
    }

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

    public static void writeText(String filename, String data) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)));
        writer.write(data);
        writer.close();
    }

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
}
