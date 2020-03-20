package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingTreeTest {

    @Test
    public void buildsCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        for (char c : testCharacters) {
            Frequencies.checkInACharacter(c);
        }

        FeederQueue.initializeWithCodingUnits(Frequencies.getCodingUnitsAsList());

        CodingTree.build();

        System.out.println(CodingTree.getRoot());
        assertEquals(18, CodingTree.getRoot().getFrequency());
        
        Frequencies.reset();
    }

}