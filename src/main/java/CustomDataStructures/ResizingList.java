package CustomDataStructures;

/**
 * Implements an ArrayList-like data structure
 * @param <T> element type
 */
public class ResizingList<T> {
    private int capacity = 10;
    private T[] contents = (T[]) new Object[10];
    private int lastSlotInUse = -1;

    /**
     * Adds a new element at the end of the list
     * @param element
     * @return always returns true; this non-obvious thing is to make the class compatible with Java's ArrayList
     */
    public boolean add(T element) {
        if (lastSlotInUse >= (capacity - 1)) { grow(); }
        lastSlotInUse++;
        contents[lastSlotInUse] = element;
        return true;
    }

    /**
     * Adds a new element at index
     * @param index
     * @param element
     */
    public void add(int index, T element) {
        if (index > lastSlotInUse) { return; }
        if (lastSlotInUse >= (capacity - 1)) { grow(); }
        lastSlotInUse++;
        shiftRigth(index);
        contents[index] = element;
    }

    /**
     * Gets a value at index
     * @param index
     * @return value, or null if request is out of bounds
     */
    public T get(int index) {
        if (index > lastSlotInUse) {
            return null;
        }
        return contents[index];
    }

    /**
     * Removes a value at index
     * @param index
     * @return removed value, or null if value not found
     */
    public T remove(int index) {
        if (index > lastSlotInUse) { return null; }
        T removedObject = contents[index];
        shiftLeft(index);
        lastSlotInUse--;
        return removedObject;
    }

    /**
     * @return number of values in the list
     */
    public int size() { return lastSlotInUse + 1; }

    /**
     * @return true if no elements, false otherwise
     */
    public boolean isEmpty() { return size() == 0; }

    /**
     * @return list contents as String representation
     */
    @Override
    public String toString() {
        String stringRepresentation = "[";
        for (int i = 0; i <= lastSlotInUse; i++) {
            stringRepresentation = stringRepresentation + contents[i] + ", ";
        }
        stringRepresentation = stringRepresentation + "]";
        return stringRepresentation;
    }

    private void grow() {
        int largerSize = capacity + (capacity / 2);
        T[] newContents = (T[]) new Object[largerSize];
        for (int i = 0; i < capacity; i++) {
            newContents[i] = contents[i];
        }
        contents = newContents;
        capacity = largerSize;
    }

    private void shiftLeft(int fromIndex) {
        for (int i = fromIndex; i < lastSlotInUse; i++) {
            contents[i] = contents[i + 1];
        }
    }

    private void shiftRigth(int fromIndex) {
        for (int i = lastSlotInUse; i > fromIndex; i--) {
            contents[i] = contents[i - 1];
        }
    }
}
