package huffmanEngine;

import CustomDataStructures.BitSequence;

/**
 * Converts plain text input into Huffman binary
 */
public class Coder {
    private BitSequence output = new BitSequence();

    /**
     *
     * @param alphabet CodingAlphabet to be used
     * @param input Data to be coded, as String
     */
    public void code(CodingAlphabet alphabet, String input) {
        int readHeadLocation = 0;

        for (int i = 0; i < input.length(); i++ ) {
            Character currentCharacter = input.charAt(readHeadLocation);
            if (alphabet.getBitsForCharacter(currentCharacter) != null) {

                String bitsAsString = alphabet.getBitsForCharacter(currentCharacter);

                // TODO: mieti bittijonot, nyt BitSequencen ja String-esityksen välillä sekavuutta, joudutaan tällaisiin purkkaviritelmiin
                for (int j = 0; j < bitsAsString.length(); j++) {
                    if (bitsAsString.charAt(j) == '0') {
                        output.pushLast(false);
                    } else if (bitsAsString.charAt(j) == '1') {
                        output.pushLast(true);
                    }
                }

                readHeadLocation++;
            }
        }
    }

    /**
     *
     * @return The current coded data as BitSequence
     */
    public BitSequence getOutput() {
        return output;
    }
}
