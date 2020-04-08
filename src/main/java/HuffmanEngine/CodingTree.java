package HuffmanEngine;

/**
 * Binary tree constructor
 */
public class CodingTree {

    /**
     * Constructs a binary tree from a given FeederQueue
     * @param feeder FeederQueue containing the CodingUnits in min-first priority queue
     * @return CodingUnit that is the root of the newly-build tree
     */
    public static CodingUnit buildAndReturnRoot(FeederQueue feeder) {
        // TODO: handle empty queue parameter
        if (feeder.hasStuffLeft()) {
            while (feeder.hasAtLeastTwoElementsLeft()) {
                CodingUnit left = feeder.getFirstInLine();
                CodingUnit right = feeder.getFirstInLine();
                CodingUnit newNode = new CodingUnit(left, right);
                feeder.pushIntoQueue(newNode);
            }
        }
        return feeder.getFirstInLine();
    }
}
