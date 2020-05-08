package HuffmanEngine;

import CustomDataStructures.MinHeap;
import CustomDataStructures.ResizingList;

/**
 * Maintains a min-first priority queue of CodingUnits, used to constructing the coding tree
 */
public class FeederQueue {
    private MinHeap queue;

    /**
     * Constructor
     * @param codingUnits as ResizingList
     */
    public FeederQueue (ResizingList<CodingUnit> codingUnits) {
        queue = new MinHeap(codingUnits);
    }

    /**
     * Gets and removes the first element of the queue
     * @return the CodingUnit with smallest frequency
     */
    public CodingUnit getFirstInLine() {
        return queue.poll();
    }

    /**
     * Adds a new CodingUnit to queue
     * @param codingUnit CodingUnit to be added
     */
    public void pushIntoQueue(CodingUnit codingUnit) {
        queue.add(codingUnit);
    }

    /**
     * @return true if at least two elements left in the queue, false otherwise, used in tree-building iteration
     */
    public boolean hasAtLeastTwoElementsLeft() {
        return queue.size() >= 2;
    }

    /**
     * @return true if at least one element left, false otherwise, used in tree-building iteration
     */
    public boolean hasStuffLeft() {
        return !queue.isEmpty();
    }

    /**
     * Returns the total number of CodingUnits in the queue, used for testing
     * @return number of elements as int
     */
    public int getTotalNumberOfEntries() {
        return queue.size();
    }

    /**
     * Helper method for testing/debugging
     */
    public void printOutAndClear() {
        System.out.println("-- Feeder queue --");
        int i = 1;
        while (this.hasStuffLeft()) {
            CodingUnit c = queue.poll();
            System.out.println("" + i + " :" + c.toString());
            i++;
        }
        System.out.println("Jono nyt tyhjä");
    }
}
