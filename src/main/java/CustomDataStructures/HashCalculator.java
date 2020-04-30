package CustomDataStructures;

/**
 * Static helper class to calculate hash values
 */
public class HashCalculator<K> {

    /**
     * Generates a hash value for a key, using 7-based polynomial hashing for Strings
     * @return hash value as Int, -1 is the default value if key's type can't be handled
     */
    public static <K> int generateHashValueFromKey(K key) {
        int hashValue = -1;

        if (key instanceof String) {
            hashValue = 0;
            String string = (String)key;
            int stringPosition = string.length();
            for (int i = 0; i < string.length(); i++) {
                int multiplier = (int)Math.pow(7.0, (stringPosition - 1));
                int asciiValue = (int)string.charAt(i);
                hashValue = hashValue + (multiplier * asciiValue);
                stringPosition--;
            }
        }

        if (key instanceof Character) {
            Character character = (Character) key;
            hashValue = Integer.valueOf(character);
        }

        return hashValue;
    }
}
