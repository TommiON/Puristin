package HuffmanEngine;

import CustomDataStructures.BitSequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanDecoderTest {

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

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder();
        huffmanDecoder.decode(alphabet, bitSequence1);
        String outputAsString = huffmanDecoder.getOutput();
        System.out.println(outputAsString);
        assertEquals("bab", outputAsString);
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
        bitSequence1.pushLast(true); // orphan bit

        HuffmanDecoder huffmanDecoder = new HuffmanDecoder();
        huffmanDecoder.decode(alphabet, bitSequence1);
        String outputAsString = huffmanDecoder.getOutput();
        System.out.println(outputAsString);
        assertEquals("bab", outputAsString);
    }

}