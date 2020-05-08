package CustomDataStructures;

import java.io.Serializable;

/**
 * A data structure consisting of a pair of generic key and generic value, used for Hasher data structure
 * @param <K> key type
 * @param <V> value type
 */
public class KeyValuePair<K, V> implements Serializable {
    private static final long serialVersionUID = 1L;
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

    /**
     * @return key
     */
    public K getKey() {
        return key;
    }

    /**
     * @return value
     */
    public V getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * @return next linked KeyValuePair in hash bucket
     */
    public KeyValuePair<K, V> getNext() {
        return next;
    }

    /**
     * @param next next KeyValuePair to be linked in hash bucket
     */
    public void setNext(KeyValuePair<K, V> next) {
        this.next = next;
    }

    /**
     * @return a String representation of the key/value pair, also includes the associated hash value
     */
    @Override
    public String toString() {
        return "Key: " + key + ", value: " + value + ", hashCode: " + generateHashValue();
    }
}
