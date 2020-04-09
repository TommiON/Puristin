package LempelZivWelchEngine;

/**
 * Implements the code table used for decoding (Int -> String) with capacity of 4096
 */
public class DecodingTable {
    private int[] contents;
    private int counter;

    public DecodingTable() {
        contents = new int[4096];
        counter = 0;
        initFixtures();
    }



    private void initFixtures() {

    }

}
