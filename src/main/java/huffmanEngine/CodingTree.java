package huffmanEngine;

/**
 * Implements the binary tree constructor
 */
public class CodingTree {
    private static CodingUnit rootNode;

    public static void buildFrom(FeederQueue feeder) {
        if (feeder.hasStuffLeft()) {
            while (feeder.hasAtLeastTwoElementsLeft()) {
                CodingUnit left = feeder.getFirstInLine();
                CodingUnit right = feeder.getFirstInLine();
                CodingUnit newNode = new CodingUnit(left, right);
                feeder.pushIntoQueue(newNode);
            }
            rootNode = feeder.getFirstInLine();
        }
    }

    public static CodingUnit getRoot() {
        return rootNode;
    }
}
