package main;

import CustomDataStructures.BitSequence;
import HuffmanEngine.HuffmanRunner;
import LempelZivWelchEngine.LZWCoder;
import LempelZivWelchEngine.LZWDecoder;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static char[] plainText;
    private static byte[] codedText;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("PURISTIN");
            System.out.println("(Huom. Tällä hetkellä Huffman-aakkostoa ei tallenneta pakatun datan mukana, joten purkutoiminto osaa purkaa vain viimeksi pakatun tekstin.)");
            System.out.println();
            System.out.println("1 Pakkaa Huffman-algoritmilla");
            System.out.println("2 Pura Huffman-pakattu data");
            System.out.println("3 Pakkaa LZW-algoritmilla");
            System.out.println("4 Pura LZW-pakattu data");
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
                    System.out.println("Aikaa kului " + HuffmanRunner.getTime() + " millisekuntia." );
                    System.out.println("Pakkaussuhde: " + HuffmanRunner.getCompressRatio() + " % alkuperäisestä");
                    break;
                case "2":
                    System.out.println("Purettava binääri:");
                    String codedStuffAsString = scanner.nextLine();
                    BitSequence codedStuffAsBinary = new BitSequence(codedStuffAsString);
                    String resultText = HuffmanRunner.decode(codedStuffAsBinary);
                    System.out.println("Purettu teksti:");
                    System.out.println(resultText);
                    System.out.println();
                    System.out.println("Aikaa kului " + HuffmanRunner.getTime() + " millisekuntia.");
                    break;
                case "3":
                    System.out.println("Pakattava teksti:");
                    String textToBeCoded2 = scanner.nextLine();
                    LZWCoder lzwCoder = new LZWCoder();
                    ArrayList<Integer> resultIntegers = lzwCoder.encode(textToBeCoded2);
                    System.out.print("Pakattuna: ");
                    for (int code : resultIntegers) {
                        System.out.print(code + " ");
                    }
                    System.out.println();
                    System.out.println("Aikaa kului " + lzwCoder.getTime() + " millisekuntia.");
                    System.out.println("Pakkaussuhde: " + lzwCoder.getCompressRatio() + " % alkuperäisestä");
                    break;
                case "4":
                    System.out.println("Purettava data (kokonaislukuina välilyönnein eroteltuna):");
                    String codedStuffInInts = scanner.nextLine();
                    String[] components = codedStuffInInts.split(" ");
                    ArrayList codedInts = new ArrayList();
                    for (String s : components) {
                        codedInts.add(Integer.parseInt(s));
                    }
                    LZWDecoder lzwDecoder = new LZWDecoder();
                    String out = lzwDecoder.decode(codedInts);
                    System.out.println("Purettu teksti: ");
                    System.out.println(out);
                    System.out.println("Aikaa kului: " + lzwDecoder.getTime());
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
