package LempelZivWelchEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class DecodingTableTest {

    @Test
    public void initializesCorrectly() {
        DecodingTable decodingTable = new DecodingTable();
        assertEquals("h", decodingTable.getStringForCode(104));
        assertNull(decodingTable.getStringForCode(1000));
    }

}