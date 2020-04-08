package HuffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingUnitTest {

    @Test
    public void initializesCorrectly() {
        CodingUnit testingUnit = new CodingUnit('x');
        System.out.println(testingUnit.toString());
        assertEquals(1, testingUnit.getFrequency());
        assertEquals('x', testingUnit.getCharacter());
    }

    @Test
    public void incrementsCorrectly() {
        CodingUnit testingUnit = new CodingUnit('x');
        testingUnit.addNewOccurrence();
        testingUnit.addNewOccurrence();
        System.out.println(testingUnit.toString());
        assertEquals(3, testingUnit.getFrequency());
    }

}