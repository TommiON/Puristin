package huffmanEngine;

import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.*;

public class CodingAlphabetTest {

    @Test
    public void buildsCorrectly() {
        char[] testCharacters = {'a', 'a', 'h', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);

        CodingAlphabet alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        System.out.println(alphabet.toString());
    }

}