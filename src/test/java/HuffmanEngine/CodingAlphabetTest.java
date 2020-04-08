package HuffmanEngine;

import CustomDataStructures.BitSequence;
import org.junit.Test;

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

        String bitSequenceRepresentationForC = alphabet.getBitsForCharacter('c');
        assertEquals("100", bitSequenceRepresentationForC);
        System.out.println(bitSequenceRepresentationForC);

        BitSequence bitSequence = new BitSequence();
        bitSequence.pushLast(true);
        bitSequence.pushLast(false);
        bitSequence.pushLast(true);
        bitSequence.pushLast(false);
        Character characterForBitRepresentation1010 = alphabet.getCharacterForBits(bitSequence);
        assertEquals(new Character('h'), characterForBitRepresentation1010);
        System.out.println(characterForBitRepresentation1010);

        assertEquals(5, alphabet.size());
        System.out.println(alphabet.toString());
    }

    @Test
    public void buildsCorrectly2() {
        char[] testCharacters = {'a', 'a', 'b', 'a', 'c', 'd'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);

        CodingAlphabet alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        assertEquals(4, alphabet.size());
        System.out.println(alphabet.toString());

        String bitSequenceRepresentationForC = alphabet.getBitsForCharacter('c');
        assertEquals("10", bitSequenceRepresentationForC);
        System.out.println(bitSequenceRepresentationForC);
    }
}