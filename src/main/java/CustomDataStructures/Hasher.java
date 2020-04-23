package CustomDataStructures;

/**
 * Custom HashTable implementation with generic keys and values
 * @param <K>
 * @param <V>
 */
public class Hasher<K, V> {
    private static int numberOfBuckets = 4096;
    private KeyValuePair[] buckets = new KeyValuePair[numberOfBuckets];
    private int size = 0;

    public void put(K key, V value) {
        KeyValuePair<K, V> entry = new KeyValuePair(key, value, null);
        int bucketIndex = entry.generateHashValue() % numberOfBuckets;

        KeyValuePair<K, V> existing = buckets[bucketIndex];
        if (existing == null) {
            buckets[bucketIndex] = entry;
            size++;
        } else {
            while (existing.getNext() != null) {
                if (existing.getKey().equals(key)) {
                    existing.setValue(value);
                    return;
                }
                existing = existing.getNext();
            }
            if (existing.getKey().equals(key)) {
                existing.setValue(value);
            } else {
                existing.setNext(entry);
                size++;
            }
        }
    }

    public V get(K key) {
        KeyValuePair<K, V> bucket = buckets[HashCalculator.generateHashValueFromKey(key) % numberOfBuckets];

        while (bucket != null) {
            if (bucket.getKey().equals(key)) {
                return bucket.getValue();
            }
            bucket = bucket.getNext();
        }

        return null;
    }

    /**
     * @return numbers of entries in the data structure
     */
    public int size() { return size; }

    /**
     * @return all entries stored as a ResizingList
     */
    public ResizingList<KeyValuePair<K, V>> getEntrySet() {
        ResizingList list = new ResizingList();
        for (int i = 0; i < numberOfBuckets; i++) {
            if (buckets[i] != null) {
                list.add(buckets[i]);
                KeyValuePair next = buckets[i].getNext();
                while (next != null) {
                    list.add(next);
                    next = next.getNext();
                }
            }
        }
        return list;
    }

}
