package CustomDataStructures;

/**
 * Implements an ArrayList-like data structure
 */
public class ResizingList<T> {
    private int capacity = 10;
    private T[] contents = (T[]) new Object[10];
    private int lastSlotInUse = -1;

    /**
     * Adds new element at the end of the list
     * @param element thing to be added
     * @return always returns true; this non-obvious thing is to make the class compatible with Java's ArrayList
     */
    public boolean add(T element) {
        if (lastSlotInUse >= (capacity - 1)) { grow(); }
        lastSlotInUse++;
        contents[lastSlotInUse] = element;
        return true;
    }

    public void add(int index, T element) {
        if (index > lastSlotInUse) { return; }
        if (lastSlotInUse >= (capacity - 1)) { grow(); }
        lastSlotInUse++;
        shiftRigth(index);
        contents[index] = element;
    }

    public T get(int index) {
        if (index > lastSlotInUse) {
            return null;
        }
        return contents[index];
    }

    public T remove(int index) {
        if (index > lastSlotInUse) { return null; }
        T removedObject = contents[index];
        shiftLeft(index);
        lastSlotInUse--;
        return removedObject;
    }

    public int size() { return lastSlotInUse + 1; }

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
