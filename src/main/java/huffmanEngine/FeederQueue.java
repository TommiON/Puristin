package huffmanEngine;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Maintains a min-first priority queue of CodingUnits, used to constructing the coding tree
 */
public class FeederQueue {
    private static PriorityQueue<CodingUnit> queue;

    /**
     * initializes the queue
     * @param codingUnits list of CodingUnits
     */
    public static void initializeWithCodingUnits(ArrayList<CodingUnit> codingUnits) {
        queue = new PriorityQueue<>(codingUnits);
    }

    /**
     * Gets and removes the first element of the queue
     * @return the CodingUnit with smallest frequency
     */
    public static CodingUnit getFirstInLine() {
        return queue.poll();
    }

    /**
     * Returns the total number of CodingUnits in the queue, used for testing
     * @return number of elements as int
     */
    public static int getTotalNumberOfEntries() {
        return queue.size();
    }

    /**
     * Tells whether elements left in the queue
     * @return true if at least one element left, false otherwise
     */
    public static boolean hasStuffLeft() {
        return !queue.isEmpty();
    }
}
