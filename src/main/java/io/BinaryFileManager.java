package io;

import java.io.*;

/**
 * provides functionality for binary file I/O
 */

public class BinaryFileManager {

    public static void writeBytesToFile(String filename, byte[] data) throws IOException {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(filename));) {
            outputStream.write(data);
        } catch (Exception e) {
            System.out.println("Virhe tiedostoon kirjoittamisessa");
            e.printStackTrace();
            // throw?
        }
    }

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

