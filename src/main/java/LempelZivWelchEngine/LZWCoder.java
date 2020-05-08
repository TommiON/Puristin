package LempelZivWelchEngine;

import CustomDataStructures.ResizingList;

import java.util.ArrayList;

public class LZWCoder {
    private EncodingTable encodingTable;
    private long timer = 0;
    private double actualCompressRatio = 0;
    private double idealCompressRatio = 0;

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

    public EncodingTable getCurrentEncodingTable() { return encodingTable; }

    public long getTime() { return timer; }

    public double getActualCompressRatio() { return actualCompressRatio; }

    public double getIdealCompressRatio() { return idealCompressRatio; }

}
