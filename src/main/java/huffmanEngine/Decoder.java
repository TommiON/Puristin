package huffmanEngine;

import genericDataStructures.BitSequence;

import java.util.Optional;

public class Decoder {
    public static BitSequence internalBuffer = new BitSequence();

    public static void decode(CodingAlphabet alphabet, BitSequence input) {
        while (!input.isEmpty()) {
            boolean nextBit = input.popFirstAndShiftLeft();
            System.out.println("DEBUG Luettu bitti: " + nextBit);
            internalBuffer.pushFirstAndShiftRight(nextBit);
            if (alphabet.getCharacterForBits(internalBuffer) != null) {
                Character character = alphabet.getCharacterForBits(internalBuffer);
                System.out.println("VALMIS Binääristä tekstiksi: " + character);
                internalBuffer = new BitSequence();
            }
        }
    }

}
