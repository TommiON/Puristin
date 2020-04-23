package CustomDataStructures;

/**
 * A data structure consisting of a pair of generic key and generic value, used for Hasher data structure
 * @param <K> key type
 * @param <V> value type
 */
public class KeyValuePair<K, V> {
    private K key;
    private V value;
    private KeyValuePair<K, V> next;

    /**
     * Constuctor
     * @param key
     * @param value
     * @param next needed when these objects are built up as a linked list
     */
    public KeyValuePair(K key, V value, KeyValuePair<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * Returns a hash value calculated from key
     * @return hash value as an Int
     */
    public int generateHashValue() {
        return HashCalculator.generateHashValueFromKey(key);
    }

    // getters and setters...

    public K getKey() { return key; }

    public V getValue() { return value; }

    public void setValue(V value) { this.value = value; }

    public KeyValuePair<K, V> getNext() { return next; }

    public void setNext(KeyValuePair<K, V> next) { this.next = next; }

    /**
     * @return a String representation of the key/value pair, also includes the associated hash value
     */
    @Override
    public String toString() {
        return "Key: " + key + ", value: " + value + ", hashCode: " + generateHashValue();
    }
}
