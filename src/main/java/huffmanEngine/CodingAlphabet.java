package huffmanEngine;

import genericDataStructures.BitSequence;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Constructs coding alphabet with the help of CodingTree
 */
public class CodingAlphabet {
    private HashMap<Character, String> charactersToBits = new HashMap<>();
    private HashMap<String, Character> bitsToCharacters = new HashMap<>();

    /**
     * Constructs the alphabet with width-first graph search, saving text->binary and binary->text mappings whenever a character node is encountered
     * @param rootNode CodingUnit node where building is to start from
     */
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

    /**
     * Returns a String representation of the BitSequence representing a character
     * @param character the character to be looked up
     * @return String version of the BitSequence, or null if character not found
     */
    public String getBitsForCharacter(char character) {
        return charactersToBits.get(character);
    }

    /**
     * Returns a character corresponding to a BitSequence
     * @param bitSequence the BitSequence to be looked-up
     * @return a char found from the alphabet, or null if not found
     */
    public Character getCharacterForBits(BitSequence bitSequence) {
        Character character = bitsToCharacters.get(bitSequence.getAsString());
        if (character == null) {
            return null;
        }
        return character;
    }

    /**
     * @return number of entries
     */
    public int size() {
        return charactersToBits.size();
    }

    /**
     * @return String representation of the alphabet
     */
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
