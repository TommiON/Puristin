package LempelZivWelchEngine;

/**
 * Implements the code table used for decoding (Int -> String) with capacity of 4096
 */
public class DecodingTable {
    private String[] contents;
    private int counter;

    public DecodingTable() {
        contents = new String[4096];
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

    private void initFixtures() {
        for (int i = 0; i < 256; i++) {
            char[] singleCharacter = new char[1];
            singleCharacter[0] = (char)i;
            String string = new String(singleCharacter);
            addString(string);
        }
    }
}
