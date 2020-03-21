package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class FeederQueueTest {

    @Test
    public void initialisesCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Frequencies freq = new Frequencies();

        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        assertEquals(4, feeder.getTotalNumberOfEntries());
        feeder.printOutAndClear();
        assertEquals(0, feeder.getTotalNumberOfEntries());

        System.out.println("---");

        char[] testCharacters2 = {'a', 'a', '1', 'a'};
        Frequencies freq2 = new Frequencies();
        for (char c : testCharacters2) {
            freq2.checkInACharacter(c);
        }

        FeederQueue feeder2 = new FeederQueue(freq2.getCodingUnitsAsList());

        assertEquals(2, feeder2.getTotalNumberOfEntries());
        feeder2.printOutAndClear();
        assertEquals(0, feeder2.getTotalNumberOfEntries());

    }

    @Test
    public void handlesPoppingAndPushingCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        assertEquals(4, feeder.getTotalNumberOfEntries());

        CodingUnit left = feeder.getFirstInLine();
        System.out.println(left.toString());
        CodingUnit right = feeder.getFirstInLine();
        System.out.println(right.toString());

        CodingUnit newNode = new CodingUnit(left, right);
        feeder.pushIntoQueue(newNode);
        assertEquals(3, feeder.getTotalNumberOfEntries());
        feeder.printOutAndClear();
    }
}