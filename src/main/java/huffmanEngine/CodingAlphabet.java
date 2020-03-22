package huffmanEngine;

import helpers.BitSequence;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Constructs coding alphabet with the help of CodingTree, handles binary->text->binary transitions
 */
public class CodingAlphabet {
    private HashMap<Character, BitSequence> alphabet = new HashMap<>();

    public void buildWith(CodingUnit rootNode) {
        ArrayDeque<CodingUnit> queue = new ArrayDeque<>();
        queue.add(rootNode);

        while(!queue.isEmpty()) {
            CodingUnit current = queue.poll();
            if (current.getLeftChild() != null) {
                BitSequence bitPathSoFar = current.getBitPath();
                current.getLeftChild().setBitPath(bitPathSoFar);
                current.getLeftChild().turnLeftInBitPath();
                queue.add(current.getLeftChild());
            }
            if (current.getRightChild() != null) {
                BitSequence bitPathSoFar = current.getBitPath();
                current.getRightChild().setBitPath(bitPathSoFar);
                current.getRightChild().turnRightInBitPath();
                queue.add(current.getRightChild());
            }
            if (current.containsCharacter()) {
                alphabet.put(current.getCharacter(), current.getBitPath());
            }
        }
    }

    public BitSequence getBitsForCharacter(char c) {
        return new BitSequence();
    }

    public char getCharacterForBits(BitSet b) {
        return 'c';
    }

    @Override
    public String toString() {
        String stringRepresentation = new String();
        for (Map.Entry<Character, BitSequence> entry: alphabet.entrySet()) {
            stringRepresentation += entry.getKey() + " ";
            stringRepresentation += entry.getValue().getAsString();
            stringRepresentation += "\n";
        }
        return stringRepresentation;
    }


}
