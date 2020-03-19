package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingUnitTest {

    @Test
    public void initializesCorrectly() {
        CodingUnit testingUnit = new CodingUnit('x');
        assertEquals(1, testingUnit.getFrequency());
        assertEquals('x', testingUnit.getCharacter());
    }

    @Test
    public void incrementsCorrectly() {
        CodingUnit testingUnit = new CodingUnit('x');
        testingUnit.addNewOccurrence();
        testingUnit.addNewOccurrence();
        assertEquals(3, testingUnit.getFrequency());
    }

}