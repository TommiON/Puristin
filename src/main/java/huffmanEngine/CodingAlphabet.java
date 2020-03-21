package huffmanEngine;

import java.util.BitSet;
import java.util.HashMap;

/**
 * Constructs coding alphabet with the help of CodingTree, hands over data when requested
 */
public class CodingAlphabet {
    private HashMap<Character, BitSet> alphabet;

    public void traverseCodingTreeAndBuild (CodingUnit rootNode) {

    }

    public BitSet getBitsForCharacter (char c) {
        return new BitSet();
    }

    public char getCharacterForBits (BitSet b) {
        return 'c';
    }


}
