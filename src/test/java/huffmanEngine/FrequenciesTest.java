package huffmanEngine;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FrequenciesTest {

    @Test
    public void recordsFrequenciesCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        for (CodingUnit c : Frequencies.getCodingUnitsAsList()) {
            System.out.println(c.toString());
        }

        assertEquals(4, Frequencies.getNumberOfUniqueCharacters());
    }

}