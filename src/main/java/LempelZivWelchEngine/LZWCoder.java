package LempelZivWelchEngine;

import java.util.ArrayList;

// TODO: Miten toimitaan, jos EncodingTable on täynnä?

public class LZWCoder {
    private EncodingTable encodingTable;
    private long timer = 0;
    private double compressRatio = 0;

    public ArrayList<Short> encode(String input) {
        long startTime = System.currentTimeMillis();

        encodingTable = new EncodingTable();
        ArrayList<Short> output = new ArrayList<>();
        String currentString = "";
        String nextCharacter = "";

        for (int i = 0; i < input.length(); i++) {
            nextCharacter = Character.toString(input.charAt(i));
            if (encodingTable.containsString(currentString + nextCharacter)) {
                currentString = currentString + nextCharacter;
            } else {
                output.add(encodingTable.getCodeForString(currentString));
                encodingTable.addString(currentString + nextCharacter);
                currentString = nextCharacter;
            }
        }
        output.add(encodingTable.getCodeForString(currentString));

        long stopTime = System.currentTimeMillis();
        timer = (stopTime - startTime);
        compressRatio = (double)output.size() / (double)input.length() * 100;

        return output;
    }

    public EncodingTable getCurrentEncodingTable() { return encodingTable; }

    public long getTime() { return timer; }

    public double getCompressRatio() { return compressRatio; }

}
