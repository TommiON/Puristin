package CustomDataStructures;

import huffmanEngine.CodingUnit;

/**
 * Implements a FIFO queue for CodingUnits.
 * Max needed space is known, and popping/pushing is done in a "sliding" window to avoid moving elements around.
 */
public class SlidingFifoQueue {
    private CodingUnit[] contents = new CodingUnit[256];
    private int readHeadPosition = 0;
    private int writeHeadPosition = 0;

    /**
     * Returns the first element in queue
     * @return CodingUnit that has been in the queue for longest
     */
    public CodingUnit pop() {
        if (isEmpty()) { return null; }

        int returnIndex = readHeadPosition;
        readHeadPosition++;
        return contents[returnIndex];
    }

    /**
     * Inserts a new element at the end of the queue
     * @param codingUnit CodingUnit to be added
     */
    public void push(CodingUnit codingUnit) {
        contents[writeHeadPosition] = codingUnit;
        writeHeadPosition++;
    }

    /**
     *
     * @return true if queue has no elements in it, false otherwise
     */
    public boolean isEmpty() {
        return (writeHeadPosition - readHeadPosition) == 0;
    }
}
