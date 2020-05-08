package HuffmanEngine;

import CustomDataStructures.BitSequence;

/**
 * "Main" class for Huffman part of the application, coordinates and manages the process
 */
public class HuffmanRunner {
    private CodingAlphabet alphabet;
    private long timer;
    private double compressRatio;

    /**
     * Constuctor for encoding run
     */
    public HuffmanRunner() {
        alphabet = null;
        timer = 0;
        compressRatio = 0;
    }

    /**
     * Constructor for decoding run
     * @param alphabet CodingAlphabet to be used
     */
    public HuffmanRunner(CodingAlphabet alphabet) {
        this.alphabet = alphabet;
        timer = 0;
        compressRatio = 0;
    }

    /**
     * Handles the steps to encode text into compressed binary
     * @param input String to be encoded
     * @return encoded result as BitSequence
     */
    public BitSequence encode(String input) {
        // 0. Start timer
        long startTime = System.currentTimeMillis();

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
        HuffmanCoder huffmanCoder = new HuffmanCoder();
        huffmanCoder.encode(alphabet, input);

        // 6. stop timer and calculate time, compress ratio
        long stopTime = System.currentTimeMillis();
        timer = (stopTime - startTime);
        BitSequence output = huffmanCoder.getOutput();
        compressRatio = ((double)output.size() / 8) / (double)input.length() * 100;

        // 7. return coded output
        return output;
    }

    /**
     * Handles the steps to decode binary into original
     * @param input compressed data as BitSequence
     * @return original data as String
     */
    public String decode(BitSequence input) {
        // 0. Start timer
        long startTime = System.currentTimeMillis();

        // 1. decode with input and known alphabet
        HuffmanDecoder huffmanDecoder = new HuffmanDecoder();
        huffmanDecoder.decode(alphabet, input);

        // 2. stop timer and calculate time
        long stopTime = System.currentTimeMillis();
        timer = (stopTime - startTime);

        // 3. return decoded output
        return huffmanDecoder.getOutput();
    }

    /**
     * @return elapsed time as long
     */
    public long getTime() {
        return timer;
    }

    /**
     * @return compress ratio as double
     */
    public double getCompressRatio() {
        return compressRatio;
    }

    /**
     * @return CodingAlphabet used for encoding
     */
    public CodingAlphabet getAlphabet() {
        return alphabet;
    }
}
