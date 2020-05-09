package LempelZivWelchEngine;

import CustomDataStructures.ResizingList;

/**
 * Handles LZW decoding, and produces some supplementary metadata
 */
public class LZWDecoder {
    private DecodingTable decodingTable = new DecodingTable();
    private long timer = 0;

    /**
     * Main method, does the decoding
     * @param input coded input as ResizingList of shorts
     * @return output as String
     */
    public String decode(ResizingList<Short> input) {
        long startTime = System.currentTimeMillis();
        String output = "";

        short oldCode = input.get(0);
        output = decodingTable.getStringForCode(oldCode);

        short newCode;
        String currentString = new String();
        String firstCharacter = new String();

        for (int i = 1; i < input.size(); i++) {
            newCode = input.get(i);
            if (!decodingTable.containsCode(newCode)) {
                currentString = decodingTable.getStringForCode(oldCode);
            } else {
                currentString = decodingTable.getStringForCode(newCode);
            }
            output = output + currentString;
            firstCharacter = currentString.substring(0, 1);
            if (decodingTable.hasSpaceLeft()) {
                decodingTable.addString(decodingTable.getStringForCode(oldCode) + firstCharacter);
            }
            oldCode = newCode;
        }

        long stopTime = System.currentTimeMillis();
        timer = (stopTime - startTime);

        return output;
    }

    /**
     * Gets elapsed time
     * @return in milliseconds as long
     */
    public long getTime() {
        return timer;
    }
}
