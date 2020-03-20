package huffmanEngine;

/**
 * Implements a binary tree consisting of CodingUnit nodes
 */
public class CodingTree {
    private static CodingUnit rootNode;

    public static void build() {
        if (FeederQueue.hasStuffLeft()) {
            while (FeederQueue.hasAtLeastTwoElementsLeft()) {
                CodingUnit left = FeederQueue.getFirstInLine();
                CodingUnit right = FeederQueue.getFirstInLine();
                CodingUnit newNode = new CodingUnit(left, right);
                FeederQueue.pushIntoQueue(newNode);
            }
            rootNode = FeederQueue.getFirstInLine();
        }
    }

    public static CodingUnit getRoot() {
        return rootNode;
    }
}
