package huffmanEngine;

import java.util.HashMap;

public class Frequencies {
    private static HashMap<Character, CodingUnit> contents = new HashMap<>();

    public static void checkInACharacter(char character) {
        if (contents.containsKey(character)) {
            CodingUnit codingUnit = contents.get(character);
            codingUnit.addNewOccurrence();
            contents.put(character, codingUnit);
        } else {
            CodingUnit codingUnit = new CodingUnit(character);
            contents.put(character, codingUnit);
        }
    }

    public static HashMap<Character, CodingUnit> getContents() {
        return contents;
    }

    public static int getNumberOfUniqueCharacters() {
        return contents.size();
    }
}
