package LempelZivWelchEngine;

import java.util.HashMap;

/**
 * Implements the code table used for encoding (String -> Int) with capacity of 4096
 */
public class EncodingTable {
    private HashMap<String, Integer> contents;
    private static int capacity;
    private int counter;

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

    // Must be replaced with real ASCII codes
    private void initFixtures() {
        addString("a");
        addString("b");
        addString("c");
        addString("d");
    }
}
