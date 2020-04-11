package HuffmanEngine;

import CustomDataStructures.BitSequence;

/**
 * "Main" class for Huffman part of the application, coordinates and manages the process
 */
public class HuffmanRunner {
    // TODO: mieti aakkoston staattisuus, käsittely, nyt näin nopeata testausta varten
    private static CodingAlphabet alphabet;

    /**
     * Handles the steps to encode text into compressed binary
     * @param input String to be encoded
     * @return encoded result as BitSequence
     */
    public static BitSequence encode(String input) {
        // 1. create new Frequencies instance, read through the input and feed it in
        Frequencies frequencies = new Frequencies();
        char[] inputAsCharacterArray = input.toCharArray();
        for (char c : inputAsCharacterArray) {
            frequencies.checkInACharacter(c);
        }

        // 2. create a FeederQueue from Frequencies
        FeederQueue feederQueue = new FeederQueue(frequencies.getCodingUnitsAsList());

        // 3. build coding tree
        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feederQueue);

        // 4. generate coding alphabet
        alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        // 5. encode
        Coder coder = new Coder();
        coder.encode(alphabet, input);

        // 6. return coded output
        return coder.getOutput();
    }

    /**
     * Handles the steps to decode binary into original
     * @param input compressed data as BitSequence
     * @return original data as String
     */
    public static String decode(BitSequence input) {
        // 1. decode with input and known alphabet
        Decoder decoder = new Decoder();
        decoder.decode(alphabet, input);

        // 2. return decoded output
        return decoder.getOutput();
    }

}
