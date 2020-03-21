package huffmanEngine;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodingTreeTest {

    @Test
    public void buildsCorrectly() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingTree.buildFrom(feeder);

        System.out.println(CodingTree.getRoot());
        assertEquals(18, CodingTree.getRoot().getFrequency());

    }

    @Test
    public void correctRoot() {
        char[] testCharacters = {'a', 'a', '1', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue((freq.getCodingUnitsAsList()));

        CodingTree.buildFrom(feeder);

        CodingUnit root = CodingTree.getRoot();
        CodingUnit firstLeft = root.getLeftChild();
        CodingUnit firstRight = root.getRightChild();
        System.out.println("Juurisolmu:");
        System.out.println(root.toString());
        System.out.println("Ensimmäinen lapsi vasemmalla");
        System.out.println(firstLeft.toString());
        System.out.println("Ensimmäinen lapsi oikealla");
        System.out.println(firstRight.toString());
    }
}