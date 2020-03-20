package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeederQueueTest {

    @Test
    public void initialisesAndPollsCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());

        assertEquals(4, FeederQueue.getTotalNumberOfEntries());

        while (FeederQueue.hasStuffLeft()) {
            CodingUnit c = FeederQueue.getFirstInLine();
            System.out.println(c.toString());
        }
    }
}