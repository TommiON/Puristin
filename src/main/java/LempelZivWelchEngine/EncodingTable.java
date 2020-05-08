package LempelZivWelchEngine;

import java.util.HashMap;

/**
 * Implements the code table used for encoding (String -> Int) with capacity of 4096
 */
public class EncodingTable {
    private HashMap<String, Short> contents;
    private static int capacity;
    private short counter;

    public EncodingTable() {
        contents = new HashMap<>();
        capacity = 4096;
        counter = 0;
        initFixtures();
    }

    public boolean containsString(String string) { return contents.containsKey(string); }

    public void addString(String string) {
        contents.put(string, counter);
        counter++;
    }

    public short getCodeForString(String string) {
        return contents.get(string);
    }

    public boolean hasSpaceLeft() { return counter < capacity; }

    @Override
    public String toString() {
        String returnString = "";
        for (HashMap.Entry<String, Short> entry : contents.entrySet()) {
            returnString = returnString + entry.getKey() + ", " + entry.getValue() +"\n";
        }
        return returnString;
    }

    // Initialises 8-bit ASCII single characters as a starting point
    private void initFixtures() {
        for (int i = 0; i < 256; i++) {
            char[] singleCharacter = new char[1];
            singleCharacter[0] = (char)i;
            String string = new String(singleCharacter);
            addString(string);
        }
    }
}
