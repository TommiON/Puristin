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
     * Adds a new CodingUnit to queue
     * @param codingUnit CodingUnit to be added
     */
    public static void pushIntoQueue(CodingUnit codingUnit) { queue.add(codingUnit); }

    /**
     * Tells whether at least two elements left in the queue, used in tree-building iteration
     * @return
     */
    public static boolean hasAtLeastTwoElementsLeft() { return queue.size() >= 2; }

    /**
     * Tells whether elements left in the queue, used in tree-building iteration
     * @return true if at least one element left, false otherwise
     */
    public static boolean hasStuffLeft() {
        return !queue.isEmpty();
    }

    /**
     * Returns the total number of CodingUnits in the queue, used for testing
     * @return number of elements as int
     */
    public static int getTotalNumberOfEntries() {
        return queue.size();
    }

    /**
     * Helper method for testing/debugging
     */
    public static void printOutAndClear() {
        System.out.println("-- Feeder queue --");
        int i = 1;
        while (FeederQueue.hasStuffLeft()) {
            CodingUnit c = queue.poll();
            System.out.println("" + i + " :" + c.toString());
            i++;
        }
        System.out.println("Jono nyt tyhjä");
    }


}
