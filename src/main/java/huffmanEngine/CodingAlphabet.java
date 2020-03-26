package huffmanEngine;

import genericDataStructures.BitSequence;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * Constructs coding alphabet with the help of CodingTree
 */
public class CodingAlphabet {
    private HashMap<Character, String> charactersToBits = new HashMap<>();
    private HashMap<String, Character> bitsToCharacters = new HashMap<>();

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
                charactersToBits.put(current.getCharacter(), current.getBitPath().getAsString());
                bitsToCharacters.put(current.getBitPath().getAsString(), current.getCharacter());
            }
        }
    }

    public String getBitsForCharacter(char c) {
        return charactersToBits.get(c);
    }

    public char getCharacterForBits(BitSequence b) {
        return bitsToCharacters.get(b.getAsString());
    }

    public int size() {
        return charactersToBits.size();
    }

    @Override
    public String toString() {
        String stringRepresentation = new String();
        for (Map.Entry<Character, String> entry: charactersToBits.entrySet()) {
            stringRepresentation += entry.getKey() + " ";
            stringRepresentation += entry.getValue();
            stringRepresentation += "\n";
        }
        return stringRepresentation;
    }


}
