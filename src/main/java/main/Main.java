package main;

import CustomDataStructures.BitSequence;
import CustomDataStructures.ResizingList;
import HuffmanEngine.CodingAlphabet;
import HuffmanEngine.HuffmanRunner;
import LempelZivWelchEngine.LZWCoder;
import LempelZivWelchEngine.LZWDecoder;

import io.FileManager;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private static CodingAlphabet knownHuffmanAlphabet;

    public static void main(String[] args) {
        if (args.length > 0) {
            runFromCommandLine(args);
        } else {
            runInInteractiveMode();
        }
    }

    /**
     * Contains code for operating in interactive text-based UI
     */
    private static void runInInteractiveMode() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("PURISTIN");
            System.out.println("(Huom. Interaktiivisessa moodissa Huffman-aakkostoa ei tallenneta pakatun datan mukana, joten purkutoiminto osaa purkaa vain viimeksi pakatun tekstin.)");
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
                    HuffmanRunner huffmanRunner = new HuffmanRunner();
                    BitSequence resultBinary = huffmanRunner.encode(textToBeCoded);
                    knownHuffmanAlphabet = huffmanRunner.getAlphabet();
                    System.out.println("Pakattu binääri:");
                    System.out.println(resultBinary.getAsString());
                    System.out.println();
                    System.out.println("Aikaa kului " + huffmanRunner.getTime() + " millisekuntia." );
                    System.out.println("Pakkaussuhde: " + huffmanRunner.getCompressRatio() + " % alkuperäisestä.");
                    break;
                case "2":
                    System.out.println("Purettava binääri:");
                    String codedStuffAsString = scanner.nextLine();
                    BitSequence codedStuffAsBinary = new BitSequence(codedStuffAsString);
                    HuffmanRunner huffmanRunner1 = new HuffmanRunner(knownHuffmanAlphabet);
                    String resultText = huffmanRunner1.decode(codedStuffAsBinary);
                    System.out.println("Purettu teksti:");
                    System.out.println(resultText);
                    System.out.println();
                    System.out.println("Aikaa kului " + huffmanRunner1.getTime() + " millisekuntia.");
                    break;
                case "3":
                    System.out.println("Pakattava teksti:");
                    String textToBeCoded2 = scanner.nextLine();
                    LZWCoder lzwCoder = new LZWCoder();
                    ResizingList<Short> resultNumbers = lzwCoder.encode(textToBeCoded2);
                    System.out.print("Pakattuna: ");
                    for (int code : resultNumbers) {
                        System.out.print(code + " ");
                    }
                    System.out.println();
                    System.out.println("Aikaa kului " + lzwCoder.getTime() + " millisekuntia.");
                    System.out.println("Pakkaussuhde: " + (int)lzwCoder.getActualCompressRatio() + " % alkuperäisestä.");
                    break;
                case "4":
                    System.out.println("Purettava data (kokonaislukuina välilyönnein eroteltuna):");
                    String codedStuffInNumbers = scanner.nextLine();
                    String[] components = codedStuffInNumbers.split(" ");
                    ResizingList codedNumbers = new ResizingList();
                    for (String s : components) {
                        codedNumbers.add(Short.parseShort(s));
                    }
                    LZWDecoder lzwDecoder = new LZWDecoder();
                    String out = lzwDecoder.decode(codedNumbers);
                    System.out.println("Purettu teksti: ");
                    System.out.println(out);
                    System.out.println("Aikaa kului: " + lzwDecoder.getTime() + " millisekuntia.");
                    break;
                case "5":
                    System.out.println("Hei hei!");
                    System.exit(0);
            }
        }
    }

    /**
     * Contains code for operating from command-line, delegates actual functionality to helper methods
     * @param args command line parameters forwarded
     */
    private static void runFromCommandLine(String[] args) {
        switch (args[0].toLowerCase()) {
            case "lzw": lzw(args);
            case "huffman": huffman(args);
            default: doesNotWork();
        }
    }

    private static void lzw(String[] args) {
        String sourceFileName = getSourceFileName(args);
        String targetFileName = getTargetFileName(args);
        switch (args[1].toLowerCase()) {
            case "pakkaa":
                try {
                    String plainText = FileManager.readText(sourceFileName);
                    LZWCoder lzwCoder = new LZWCoder();
                    ResizingList<Short> resultNumbers = lzwCoder.encode(plainText);
                    // TODO: tämä siistimmäksi jos ehtii
                    short[] resultNumbersAsArray = new short[resultNumbers.size()];
                    int i = 0;
                    for (short s : resultNumbers) {
                        resultNumbersAsArray[i] = s;
                        i++;
                    }
                    // TODO: tähän asti
                    FileManager.writeShorts(targetFileName, resultNumbersAsArray);
                    System.out.println("Aikaa kului " + lzwCoder.getTime() + " millisekuntia.");
                    System.out.println("Pakkaussuhde: " + (int)lzwCoder.getActualCompressRatio() + " % alkuperäisestä (ideaalinen pakkaussuhde "
                            + (int)lzwCoder.getIdealCompressRatio() + " %)");
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Ongelma! " + e);
                    System.exit(1);
                }
            case "pura":
                try {
                    short[] codedInput = FileManager.readShorts(sourceFileName);
                    LZWDecoder lzwDecoder = new LZWDecoder();
                    // TODO: tämä siistimmäksi jos ehtii
                    ResizingList<Short> codedInputReformatted = new ResizingList<>();
                    for (int i = 0; i < codedInput.length; i++) {
                        codedInputReformatted.add(codedInput[i]);
                    }
                    // TODO: tähän asti
                    String plainOutput = lzwDecoder.decode(codedInputReformatted);
                    FileManager.writeText(targetFileName, plainOutput);
                    System.out.println("Aikaa kului: " + lzwDecoder.getTime() + " millisekuntia");
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Ongelma!" + e);
                    System.exit(1);
                }

                System.exit(0);
            default: doesNotWork();
        }
    }

    private static void huffman(String[] args) {
        String sourceFileName = getSourceFileName(args);
        String targetFileName = getTargetFileName(args);
        switch (args[1].toLowerCase()) {
            case "pakkaa":
                try{
                    String textToBeCoded = FileManager.readText(sourceFileName);
                    HuffmanRunner huffmanRunner = new HuffmanRunner();
                    BitSequence resultBinary = huffmanRunner.encode(textToBeCoded);
                    FileManager.writeBits(targetFileName, resultBinary);
                    String alphabetFileName = targetFileName + ".alphabet";
                    FileManager.writeObject(alphabetFileName, huffmanRunner.getAlphabet());
                    System.out.println("Aikaa kului " + huffmanRunner.getTime() + " millisekuntia." );
                    System.out.println("Pakkaussuhde: " + huffmanRunner.getCompressRatio() + " % alkuperäisestä");
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Ongelma! " + e);
                    System.exit(1);
                }
                System.exit(0);
            case "pura":
                try {
                    BitSequence huffmanBinaryData = FileManager.readBits(sourceFileName);
                    String alphabetFileName = sourceFileName + ".alphabet";
                    CodingAlphabet alphabet = (CodingAlphabet) FileManager.readObject(alphabetFileName);
                    HuffmanRunner huffmanRunner = new HuffmanRunner(alphabet);
                    String plainResult = huffmanRunner.decode(huffmanBinaryData);
                    FileManager.writeText(targetFileName, plainResult);
                    System.out.println("Aikaa kului " + huffmanRunner.getTime() + " millisekuntia." );
                    System.exit(0);
                } catch (Exception e) {
                    System.out.println("Ongelma! " + e);
                    System.exit(1);
                }

                System.exit(0);
            default: doesNotWork();
        }

    }

    private static String getSourceFileName(String[] args) {
        if (args[2].isEmpty()) { doesNotWork(); }
        return args[2];
    }

    private static String getTargetFileName(String[] args) {
        if (args[3].isEmpty()) { doesNotWork(); }
        return args[3];
    }

    private static void doesNotWork() {
        System.out.println("Virheelliset parametrit. Ohjelma lopetetaan.");
        System.exit(1);
    }
}