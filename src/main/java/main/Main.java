package main;

import CustomDataStructures.BitSequence;
import HuffmanEngine.HuffmanRunner;
import java.util.Scanner;

public class Main {

    private static char[] plainText;
    private static byte[] codedText;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("PURISTIN");
            System.out.println("1 Pakkaa Huffman-algoritmilla");
            System.out.println("2 Pura Huffman-pakattu data");
            System.out.println("3 Pakkaa LZW-algoritmilla (ei vielä käytettävissä)");
            System.out.println("4 Pura LZW-pakattu data (ei vielä käytettävissä");
            System.out.println("5 Exit");
            System.out.print("? ");

            String userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    System.out.println("Pakattava teksti:");
                    String textToBeCoded = scanner.nextLine();
                    BitSequence resultBinary = HuffmanRunner.encode(textToBeCoded);
                    System.out.println("Pakattu binääri:");
                    System.out.println(resultBinary.getAsString());
                    System.out.println();
                    break;
                case "2":
                    System.out.println("Purettava binääri:");
                    String codedStuffAsString = scanner.nextLine();
                    BitSequence codedStuffAsBinary = new BitSequence(codedStuffAsString);
                    String resultText = HuffmanRunner.decode(codedStuffAsBinary);
                    System.out.println("Purettu teksti:");
                    System.out.println(resultText);
                    System.out.println();
                    break;
                case "5":
                    System.out.println("Hei hei!");
                    System.exit(0);
            }
        }

        /*
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

         */
    }
}
