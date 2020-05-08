package LempelZivWelchEngine;

/**
 * Implements the code table used for decoding (Int -> String) with capacity of 4096
 */
public class DecodingTable {
    private String[] contents;
    private static int capacity;
    private int counter;

    /**
     * Constructor
     */
    public DecodingTable() {
        capacity = 4096;
        contents = new String[capacity];
        counter = 0;
        initFixtures();
    }

    /**
     * Adds new string to table
     * @param string
     */
    public void addString(String string) {
        contents[counter] = string;
        counter++;
    }

    /**
     * @param code queries whether this code is present in table
     * @return true if the queried code is in table, false otherwise
     */
    public boolean containsCode(int code) {
        return code < counter;
    }

    /**
     * Gets a string for a code
     * @param code as int
     * @return String
     */
    public String getStringForCode(int code) {
        return contents[code];
    }

    /**
     * @return true if table is not yet full, false otherwise
     */
    public boolean hasSpaceLeft() {
        return counter < capacity;
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
