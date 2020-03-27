package huffmanEngine;

import genericDataStructures.BitSequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecoderTest {

    @Test
    public void decodescorrectlyWithNoOrphanBits() {
        char[] testCharacters = {'a', 'a', 'h', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);

        CodingAlphabet alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        BitSequence bitSequence1 = new BitSequence();
        bitSequence1.pushLast(false);
        bitSequence1.pushLast(true);
        bitSequence1.pushLast(true);
        bitSequence1.pushLast(false);
        Decoder.decode(alphabet, bitSequence1);
    }

    @Test
    public void decodesCorrectlyWithOrphanBits() {
        char[] testCharacters = {'a', 'a', 'h', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);

        CodingAlphabet alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        BitSequence bitSequence1 = new BitSequence();
        bitSequence1.pushLast(false);
        bitSequence1.pushLast(true);
        bitSequence1.pushLast(true);
        bitSequence1.pushLast(false);
        bitSequence1.pushLast(true);
        Decoder.decode(alphabet, bitSequence1);
    }

}