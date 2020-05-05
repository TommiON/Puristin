package LempelZivWelchEngine;

/**
 * Implements the code table used for decoding (Int -> String) with capacity of 4096
 */
public class DecodingTable {
    private String[] contents;
    private static int capacity;
    private int counter;

    public DecodingTable() {
        capacity = 4096;
        contents = new String[capacity];
        counter = 0;
        initFixtures();
    }

    public void addString(String string) {
        contents[counter] = string;
        counter++;
    }

    public boolean containsCode(int code) { return code < counter; }

    public String getStringForCode(int code) {
        return contents[code];
    }

    public boolean hasSpaceLeft() { return counter < capacity; }

    private void initFixtures() {
        for (int i = 0; i < 256; i++) {
            char[] singleCharacter = new char[1];
            singleCharacter[0] = (char)i;
            String string = new String(singleCharacter);
            addString(string);
        }
    }
}
