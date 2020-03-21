package huffmanEngine;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.HashMap;

/**
 * Constructs coding alphabet with the help of CodingTree, handles binary->text->binary transitions
 */
public class CodingAlphabet {
    private HashMap<Character, BitSet> alphabet = new HashMap<>();

    public void buildWith(CodingUnit rootNode) {
        ArrayDeque<CodingUnit> queue = new ArrayDeque<>();
        queue.add(rootNode);

        while(!queue.isEmpty()) {
            CodingUnit current = queue.poll();

            if (current.getLeftChild() != null) {
                queue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                queue.add(current.getRightChild());
            }

            if (current.containsCharacter()) {

            }


        }


    }

    public BitSet getBitsForCharacter (char c) {
        return new BitSet();
    }

    public char getCharacterForBits (BitSet b) {
        return 'c';
    }

    @Override
    public String toString() {
        return "xxx";
    }


}
