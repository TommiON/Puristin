package CustomDataStructures;

/**
 * Custom HashTable implementation with Strings as keys and whatever (generic type) as values
 * @param <T>
 */
public class StringHasher<T> {

    private static int numberOfBuckets;

    public StringHasher() {
        numberOfBuckets = 4096;
    }

    public T get(String key) {
        // väliaikainen
        return null;
    }

    public void put(String key, T value) {

    }

    public int size() {
        // väliaikainen
        return 0;
    }

    // lisäksi tarvitaan EntrySet()-iteraattori

    /**
     * Generates a hash value for a String, using 7-based polynomial hashing
     * @param string
     * @return
     */
    public int generateHashValue(String string) {
        int hashValue = 0;
        int stringPosition = string.length();

        for (int i = 0; i < string.length(); i++) {
            int multiplier = (int)Math.pow(7.0, (stringPosition - 1));
            int asciiValue = (int)string.charAt(i);
            hashValue = hashValue + (multiplier * asciiValue);
            stringPosition--;
        }

        return hashValue % numberOfBuckets;

        // pitää muodostaa N:n jakojäännös, joka olisi sitten lopullinen hash-arvo?
    }
}
