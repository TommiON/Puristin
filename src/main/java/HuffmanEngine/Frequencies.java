package HuffmanEngine;

import CustomDataStructures.Hasher;
import CustomDataStructures.KeyValuePair;
import CustomDataStructures.ResizingList;

/**
 * Implements frequency book-keeping of characters
 */
public class Frequencies {
    private Hasher<Character, CodingUnit> contents = new Hasher<>();

    /**
     * Called when a character is encountered. Creates a new CodingUnit if a new character, otherwise increments the frequency by one.
     * @param character the character encountered
     */
    public void checkInACharacter(char character) {
        if (contents.containsKey(character)) {
            CodingUnit codingUnit = contents.get(character);
            codingUnit.addNewOccurrence();
            contents.put(character, codingUnit);
        } else {
            CodingUnit codingUnit = new CodingUnit(character);
            contents.put(character, codingUnit);
        }
    }

    /**
     * Returns the contained CodingUnits as a list
     * @return ResizingList of CodingUnits
     */
    public ResizingList<CodingUnit> getCodingUnitsAsList() {
        ResizingList codingUnits = new ResizingList();
        for (Object entry : contents.getEntrySet()) {
            KeyValuePair pair = (KeyValuePair) entry;
            CodingUnit codingUnit = (CodingUnit) pair.getValue();
            codingUnits.add(codingUnit);
        }
        return codingUnits;
    }

    /**
     * Returns the number of entries, for testing/debugging
     * @return number of unique characters as int
     */
    public int getNumberOfUniqueCharacters() {
        return contents.size();
    }
}
