package LempelZivWelchEngine;

import CustomDataStructures.ResizingList;

/**
 * Handles LZW encoding, and produces some supplementary metadata
 */
public class LZWCoder {
    private EncodingTable encodingTable;
    private long timer = 0;
    private double actualCompressRatio = 0;
    private double idealCompressRatio = 0;

    /**
     * Main method, does the encoding
     * @param input data to be encoded as String
     * @return resulting output as a ResizingList of shorts
     */
    public ResizingList<Short> encode(String input) {
        long startTime = System.currentTimeMillis();

        encodingTable = new EncodingTable();
        ResizingList<Short> output = new ResizingList<>();
        String currentString = "";
        String nextCharacter = "";

        for (int i = 0; i < input.length(); i++) {
            nextCharacter = Character.toString(input.charAt(i));
            if (encodingTable.containsString(currentString + nextCharacter)) {
                currentString = currentString + nextCharacter;
            } else {
                output.add(encodingTable.getCodeForString(currentString));
                if (encodingTable.hasSpaceLeft()) {
                    encodingTable.addString(currentString + nextCharacter);
                }
                currentString = nextCharacter;
            }
        }
        output.add(encodingTable.getCodeForString(currentString));

        long stopTime = System.currentTimeMillis();
        timer = (stopTime - startTime);
        actualCompressRatio = 2 * (double)output.size() / (double)input.length() * 100;
        idealCompressRatio = 1.5 * (double)output.size() / (double)input.length() * 100;

        return output;
    }

    /**
     * Gets times the encoding took
     * @return time in milliseconds as long
     */
    public long getTime() {
        return timer;
    }

    /**
     * Gets actual compress ratio
     * @return as double
     */
    public double getActualCompressRatio() { return actualCompressRatio; }

    /**
     * Gets "ideal" compress ratio
     * @return as double
     */
    public double getIdealCompressRatio() { return idealCompressRatio; }

}
