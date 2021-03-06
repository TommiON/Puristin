package HuffmanEngine;

import CustomDataStructures.BitSequence;

/**
 * Converts Huffman binary input into plain text
 */
public class HuffmanDecoder {
    private String output = new String();
    private BitSequence internalBuffer = new BitSequence();

    /**
     * main method, does the decoding
     * @param alphabet CodingAlphabet to be used
     * @param input Binary data as BitSequence
     */
    public void decode(CodingAlphabet alphabet, BitSequence input) {
        while (!input.isEmpty()) {
            boolean nextBit = input.popFirstAndShiftLeft();
            internalBuffer.pushLast(nextBit);
            if (alphabet.getCharacterForBits(internalBuffer) != null) {
                Character character = alphabet.getCharacterForBits(internalBuffer);
                output += character;
                internalBuffer = new BitSequence();
            }
        }
    }

    /**
     * @return The current plain text data resulting from decoding
     */
    public String getOutput() {
        return output;
    }

}
