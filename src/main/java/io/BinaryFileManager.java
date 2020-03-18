package io;

import java.io.*;

/**
 * provides functionality for binary file I/O
 */
public class BinaryFileManager {

    /**
     * writes binary data to a file
     * @param filename target file name as String
     * @param data data to be written as byte array
     * @throws IOException
     */
    public static void writeBytesToFile(String filename, byte[] data) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename));) {
            outputStream.write(data);
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa");
            e.printStackTrace();
            // throw?
        }
    }

    /**
     * reads binary data from a file
     * @param filename source file name as String
     * @return data contents as byte array
     * @throws IOException
     */
    public static byte[] readBytesFromFile(String filename) throws IOException {
        File file = new File(filename);
        long fileSize = file.length();
        byte[] data = new byte[(int) fileSize];

        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(filename));) {
            inputStream.read(data);
        } catch (Exception e) {
            System.out.println("Virhe tiedoston lukemisessa");
            e.printStackTrace();
            // throw?
        }

        return data;
    }

}
