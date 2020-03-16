package main;

import io.BinaryFileManager;
import io.TextFileManager;

import java.io.IOException;

public class Main {

    private static char[] plainText;
    private static byte[] codedText;

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Virheelliset parametrit. Oikea muoto: puristin [pakkaa|pura] <tiedostonimi>");
            System.exit(0);
        }

        if (args[0].equals("pakkaa")) {
            System.out.println("Pakataan...");
            try {
                StringBuffer buffer = TextFileManager.readCharactersFromFile(args[1]);
                plainText = new char[buffer.length()];
                buffer.getChars(0, buffer.length() - 1, plainText, 0);
                for (char character : plainText) {
                    System.out.print(character);
                }
            } catch (IOException exception) {
                System.out.println("Virhe tiedoston lukemisessa!");
            }
        }

        if (args[0].equals("pura")) {
            System.out.println("Puretaan...");
        }
    }
}
