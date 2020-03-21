package huffmanEngine;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FrequenciesTest {

    @Test
    public void recordsFrequenciesCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'a'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        for (CodingUnit c : freq.getCodingUnitsAsList()) {
            System.out.println(c.toString());
        }

        assertEquals(4, freq.getNumberOfUniqueCharacters());

        System.out.println("---");

        char[] testCharacters2 = {'a', 'a', 'a', 'b', 'a'};
        Frequencies freq2 = new Frequencies();
        for (char c : testCharacters2) {
            freq2.checkInACharacter(c);
        }

        for (CodingUnit c : freq2.getCodingUnitsAsList()) {
            System.out.println(c.toString());
        }

        assertEquals(2, freq2.getNumberOfUniqueCharacters());
    }
}