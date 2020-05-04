package io;

import java.io.*;

/**
 * provides functionality for text file I/O
 */
public class TextFileManager {

    /**
     * Writes a text chunk into a file
     * @param fileName name of the file as String
     * @param data data to be written as String
     * @throws IOException
     */
    public static void writeCharactersToFile(String fileName, String data) throws IOException {
        FileWriter fileWriter = null;

        try {
            File file = new File(fileName);
            fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } finally {
            if (fileWriter != null) {
                fileWriter.close();
            }
        }
    }

    /**
     * Reads and returns a text file contents as a StringBuffer
     * @param fileName name of the file as String
     * @return file contents as a (possibly large) String
     * @throws IOException
     */
    public static String readCharactersFromFile(String fileName) throws IOException {
        FileReader fileReader = null;
        StringBuffer buffer = new StringBuffer();

        try {
            File file = new File(fileName);
            fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            char[] characters = new char[(int) file.length()];
            bufferedReader.read(characters);
            buffer.append(characters);
            bufferedReader.close();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }

        return buffer.toString();
    }

}
