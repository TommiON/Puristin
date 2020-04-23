package CustomDataStructures;

/**
 * Implements a data structure consisting of generic key and generic value, used in Hasher data structure
 */
public class KeyValuePair<K, V> {
    private K key;
    private V value;
    private KeyValuePair<K, V> next;

    public KeyValuePair(K key, V value, KeyValuePair<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public int generateHashValue() {
        return HashCalculator.generateHashValueFromKey(key);
    }

    public K getKey() { return key; }

    public V getValue() { return value; }

    public void setValue(V value) { this.value = value; }

    public KeyValuePair<K, V> getNext() { return next; }

    public void setNext(KeyValuePair<K, V> next) { this.next = next; }

    @Override
    public String toString() {
        return "Key: " + key + ", value: " + value + ", hashCode: " + generateHashValue();
    }
}
