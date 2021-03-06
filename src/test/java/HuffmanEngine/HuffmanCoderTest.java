package HuffmanEngine;

import CustomDataStructures.BitSequence;
import org.junit.Test;

import static org.junit.Assert.*;

public class HuffmanCoderTest {

    @Test
    public void codesMultipleCharactersCorrectly() {
        char[] testCharacters = {'a', 'a', 'h', 'b', 'a', 'b', 'c', 'a', 'c', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'z'};
        Frequencies freq = new Frequencies();
        for (char c : testCharacters) {
            freq.checkInACharacter(c);
        }

        FeederQueue feeder = new FeederQueue(freq.getCodingUnitsAsList());

        CodingUnit rootNode = CodingTree.buildAndReturnRoot(feeder);

        CodingAlphabet alphabet = new CodingAlphabet();
        alphabet.buildWith(rootNode);

        System.out.println("Aakkosto:");
        System.out.println(alphabet.toString());

        System.out.println("Koodataan merkkijono babc");
        String testString = "babc";
        HuffmanCoder huffmanCoder = new HuffmanCoder();
        huffmanCoder.encode(alphabet, testString);
        BitSequence output = huffmanCoder.getOutput();
        String outputAsString = output.getAsString();
        System.out.println("Binäärimuoto: " + outputAsString);
        assertEquals("01101010", outputAsString);
    }
}