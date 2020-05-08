package LempelZivWelchEngine;

import CustomDataStructures.Hasher;
import CustomDataStructures.KeyValuePair;

import java.util.HashMap;

/**
 * Implements the code table used for encoding (String -> Int) with capacity of 4096
 */
public class EncodingTable {
    private Hasher<String, Short> contents;
    private static int capacity;
    private short counter;

    /**
     * Constructor
     */
    public EncodingTable() {
        contents = new Hasher<>();
        capacity = 4096;
        counter = 0;
        initFixtures();
    }

    /**
     * Tells whether a string is present in code table
     * @param string String to be queried
     * @return true if String is present, false otherwise
     */
    public boolean containsString(String string) {
        return contents.containsKey(string);
    }

    /**
     * Adds a string to code table
     * @param string
     */
    public void addString(String string) {
        contents.put(string, counter);
        counter++;
    }

    /**
     * Gets the numerical code for a string
     * @param string String to be queried
     * @return corresponding code as short
     */
    public short getCodeForString(String string) {
        return contents.get(string);
    }

    /**
     * @return true if not all table slots are used, false otherwise
     */
    public boolean hasSpaceLeft() { return counter < capacity; }

    /**
     * @return String representation of table contents
     */
    @Override
    public String toString() {
        String returnString = "";
        for (KeyValuePair pair : contents.getEntrySet()) {
            returnString += pair.getKey().toString() + ", " + pair.getValue().toString() + "\n";
        }
        return returnString;
    }

    /**
     *  Initialises 8-bit ASCII single characters as a starting point for the class
     */
    private void initFixtures() {
        for (int i = 0; i < 256; i++) {
            char[] singleCharacter = new char[1];
            singleCharacter[0] = (char)i;
            String string = new String(singleCharacter);
            addString(string);
        }
    }
}
