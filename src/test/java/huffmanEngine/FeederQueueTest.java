package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeederQueueTest {

    @Test
    public void initialisesCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }
        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());
        assertEquals(4, FeederQueue.getTotalNumberOfEntries());
        FeederQueue.printOutAndClear();
        assertEquals(0, FeederQueue.getTotalNumberOfEntries());

        System.out.println("---");

        Frequencies.reset();
        char[] testCharacters2 = {'a', 'a', '1', 'a'};
        for (char c : testCharacters2) {
            Frequencies.checkInACharacter(c);
        }
        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());
        assertEquals(2, FeederQueue.getTotalNumberOfEntries());
        FeederQueue.printOutAndClear();
        assertEquals(0, FeederQueue.getTotalNumberOfEntries());

        Frequencies.reset();
    }

    @Test
    public void handlesPoppingAndPushingCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }
        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());
        assertEquals(4, FeederQueue.getTotalNumberOfEntries());

        CodingUnit left = FeederQueue.getFirstInLine();
        System.out.println(left.toString());
        CodingUnit right = FeederQueue.getFirstInLine();
        System.out.println(right.toString());

        CodingUnit newNode = new CodingUnit(left, right);
        FeederQueue.pushIntoQueue(newNode);
        assertEquals(3, FeederQueue.getTotalNumberOfEntries());
        FeederQueue.printOutAndClear();

        Frequencies.reset();
    }
}