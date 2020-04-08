package HuffmanEngine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implements the frequency book-keeping of characters
 */
public class Frequencies {
    private HashMap<Character, CodingUnit> contents = new HashMap<>();

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
     * Returns the contained CodingUnits as a List
     * @return ArrayList of CodingUnits
     */
    public ArrayList<CodingUnit> getCodingUnitsAsList() {
        ArrayList codingUnits = new ArrayList<CodingUnit>(contents.values());
        return codingUnits;
    }

    /**
     * Returns the number of entries, for testing/debugging
     * @return number of unique characters as int
     */
    public int getNumberOfUniqueCharacters() {
        return contents.size();
    }

    /**
     * Reset the contents before starting a new coding run
     */
    public void reset() {
        contents = new HashMap<>();
    }

}
