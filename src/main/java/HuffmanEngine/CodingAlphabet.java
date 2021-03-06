package HuffmanEngine;

import CustomDataStructures.*;
import java.io.Serializable;

/**
 * Constructs coding alphabet with the help of CodingTree
 */
public class CodingAlphabet implements Serializable {
    private static final long serialVersionUID = 1L;
    private Hasher<Character, String> charactersToBits = new Hasher<>();
    private Hasher<String, Character> bitsToCharacters = new Hasher<>();

    /**
     * Constructs the alphabet with width-first graph search, saving text->binary and binary->text mappings whenever a character node is encountered
     * @param rootNode CodingUnit node where building is to start from
     */
    public void buildWith(CodingUnit rootNode) {
        SlidingFifoQueue queue = new SlidingFifoQueue();
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
        ResizingList keyValuePairs = charactersToBits.getEntrySet();
        for (Object o : keyValuePairs) {
            KeyValuePair pair = (KeyValuePair) o;
            stringRepresentation += pair.getKey().toString() + " ";
            stringRepresentation += pair.getValue().toString();
            stringRepresentation += "\n";
        }
        return stringRepresentation;
    }
}
