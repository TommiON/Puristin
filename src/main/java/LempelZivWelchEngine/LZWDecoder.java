package LempelZivWelchEngine;

import java.util.ArrayList;

/*
The decoding algorithm works by reading a value from the encoded input and outputting the corresponding string from the initialized dictionary.
To rebuild the dictionary in the same way as it was built during encoding, it also obtains the next value from the input and adds to the dictionary
the concatenation of the current string and the first character of the string obtained by decoding the next input value, or the first character of
the string just output if the next value can not be decoded (If the next value is unknown to the decoder, then it must be the value added to the
dictionary this iteration, and so its first character must be the same as the first character of the current string being sent to decoded output).
The decoder then proceeds to the next input value (which was already read in as the "next value" in the previous pass) and repeats the process until
there is no more input, at which point the final input value is decoded without any more additions to the dictionary.
 */

public class LZWDecoder {
    private DecodingTable decodingTable = new DecodingTable();

    public String decode(ArrayList<Integer> input) {
        String output = "";

        int oldCode = input.get(0);
        output = decodingTable.getStringForCode(oldCode);

        int newCode;
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
            decodingTable.addString(decodingTable.getStringForCode(oldCode) + firstCharacter);
            oldCode = newCode;
        }

        return output;
    }
}
