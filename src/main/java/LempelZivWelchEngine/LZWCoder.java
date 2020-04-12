package LempelZivWelchEngine;

import java.util.ArrayList;

// TODO: Miten toimitaan, jos EncodingTable on täynnä?

public class LZWCoder {
    private EncodingTable encodingTable;

    public ArrayList<Integer> encode(String input) {
        encodingTable = new EncodingTable();
        ArrayList<Integer> output = new ArrayList<>();
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

        return output;
    }

    public EncodingTable getCurrentEncodingTable() { return encodingTable; }
}
