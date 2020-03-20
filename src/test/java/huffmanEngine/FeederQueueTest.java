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

        FeederQueue.printOutAndClear();

        assertEquals(0, FeederQueue.getTotalNumberOfEntries());

        FeederQueue.printOutAndClear();

    }

    @Test
    public void handlesPushingCorrectly() {
        System.out.println("Poistetaan prioriteettijonosta kaksi pienintä, yhdistetään, työnnetään tulos takaisin...");

        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());

        assertEquals(4, FeederQueue.getTotalNumberOfEntries());

        CodingUnit left = FeederQueue.getFirstInLine();
        CodingUnit right = FeederQueue.getFirstInLine();
        CodingUnit newNode = new CodingUnit(left, right);
        FeederQueue.pushIntoQueue(newNode);

        assertEquals(3, FeederQueue.getTotalNumberOfEntries());

        FeederQueue.printOutAndClear();

        System.out.println("Sama kuin äsken, mutta kaksi poisto- ja lisäyskierrosta...");
    }

    @Test
    public void handlesDoublePushingCorrectly() {
        System.out.println("Kaksi kertaa: poistetaan prioriteettijonosta kaksi pienintä, yhdistetään, työnnetään tulos takaisin...");

        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());

        assertEquals(4, FeederQueue.getTotalNumberOfEntries());

        CodingUnit left = FeederQueue.getFirstInLine();
        CodingUnit right = FeederQueue.getFirstInLine();
        CodingUnit newNode = new CodingUnit(left, right);
        FeederQueue.pushIntoQueue(newNode);

        assertEquals(3, FeederQueue.getTotalNumberOfEntries());

        CodingUnit left2 = FeederQueue.getFirstInLine();
        CodingUnit right2 = FeederQueue.getFirstInLine();
        CodingUnit newNode2 = new CodingUnit(left2, right2);
        FeederQueue.pushIntoQueue(newNode2);

        FeederQueue.printOutAndClear();

    }
}