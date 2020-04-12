package LempelZivWelchEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodingTableTest {

    @Test
    public void initializesCorrectly() {
        EncodingTable encodingTable = new EncodingTable();
        assertTrue(encodingTable.containsString("a"));
        assertFalse(encodingTable.containsString("aa"));
        assertEquals(104, encodingTable.getCodeForString("h"));
    }

    @Test
    public void addsNewStringCorrectly() {
        EncodingTable encodingTable = new EncodingTable();
        encodingTable.addString("uusi");
        assertTrue(encodingTable.containsString("uusi"));
        assertEquals(256, encodingTable.getCodeForString("uusi"));
    }

}