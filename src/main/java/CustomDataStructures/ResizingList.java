package CustomDataStructures;

/**
 * Implements an ArrayList-like data structure
 */
public class ResizingList<T> {
    private T[] contents;
    private int size;

    /**
     * Constructor, starts with capacity 10
     */
    public ResizingList() {
        size = 10;
        contents = (T[]) new Object[10];
    }

    private void grow() {
        int largerSize = size + size/2;
        T[] newContents = (T[]) new Object[largerSize];
        for (int i = 0; i < size; i++) {
            newContents[i] = contents[i];
        }
        contents = newContents;
    }
}
